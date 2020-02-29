import sys, getopt
import subprocess
from parser.SyGuSRewritter import GRewritter
from parser.z3outputparser import z3Parser
from multiprocessing import Process, Array,Manager
import multiprocessing
from ctypes import c_wchar_p
import random 
import os, time, random
import errno
import time

# we assume all args have the same type
def write_solution_to_SMT(argType, funcType, funcName, funcBody, arg_list):
	result = "(define-fun "+funcName+" ("
	for arg in arg_list:
		result += "("+arg+" "+argType+") "
	result += ") " + funcType + " " + funcBody+")\n"
	return result


# this function will read two arguments [fname,candidate_solution]
# fname points to the original sygus problem for extracting specification
# candidate_solution is an SMT term in string
# goal: check if candidate_solution satisfy the specification
# return a counter example if it does not
def verifier(fname,candidate_solution):
    # read the SyGuS file and parse it to SMT query form
    f = open(fname, "r")
    inputStr = f.read()
    f.close()

    # sc_list : [result, sygus_ex,smt_top,smt_spec,len(v.spec_varlist), v.synthName, v.varList]
    # smt_top includes definitions of auxilary functions and variables
    # smt_spec includes the spec assertion in SMT formmat

    sc_list = GRewritter([],inputStr)
    smt_query = sc_list[2]+candidate_solution+"\n"+sc_list[3]
    # run z3 on smt_query
    outname = "tmpSMT/check_candidate_solution.smt"


    if not os.path.exists(os.path.dirname(outname)):
    	try:
        	os.makedirs(os.path.dirname(outname))
    	except OSError as exc: # Guard against race condition
       		if exc.errno != errno.EEXIST:
        		raise

    with open(outname, "w+") as f:
        f.write(smt_query)	
    	f.close()
    #print smt_query
    output = subprocess.check_output(["./z3",outname])
    #print output
    #os.remove(outname)
    smt_varlist = [] 
    for i in range(0,len(sc_list[6])):
    	smt_varlist.append(sc_list[6][i]+"!")
    new_ex_list = z3Parser(smt_varlist, output)
    result = []
    for ex in new_ex_list:
	    result.append(ex)
    row = ""
    for varname in sc_list[6]:
        row += varname +" "
    #print row
    #print result
    return result

def get_output_from_input_examples(smtSpec,funcName,var_list,example_tuple):
	numVar = len(var_list)
	smt_query = ""
	for i in range(0,numVar):
		smt_query = smt_query + "(declare-fun "+var_list[i]+"! () Int)\n"
		smt_query = smt_query + "(assert (= "+var_list[i]+"! "+str(example_tuple[i])+"))\n"
	smt_query = smt_query + "(declare-fun "+funcName+" ("
	for var in var_list:
		smt_query = smt_query + " Int "
	smt_query = smt_query +") Int)\n"
	smt_query = smt_query + "(declare-fun resultF () Int)\n"
	smt_query = smt_query + "(assert (= resultF (" + funcName
	for var in var_list:
		smt_query = smt_query + " " + var+"!" 
	smt_query = smt_query + ")))\n"+smtSpec 
	#print smt_query

    	outname = "tmpSMT/get_output.smt"

    	if not os.path.exists(os.path.dirname(outname)):
    		try:
        		os.makedirs(os.path.dirname(outname))
    		except OSError as exc: # Guard against race condition
       			if exc.errno != errno.EEXIST:
        			raise

	with open(outname, "w+") as f:
		f.write(smt_query)
		f.close()
	#print smt_query
    	output = subprocess.check_output(["./z3",outname])
    	#print output
    	#os.remove(outname)
    	smt_varlist = [] 
	smt_varlist.append("resultF")
    	new_ex_list = z3Parser(smt_varlist, output)
    	result = []
    	for ex in new_ex_list:
		result.append(ex)
	return result[0]

def get_random_example(numEx):
	result = []
	for i in range(0,numEx):
		result.append(random.randrange(-50, 50, 1))
	return result
	

def synthesizer(fname, example_list):
    f = open(fname, "r")
    inputStr = f.read()
    f.close()

    # sc_list : [result, sygus_ex,smt_top,smt_spec,len(v.spec_varlist), v.synthName, v.varList]
    example_list_without_output = []
    for example_tuple in example_list:
    	example_list_without_output.append(example_tuple[:-1])
    #print example_list_without_output
    sygus_script_with_examples = GRewritter(example_list_without_output,inputStr)[1]
    # run ESolver on sygus_script_with_examples
    outname = "tmpSyGuS/"+fname+".sy"


    if not os.path.exists(os.path.dirname(outname)):
    	try:
        	os.makedirs(os.path.dirname(outname))
    	except OSError as exc: # Guard against race condition
       		if exc.errno != errno.EEXIST:
        		raise

    with open(outname, "w+") as f:
        f.write(sygus_script_with_examples)	
    	f.close()
    output = subprocess.check_output(["bash","starexec_run_Default","../../"+outname],cwd="ESolver/bin")
    os.remove(outname)

    result = ""
    is_in_solution_line = 0
    for line in output.splitlines():
        if line[0] == "S":
            is_in_solution_line = 1
            continue
        if is_in_solution_line > 0:
            result += line
            is_in_solution_line += 1
            if is_in_solution_line == 3:
                break
    return result

