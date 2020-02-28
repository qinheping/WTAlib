# Generated from Sygus.g4 by ANTLR 4.5.1
from antlr4 import *
import math

# This class defines a complete generic visitor for a parse tree produced by SygusParser.


class SygusVisitor(ParseTreeVisitor):
    header = ""
    result = ""
    funDef = ""
    spec = ""
    type = "int"
    num_ex = 10
    inSynth = 0
    # varlist of the synthFun
    varList = []
    
    # varlist of the current fundef
    fundef_varlist = []
    inConstraint = 0
	
    # varlist of constraint
    spec_varlist = []

    # example list used to subtitute constraint
    ex_list = []
    sygus_ex = ""
    source = ""    
    regEx_term = ""
    regEx_term_star = []
    currentEx = 0

    # reg for visit term
    reg_term = ""
    reg_term_star = []
    # name of the function we are synthesizing
    synthName = ""
    findDef = 0

    #
    smt_spec = ""
    regSMT_term = ""
    regSMT_term_star = []


    def hex_to_dec(self,hex):
        if(hex == "f" or hex == "F"):
            return 15
        if(hex == "e" or hex == "E"):
            return 14
        if(hex == "d" or hex == "D"):
            return 13
        if(hex == "c" or hex == "C"):
            return 12
        if(hex == "b" or hex == "B"):
            return 11
        if(hex == "a" or hex == "A"):
            return 10
        return int(hex)

    def bv_to_unsigned(self,bv):
        bv = bv[2:]
        result = 0;
        for i in range(0,8):
            result += math.pow(16,7-i) * self.hex_to_dec(bv[i])
        return result

    def get_application_def(self):
        result = "("
        for i in range(0,self.num_ex):
            for var in self.varList:
                result+=self.type + " " +var+"_"+str(i)+","
        result = result[:len(result)-1]+")"
        return  result



    def get_application(self):
        result = "("
        for i in range(0,self.num_ex):
            for var in self.varList:
                result+=var+"_"+str(i)+","
        result = result[:len(result)-1]+")"
        return  result

    def get_application_I(self,i):
        result = "("
        for var in self.varList:
            result+=var+"_"+str(i)+","
        result = result[:len(result)-1]+",I_"+str(i)+")"
        return  result

    def get_application_def_I(self):
        result ="("
        for var in self.varList:
            result+=self.type + " " +var+","
        result = result[:len(result)-1]+"," + self.type + " f)"
        return  result

    def get_application_spec(self):
        result ="("
        for var in self.spec_varlist:
            result+=self.type + " " +var+","
        result = result[:len(result)-1]+"," + self.type + " f_OUT)"
        return  result

    def get_op(self,symbol):
        if(symbol == "bvnot"):
            return "!"
        if(symbol == "bvneg"):
            return "~"
        if(symbol == "bvxor"):
            return "^"
        if(symbol == "bvand"):
            return "&"
        if(symbol == "bvor"):
            return "|"
        if(symbol == "bvadd"):
            return "+"
        if(symbol == "bvsub"):
            return "-"
        if(symbol == "bvlshr"):
            return ">>"
        if(symbol == "bvshl"):
            return "<<"
        if(symbol == "+" or symbol == "-" or symbol == "*" or symbol == "/"):
            return symbol
        if(symbol == "and"):
            return "&&"
        if(symbol == "or"):
            return "||"
        if(symbol == "not"):
            return "!"
        if(symbol == "="):
            return "=="
        return ""


    def get_type(self,symbol):
	if(symbol == "Bool"):
		return "bool";
	if(symbol == "Int"):
		return "int";
	return symbol

    # Visit a parse tree produced by SygusParser#start.
    def visitStart(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#prog.
    def visitProg(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#setLogicCmd.
    def visitSetLogicCmd(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#weightPlus.
    def visitWeightPlus(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#weight.
    def visitWeight(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#setWeightCmd.
    def visitSetWeightCmd(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#cmdPlus.
    def visitCmdPlus(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#cmd.
    def visitCmd(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#weightOptimizationCmd.
    def visitWeightOptimizationCmd(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#weightPair.
    def visitWeightPair(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#weightConstraintCmd.
    def visitWeightConstraintCmd(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#varDeclCmd.
    def visitVarDeclCmd(self, ctx):
        self.inSynth = 0
        self.spec_varlist.append(ctx.SYMBOL().getText())
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#sortDefCmd.
    def visitSortDefCmd(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#sortExpr.
    def visitSortExpr(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#boolConst.
    def visitBoolConst(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#enumConst.
    def visitEnumConst(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#ecList.
    def visitEcList(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#symbolPlus.
    def visitSymbolPlus(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#setOptsCmd.
    def visitSetOptsCmd(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#optList.
    def visitOptList(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#symbolPairPlus.
    def visitSymbolPairPlus(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#symbolPair.
    def visitSymbolPair(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#funDefCmd.
    def visitFunDefCmd(self, ctx):
        funType = self.get_type(ctx.sortExpr().getText())
        self.visitChildren(ctx)
        self.funDef +=funType + " "+ctx.SYMBOL().getText()+"("
        for i in range(0,len(self.fundef_varlist)):
            self.funDef += self.fundef_varlist[i][0]+ " "+self.fundef_varlist[i][1]
            if i != len(self.fundef_varlist)-1:
                self.funDef += ", "
        self.funDef+="){\n"
        self.visit(ctx.term())
        self.funDef+= "\treturn "+self.reg_term+";\n"
        self.funDef+="}\n"
        return ""


    # Visit a parse tree produced by SygusParser#funDeclCmd.
    def visitFunDeclCmd(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#sortStar.
    def visitSortStar(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#argList.
    def visitArgList(self, ctx):
        self.fundef_varlist = []
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#symbolSortPairStar.
    def visitSymbolSortPairStar(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#symbolSortPair.
    def visitSymbolSortPair(self, ctx):
        if self.inSynth:
            self.varList.append(ctx.SYMBOL().getText())
        else:
            self.fundef_varlist.append([self.get_type(ctx.sortExpr().getText()),ctx.SYMBOL().getText()])
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#application.
    def visitApplication(self, ctx):
        self.reg_term_star = []
        self.regEx_term_star = []
        self.visitChildren(ctx)

        self.regEx_term = "(" + ctx.SYMBOL().getText() +" "
        for i in range(0,len(self.regEx_term_star)):
            self.regEx_term +=self.regEx_term_star[i]+" "
        self.regEx_term += ")"
        self.regEx_term_star = []

        self.regSMT_term = "(" + ctx.SYMBOL().getText() + " "
        for i in range(0,len(self.regSMT_term_star)):
            self.regSMT_term += self.regSMT_term_star[i] + " "
        self.regSMT_term += ")"
        self.regSMT_term_star = []

        if ctx.SYMBOL().getText() == self.synthName and self.inConstraint == 1:
            self.reg_term = "f_OUT"
            return 1

        if self.get_op(ctx.SYMBOL().getText()) == "":
            self.reg_term = "("+ctx.SYMBOL().getText()+"("
            for i in range(0,len(self.reg_term_star)):
                self.reg_term += self.reg_term_star[i]
                if i != len(self.reg_term_star)-1:
                     self.reg_term +=", "
            self.reg_term += "))"
            self.reg_term_star = []
            return 1
        if len(self.reg_term_star) == 2:
            self.reg_term = "(" + self.reg_term_star[0]+self.get_op(ctx.SYMBOL().getText()) +self.reg_term_star[1]+")"
        else:
            self.reg_term = "("+self.get_op(ctx.SYMBOL().getText()) +self.reg_term_star[0]+")"
        self.reg_term_star = []

        
        return 1

    # Visit a parse tree produced by SygusParser#liter.
    def visitLiter(self, ctx):
        self.reg_term = ctx.literal().getText()
        self.regEx_term = ctx.literal().getText()
        self.regSMT_term = ctx.literal().getText()
        return 1


    # Visit a parse tree produced by SygusParser#symbol.
    def visitSymbol(self, ctx):
        self.reg_term = ctx.SYMBOL().getText()
        self.regSMT_term = ctx.SYMBOL().getText()+"!"
        for i in range(0, len(self.spec_varlist)):
            if ctx.SYMBOL().getText() ==self.spec_varlist[i]:
                self.regEx_term = self.ex_list[self.currentEx][i]
                return 1
        self.regEx_term = ctx.SYMBOL().getText()
        return 1


    # Visit a parse tree produced by SygusParser#let.
    def visitLet(self, ctx):
        return 1

    # Visit a parse tree produced by SygusParser#letTerm.
    def visitLetTerm(self, ctx):
        self.visit(ctx.letBindingTermPlus())
        return self.visit(ctx.term())


    # Visit a parse tree produced by SygusParser#letBindingTermPlus.
    def visitLetBindingTermPlus(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#letBindingTerm.
    def visitLetBindingTerm(self, ctx):

        self.letList.append([ctx.SYMBOL().getText(), self.visit(ctx.term())])
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#termStar.
    def visitTermStar(self, ctx):
        temp_star = []
        tempEx_star = []
        tempSMT_star = []
        if ctx.termStar() != None: 
            self.visit(ctx.termStar())
            temp_star.extend(self.reg_term_star)
            tempEx_star.extend(self.regEx_term_star)
            tempSMT_star.extend(self.regSMT_term_star)

            self.visit(ctx.term())
            tempEx_star.append(self.regEx_term)
            temp_star.append(self.reg_term)
            tempSMT_star.append(self.regSMT_term)

            self.reg_term_star = temp_star
            self.regEx_term_star = tempEx_star
            self.regSMT_term_star = tempSMT_star
        else:
            self.reg_term_star = []
            self.regEx_term_star = []
            self.regSMT_term_star = []

        return ""


    # Visit a parse tree produced by SygusParser#literal.
    def visitLiteral(self, ctx):
        return ctx.getText()


    # Visit a parse tree produced by SygusParser#ntDefPlus.
    def visitNtDefPlus(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#ntDef.
    def visitNtDef(self, ctx):
        self.header +=  "void  " + ctx.SYMBOL().getText() + self.get_application_def() + ";\n"
        self.result += "void " + ctx.SYMBOL().getText() + self.get_application_def() + "{\n"
        self.visitChildren(ctx)
        self.result += "}\n"
        return ""


    # Visit a parse tree produced by SygusParser#gTermPlus.
    def visitGTermPlus(self, ctx):

        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#checkSynthCmd.
    def visitCheckSynthCmd(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#constraintCmd.
    def visitConstraintCmd(self, ctx):
        if(self.ex_list == []):
            temp_list = []
            for i in range(0,len(self.spec_varlist)):
                temp_list.append("0")
            self.ex_list.append(temp_list)

        self.inConstraint = 1
        self.visitChildren(ctx)
        self.spec+="\tif(!"+self.reg_term+")\n\t\t return 0;\n"
        self.smt_spec +="(not " + self.regSMT_term +") "
        for l in range(0,len(self.ex_list)):
            self.currentEx = l
            self.visitChildren(ctx)
            self.sygus_ex+="(constraint "+self.regEx_term+")\n"
        self.inConstraint = 0
        return 1


    # Visit a parse tree produced by SygusParser#synthFunCmd.
    def visitSynthFunCmd(self, ctx):
        self.inSynth = 1
        self.synthName = ctx.SYMBOL().getText()
        self.visitChildren(ctx)
        self.inSynth = 0
        return ""


    # Visit a parse tree produced by SygusParser#gTermWeighted.
    def visitGTermWeighted(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#literalPlus.
    def visitLiteralPlus(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#gTerm.
    def visitGTerm(self, ctx):
        if self.inSynth == 0:
            return ""
        if ctx.gTermStar() != None:
            gtstar = ctx.gTermStar()
            children = []
            while gtstar.gTerm() != None:
                children.append(gtstar.gTerm().SYMBOL().getText())
                gtstar = gtstar.gTermStar()
            self.result += "\tif(__VERIFIER_nondet_int()){\n"
            for i in range(0, len(children)):
                self.result += "\t\t" + children[len(children)-i-1] + self.get_application() + ";\n"
                for j in range(0,self.num_ex):
                    self.result += "\t\t" + self.type +" temp_" + str(len(children)-i-1) + "_" + str(j) + " = I_" + str(j) + ";\n"

            for j in range(0,self.num_ex):
                if len(children) == 3:
                    self.result += "\t\tif(temp_2_"+str(j)+") {I_"+str(j)+"=temp_1_"+str(j)+";} else {I_"+str(j)+"=temp_0_"+str(j)+";}\n"
                if len(children) == 2:
                    self.result += "\t\tI_" + str(j) + " = temp_0_" + str(j) + self.get_op(ctx.SYMBOL().getText()) + "temp_1_" + str(j) +";\n"
                if len(children) == 1:
                    self.result += "\t\tI_" + str(j) + " = " + self.get_op(ctx.SYMBOL().getText()) + "temp_0_" + str(j) +";\n"
            self.result += "\t\t return;}\n"

            return ""


        if ctx.SYMBOL() != None:
            self.result += "\tif(__VERIFIER_nondet_int()){\n"
            for i in range(0,self.num_ex):
                self.result += "\t\tI_"+ str(i) + " = " + ctx.SYMBOL().getText() + "_" + str(i) +";\n"
            self.result += "\t\treturn;}\n"
            return ""

        if ctx.literal() != None:
            self.result += "\tif(__VERIFIER_nondet_int()){\n"
            for i in range(0,self.num_ex):
                if self.type == "u32":
                    self.result += "\t\tI_"+ str(i) + " = " + str(int(self.bv_to_unsigned(ctx.literal().getText()))) + ";\n"
                else:
                    self.result += "\t\tI_"+ str(i) + " = " + ctx.literal().getText() + ";\n"
            self.result += "\t\treturn;}\n"
            return ""
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#letGTerm.
    def visitLetGTerm(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#letBindingGTermPlus.
    def visitLetBindingGTermPlus(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#letBindingGTerm.
    def visitLetBindingGTerm(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#gTermStar.
    def visitGTermStar(self, ctx):
        return self.visitChildren(ctx)

    def addweight(self, symbol):
        for i in range(0,len(self.weightList)):
            if self.weightList[i][0] == symbol:
                self.weightList[i][1] = self.weightList[i][1]+1
                return
        self.weightList.append([symbol,1])
