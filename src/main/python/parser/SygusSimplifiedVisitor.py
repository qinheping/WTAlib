# Generated from Sygus.g4 by ANTLR 4.5.1
from antlr4 import *

# This class defines a complete generic visitor for a parse tree produced by SygusParser.


class SygusVisitor(ParseTreeVisitor):

    letList = []
    weightList = []
    argList = []
    ifCount = False
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
        result = "(define-fun "+ctx.SYMBOL().getText()+" " + self.visit(ctx.argList())+" "+ ctx.sortExpr().getText()+ " " + self.visit(ctx.term())+")"
        return result


    # Visit a parse tree produced by SygusParser#funDeclCmd.
    def visitFunDeclCmd(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#sortStar.
    def visitSortStar(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#argList.
    def visitArgList(self, ctx):
        return "(" +self.visit(ctx.symbolSortPairStar())+")"


    # Visit a parse tree produced by SygusParser#symbolSortPairStar.
    def visitSymbolSortPairStar(self, ctx):
        if ctx.getChildCount() == 0:
            return ""
        return self.visit(ctx.symbolSortPairStar()) + " "+self.visit(ctx.symbolSortPair())


    # Visit a parse tree produced by SygusParser#symbolSortPair.
    def visitSymbolSortPair(self, ctx):
        self.argList.append(ctx.SYMBOL().getText())
        return "(" + ctx.SYMBOL().getText() + " "+ ctx.sortExpr().getText() +")"


    # Visit a parse tree produced by SygusParser#application.
    def visitApplication(self, ctx):
        if self.ifCount:
            self.addweight(ctx.SYMBOL().getText())
            print self.weightList
        return "(" + ctx.SYMBOL().getText() + " "+ self.visit(ctx.termStar())+")"


    # Visit a parse tree produced by SygusParser#liter.
    def visitLiter(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#symbol.
    def visitSymbol(self, ctx):
        self.letList
        for letTerm in self.letList:
            if letTerm[0] == ctx.getText():
                return letTerm[1]
        return ctx.getText();


    # Visit a parse tree produced by SygusParser#let.
    def visitLet(self, ctx):
        return self.visitChildren(ctx)


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
        if(ctx.getChildCount() != 0):
            return self.visit(ctx.termStar()) + " "+self.visit(ctx.term())
        return ""


    # Visit a parse tree produced by SygusParser#literal.
    def visitLiteral(self, ctx):
        return ctx.getText()


    # Visit a parse tree produced by SygusParser#ntDefPlus.
    def visitNtDefPlus(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#ntDef.
    def visitNtDef(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#gTermPlus.
    def visitGTermPlus(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#checkSynthCmd.
    def visitCheckSynthCmd(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#constraintCmd.
    def visitConstraintCmd(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#synthFunCmd.
    def visitSynthFunCmd(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#gTermWeighted.
    def visitGTermWeighted(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#literalPlus.
    def visitLiteralPlus(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SygusParser#gTerm.
    def visitGTerm(self, ctx):
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
