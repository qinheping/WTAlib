import sys
from antlr4 import *
from SygusLexer import SygusLexer
from SygusParser import SygusParser
from spacerVisitor import SpacerVisitor
import glob, os

# read a sygus problem
# and an example file where the first line and the last column should be ignored
# python spacer.py fileName exampleFile
def main(argv):
    # read sygus file
    fileName_sygus = argv[1]
    file_sygus = open(fileName_sygus, "r")
    input = InputStream(file_sygus.read())
    file_sygus.close()
    lexer = SygusLexer(input)
    stream = CommonTokenStream(lexer)
    parser = SygusParser(stream)
    tree = parser.cmdPlus()
    # example file
    fileName_example = argv[2]
    file_example = open(fileName_example, "r")
    file_example.readline()
    lines = file_example.readlines()
    file_example.close()
    list_example = []
    for line in lines:
        list_example.append(line.split()[:-1])

    v = SpacerVisitor()
    v.ex_list = list_example
    v.visit(tree) 
    print v.header
    print v.spec
    print v.result


    # todo initial v
    # read cex file


if __name__ == '__main__':
    main(sys.argv)
