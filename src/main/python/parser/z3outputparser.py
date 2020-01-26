import sys

def z3Parser(varlist,inputStr):
    ifsat = 0
    current_var = -1
    result = []
    print inputStr
    for i in range(0,len(varlist)):
        result.append("0")
    for line in inputStr.splitlines():
        if(line[0:3]=="sat"):
            ifsat = 1
        if current_var != -1:
            result[current_var] = (line[0:len(line)-1] ).strip()
            current_var = -1

        for i in range(0,len(varlist)):
            if line.find(varlist[i])!=-1:
                current_var = i
    if ifsat !=0:
        return result
    return []

# test
if __name__ == '__main__':
   z3Parser(["x!","y!","z!"],"sat\n(model \n  (define-fun x! () Int\n    0)\n  (define-fun z! () Int\n    0)\n  (define-fun y! () Int\n    (- 1))\n)")