def write_examples(example_list,var_list):
	    
	outname = "tmpSyGuS/example1.txt"
	with open(outname, "w+") as f:
		line = ""
		for var in var_list:
			line = line + var +" "
		f.write(line+"\n")
		for example_tuple in example_list:
			line = ""
			for example in example_tuple:
				line = line + str(example) + " "
			f.write(line+"\n")
		f.close()
def append_example(example_tuple,var_list):
	    
	outname = "tmpSyGuS/example1.txt"
	with open(outname, "a+") as f:
		line = ""
		for example in example_tuple:
			line = line + str(example) + " "
		f.write(line+"\n")
		f.close()

def NAY(numEx,res_arr,return_dict):
    	output = subprocess.check_output(["python","NAY_Horn/spacer.py", "tmpSyGuS/grammar.sl", "tmpSyGuS/example1.txt"])
    	output = subprocess.check_output(["./z3", "tmp/horn_query.smt"])
	if "sat" in output:
		res_arr[1] = "1"
		return_dict[1] = "1"
		print "---------FINAL RESULT: UNREALIZABLE"
		return
	res_arr[1] = "0"
	return_dict[1] = "0"
	return
	

def CEGIS(input_file_name,example_list,smtSpec,funcName,var_list,res_arr,return_dict):
        candidate_solution = synthesizer(input_file_name,example_list)
	example_tuple = verifier(input_file_name,candidate_solution)
	example_tuple.append(get_output_from_input_examples(sygus_component_list[7],sygus_component_list[5],sygus_component_list[6],example_tuple))
	res_arr[0] = "1"
	return_dict[0] = example_tuple
	return

if __name__ == "__main__":
    input_file_name = sys.argv[1]
    example_list = []
    f = open(input_file_name, "r")
    inputStr = f.read()
    f.close()
    manager = multiprocessing.Manager()
    return_dict = manager.dict()

    # sygus_component_list : [result, sygus_ex,smt_top,smt_spec,len(v.spec_varlist), v.synthName, v.varList]
    sygus_component_list = GRewritter([],inputStr)
    
    
    outname = "tmpSyGuS/grammar.sl"
    with open(outname, "w+") as f:
		f.write(sygus_component_list[8])
		f.close()
    random_example = get_random_example(len(sygus_component_list[6]))
    random_example.append(get_output_from_input_examples(sygus_component_list[7],sygus_component_list[5],sygus_component_list[6],random_example))
    #print random_example
    example_list.append(random_example)
    write_examples(example_list,sygus_component_list[6])

    res_arr = Array(c_wchar_p,2)
    finish = False
    while True:
    	res_arr[0] = None
	res_arr[1] = None
	numEx = len(example_list)
	print example_list
	p_cegis = Process(target=CEGIS, args = (input_file_name,example_list,sygus_component_list[7],sygus_component_list[5],sygus_component_list[6],res_arr,return_dict))
    	p_cegis.start()
    	p_nay = Process(target=NAY, args = (numEx,res_arr,return_dict))
    	p_nay.start()
	# CEGIS return
	i = 0.1
	while True:
		if res_arr[0] !=None:
			print "ESolver return \n"
        	        p_cegis.terminate()
			p_cegis.join()
        	        p_nay.terminate()
			p_nay.join()
			example_list.append(return_dict[0])
			write_examples(example_list,sygus_component_list[6])
        	        break
		if res_arr[1] !=None:
			print "NAY return \n"
                	p_nay.terminate()
			p_nay.join()
			if return_dict[1] == "1":
				finish = True
        	        	p_cegis.terminate()
				p_cegis.join()
				break
			random_example = get_random_example(len(sygus_component_list[6]))
			random_example.append(get_output_from_input_examples(sygus_component_list[7],sygus_component_list[5],sygus_component_list[6],random_example))
    			append_example(example_list,sygus_component_list[6])
			numEx = numEx + 1
    			p_nay = Process(target=NAY, args = (numEx,res_arr,return_dict))
    			p_nay.start()
                	continue
		time.sleep(i)
		i = i + 0.1
	if finish:
		break


