package utilities;

import edu.nyu.acsys.CVC4.Expr;
import edu.nyu.acsys.CVC4.ExprManager;
import edu.nyu.acsys.CVC4.SExpr;
import edu.nyu.acsys.CVC4.SmtEngine;
import parser.TermNode;
import semirings.LinearSet;

import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class ConstraintSolver {
    public static boolean solveConstraint(Set<LinearSet> solution, TermNode constraint, Map<String, Vector<Integer>> examples, Map<String, TermNode> auxFuncs, String synthName){
        System.loadLibrary("cvc4jni");

        ExprManager em = new ExprManager();
        SmtEngine smt = new SmtEngine(em);
        smt.setOption("produce-models", new SExpr(true));

        // main query
        Expr q = em.mkConst(true);

        return false;
    }
}
