import sys
from antlr4 import *
from SygusLexer import SygusLexer
from SygusParser import SygusParser
from SygusVisitor import SygusVisitor
import glob, os

# not in use
# check testIntParser
def main(argv):
    os.chdir("../output/CLIA_all")

    for fileName in glob.glob("*"):
        file = open(fileName, "r")
        file.readline()
        input = InputStream(file.readline())
        file.close()
        lexer = SygusLexer(input)
        stream = CommonTokenStream(lexer)
        parser = SygusParser(stream)
        tree = parser.funDefCmd()

        v = SygusVisitor()
        v.weightList = []
        v.letList = []
        v.argList = []
        v.ifCount = False
        newOut =  v.visit(tree)

        input = InputStream(newOut)
        lexer = SygusLexer(input)
        stream = CommonTokenStream(lexer)
        parser = SygusParser(stream)
        tree = parser.funDefCmd()
        v = SygusVisitor()
        v.weightList = []
        v.letList = []
        v.argList = []
        v.ifCount = True
        fileout = open("../CLIA_weight/"+fileName,"w")
        result = v.visit(tree)
        for weightItem in v.weightList:
            if weightItem[0] == "ite":
                fileout.write(weightItem[0] + ": "+str(weightItem[1])+"\n")
        for arg in v.argList:
            fileout.write(arg+ " ")
        fileout.write("\n")
        fileout.write(result)
        fileout.close()

if __name__ == '__main__':
    main(sys.argv)
