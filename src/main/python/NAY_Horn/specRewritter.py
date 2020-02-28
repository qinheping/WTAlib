import sys
from antlr4 import *
from SygusLexer import SygusLexer
from SygusParser import SygusParser
from SyGuSToCVisitor import SygusVisitor
import glob, os

# this parser parses a sygus file and reduce it to a verify problem in C
# no in use
def GRewritter(numEx,inputStr):
    #os.chdir("../CLIA")

    #for fileName in glob.glob("*"):
    #file = open(fileName, "r")
    #file.close()


    input = InputStream(inputStr)
    lexer = SygusLexer(input)
    stream = CommonTokenStream(lexer)
    parser = SygusParser(stream)
    tree = parser.cmdPlus()
    print tree.getText()
    v = SygusVisitor()
    v.num_ex = numEx
    out =  v.visit(tree)

    result = "\ntypedef _Bool bool;\nextern void __VERIFIER_error (void);\nextern int __VERIFIER_nondet_int();\n"
    for i in range(0, v.num_ex):
        result += "int I_" + str(i) + " = -1;\n"
    result += v.header + "\n"
    result += v.result + "\n"
    result += "bool spec" + v.get_application_def_I() + "{\n}\n"
    result += "int main(){\n"
    for i in range(0,v.num_ex):
        for var in v.varList:
            result += "int " + var + "_" + str(i) + " = 0;\n"
        result +="\n"
    result += "Start" + v.get_application() +";\n"
    for i in range(0,v.num_ex):
        result += "bool spec_out_" + str(i) + " = spec" + v.get_application_I(i)  + ";\n"
    result += "(void)(("
    for i in range(0, v.num_ex):
        result += "!spec_out_" + str(i) + "||"
    result = result[0:len(result)-2]+")||(__VERIFIER_error (), 0));\n}"
    print result


# test
if __name__ == '__main__':
    GRewritter(2,"(set-logic LIA)(synth-fun findIdx ( (y1 Int) (y2 Int) (y3 Int) (y4 Int) (y5 Int) (y6 Int) (y7 Int) (y8 Int) (y9 Int) (y10 Int) (y11 Int) (y12 Int) (y13 Int) (y14 Int) (y15 Int) (k1 Int)) Int ((Start Int (0 16 y1 y2 y3 y4 y5 y6 y7 y8 y9 y10 y11 y12 y13 y14 y15 k1 (+ Start Start) (ite B Start Start) ))(B Bool ( (= NT0 NT0) (>= NT0 NT0)))))(declare-var x Int ) (declare-var y Int )(constraint   ( iteB  ( >= x 5 ) ( = ( ex x y ) ( plus3 (five-times x ) (three-times y) 17 ) ) ( = (ex x y ) ( plus2 (three-times x) 1 ) ) ) )(check-synth)")
