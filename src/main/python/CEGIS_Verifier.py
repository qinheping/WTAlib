import sys, getopt
import subprocess
from parser.SyGuSRewritter import GRewritter
from parser.z3outputparser import z3Parser
from multiprocessing import Process, Array

import os, time, random
import errno

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
    outname = "tmpSMT/"+fname+".smt"


    if not os.path.exists(os.path.dirname(outname)):
    	try:
        	os.makedirs(os.path.dirname(outname))
    	except OSError as exc: # Guard against race condition
       		if exc.errno != errno.EEXIST:
        		raise

    with open(outname, "w+") as f:
        f.write(smt_query)	
    	f.close()
    print smt_query
    output = subprocess.check_output(["z3",outname])
    os.remove(outname)
    smt_varlist = [] 
    for i in range(0,len(sc_list[6])):
    	smt_varlist.append(sc_list[6][i]+"!")
    new_ex_list = z3Parser(smt_varlist, output)
    result = []
    for ex in new_ex_list:
	    result.append(ex)
    print result
    return result


def synthesizer(fname, example_list):
    f = open(fname, "r")
    inputStr = f.read()
    f.close()

    # sc_list : [result, sygus_ex,smt_top,smt_spec,len(v.spec_varlist), v.synthName, v.varList]

    sygus_script_with_examples = GRewritter(example_list,inputStr)[1]
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
    
if __name__ == "__main__":
    input_file_name = sys.argv[1]
    example_list = []
    while True:
        candidate_solution = synthesizer(input_file_name,example_list)
        print candidate_solution
        example_list.append(verifier(input_file_name,candidate_solution))
        print example_list
