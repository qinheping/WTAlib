package parser;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import semirings.Semiring;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class ASTVisitor extends QSygusParserBaseVisitor<ProgramNode> {

    Semiring sr;
    /* gTerm       :   SYMBOL
            |   literal
            |   '(' SYMBOL gTermStar ')'
            |   '(' 'Constant' sortExpr ')'
            |   '(' 'Vairiable' sortExpr ')'
            |   '(' 'InputVariable' sortExpr ')'
            |   '(' 'LocalVariable' sortExpr ')'
            |   letGTerm
            ;
    */
    @Override
    public GTermNode visitGTerm(QSygusParserParser.GTermContext ctx) {
        if(ctx.gTermStar() != null){
            List<GTermNode> children = new ArrayList<GTermNode>();
            QSygusParserParser.GTermStarContext gtermstar= ctx.gTermStar();
            while(gtermstar.gTermStar() !=null){
                children.add(0,visitGTerm(gtermstar.gTerm()));
                gtermstar = gtermstar.gTermStar();
            }
            return new GTermNode(ctx.SYMBOL().getText(),children);
        }
        return new GTermNode(ctx.children.get(0).getText(), null);
    }

    @Override
    public NTNode visitNtDef(QSygusParserParser.NtDefContext ctx) {
        String ntName = ctx.SYMBOL().getText();
        String sort = getSplitedText(ctx.sortExpr());
        List<RuleNode> rules = new ArrayList<RuleNode>();
        QSygusParserParser.GTermPlusContext gtermplus = ctx.gTermPlus();
        while(gtermplus.gTermPlus() != null){
            rules.add(0,visitGTermWeighted(gtermplus.gTermWeighted()));
            gtermplus = gtermplus.gTermPlus();
        }
        rules.add(0,visitGTermWeighted(gtermplus.gTermWeighted()));
        return new NTNode(ntName, sort, rules);
    }

    @Override
    public RuleNode visitGTermWeighted(QSygusParserParser.GTermWeightedContext ctx) {
        List<String> weight = new ArrayList<String>();
        QSygusParserParser.LiteralPlusContext literalPlus = ctx.literalPlus();
        if(ctx.literalPlus()!=null) {
            while (literalPlus.literalPlus() != null) {
                weight.add(0, literalPlus.literal().getText());
                literalPlus = literalPlus.literalPlus();
            }
            weight.add(0, literalPlus.literal().getText());
        }
        return new RuleNode(weight, visitGTerm(ctx.gTerm()));
    }

    @Override
    public GrammarNode visitSynthFunCmd(QSygusParserParser.SynthFunCmdContext ctx) {
        String funName = ctx.SYMBOL().getText();
        String argList = getSplitedText(ctx.argList());

        List<String> argList_list = new ArrayList<>();
        List<SortNode> argSort_list = new ArrayList<>();
        QSygusParserParser.SymbolSortPairStarContext sspsc = ctx.argList().symbolSortPairStar();
        while(sspsc.symbolSortPairStar() != null){
            argList_list.add(0, sspsc.symbolSortPair().SYMBOL().getText());
            argSort_list.add(0, visitSortExpr(sspsc.symbolSortPair().sortExpr()));
            sspsc = sspsc.symbolSortPairStar();
        }

        String sort = getSplitedText(ctx.sortExpr());

        List<NTNode> ntNodes = new ArrayList<NTNode>();
        QSygusParserParser.NtDefPlusContext ntdefPlus = ctx.ntDefPlus();
        while(ntdefPlus.ntDefPlus() != null){
            ntNodes.add(0, visitNtDef(ntdefPlus.ntDef()));
            ntdefPlus = ntdefPlus.ntDefPlus();
        }
        ntNodes.add(0, visitNtDef(ntdefPlus.ntDef()));
        GrammarNode result =  new GrammarNode(funName,argList,sort,ntNodes, argList_list, argSort_list);
        result.setFuncSort_node(visitSortExpr(ctx.sortExpr()));
        return result;
    }

    @Override
    public SortNode visitSortExpr(QSygusParserParser.SortExprContext ctx){
        String type = ctx.getText();
        if(ctx.INTCONST() != null) {
            try{
                return new SortNode(SortNode.BV, Integer.parseInt(ctx.INTCONST().getText()));
            }catch(NumberFormatException e){
                System.out.println("fail to parse sort: " + type);
                return null;
            }
        }
        switch(type){
            case "Bool":
                return new SortNode(SortNode.BOOL);
            case "Int":
                return new SortNode(SortNode.INT);
            case "Real":
                return new SortNode(SortNode.REAL);
            default:
                System.out.println("fail to parse sort: " + type);
                return null;
        }
    }


    @Override
    public OptimizationNode visitWeightOptimizationCmd(QSygusParserParser.WeightOptimizationCmdContext ctx){
        String flag = null;
        List<String> weightTuple = new ArrayList<String>();
        QSygusParserParser.WeightPairContext weightpair = ctx.weightPair();
        if(weightpair.symbolPlus() != null){
            flag = weightpair.SYMBOL().getText();
            QSygusParserParser.SymbolPlusContext symbolPlus = weightpair.symbolPlus();
            while(symbolPlus.symbolPlus()!= null){
                weightTuple.add(0,symbolPlus.SYMBOL().getText());
                symbolPlus = symbolPlus.symbolPlus();
            }
            weightTuple.add(0,symbolPlus.SYMBOL().getText());
            return new OptimizationNode(flag, weightTuple);
        }
        weightTuple.add(weightpair.SYMBOL().getText());
        return new OptimizationNode(flag, weightTuple);
    }

    @Override
    public ProgramNode visitProg(QSygusParserParser.ProgContext ctx) {
        List<QSygusNode.Tuple<String,String>> semirings = new ArrayList<QSygusNode.Tuple<String,String>>();
        QSygusParserParser.WeightPlusContext weightplus = ctx.setWeightCmd().weightPlus();
        while(weightplus.weightPlus() != null){
            semirings.add(0, new  QSygusNode.Tuple<String, String>(weightplus.SYMBOL().getText(),weightplus.weight().getText()));
            weightplus = weightplus.weightPlus();
        }
        semirings.add(0,new QSygusNode.Tuple<String, String>(weightplus.SYMBOL().getText(),weightplus.weight().getText()));
        List<String> preCmds = new ArrayList<String>();
        List<String> postCmds = new ArrayList<String>();
        GrammarNode synthFun = null;
        TermNode weightConstraint = null;
        OptimizationNode weightOpt = null;

        QSygusParserParser.CmdPlusContext cmdPlus = ctx.cmdPlus();
        Boolean post = true;

        while(cmdPlus.cmdPlus() != null){
            if(cmdPlus.cmd().synthFunCmd() != null){
                synthFun = visitSynthFunCmd(cmdPlus.cmd().synthFunCmd());
                post = false;
                cmdPlus = cmdPlus.cmdPlus();
                continue;
            }

            if(cmdPlus.cmd().weightConstraintCmd() != null){
                weightConstraint = visitTerm(cmdPlus.cmd().weightConstraintCmd().term());
                cmdPlus = cmdPlus.cmdPlus();
                continue;
            }

            if(cmdPlus.cmd().weightOptimizationCmd() !=null){
                weightOpt = visitWeightOptimizationCmd(cmdPlus.cmd().weightOptimizationCmd());
                cmdPlus = cmdPlus.cmdPlus();
                continue;
            }
            if(!post)
                preCmds.add(0,getSplitedText(cmdPlus.cmd()));
            else
                postCmds.add(0,getSplitedText(cmdPlus.cmd()));
            cmdPlus = cmdPlus.cmdPlus();
        }
        preCmds.add(0,getSplitedText(cmdPlus.cmd()));

        return new QSygusNode(preCmds, postCmds, synthFun, semirings, weightConstraint, weightOpt);

    }



    @Override
    public TermNode visitTerm(QSygusParserParser.TermContext ctx) {
        String symbol;
        List<TermNode> children = new ArrayList<TermNode>();
        if(ctx.termStar() != null){
            symbol = ctx.SYMBOL().getText();
            QSygusParserParser.TermStarContext termStart = ctx.termStar();
            while(termStart.termStar() != null){
                children.add(0,visitTerm(termStart.term()));
                termStart = termStart.termStar();
            }
        }else{
            symbol = ctx.children.get(0).getText();
        }
        return new TermNode(symbol, children);
    }
    @Override
    public TermNode visitFunDefCmd(QSygusParserParser.FunDefCmdContext ctx){
        return visitTerm(ctx.term());
    }


    public String getSplitedText(ParseTree ctx){
        String result = "";
        if(ctx.getChildCount() != 0) {
            for (int i = 0; i < ctx.getChildCount(); i++) {
                result = result + " " + getSplitedText(ctx.getChild(i));
            }
        }else{
            return ctx.getText();
        }
        return result;
    }
}
