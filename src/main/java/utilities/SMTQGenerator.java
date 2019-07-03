package utilities;

import edu.nyu.acsys.CVC4.Expr;
import semirings.LinearSet;

import java.lang.Integer;
import java.util.*;
import edu.nyu.acsys.CVC4.*;


public class SMTQGenerator {

    static ExprManager em = new ExprManager();
    static SmtEngine smt = new SmtEngine(em);
    static Type integer = em.integerType();
    static Type bool = em.booleanType();
    public static String genearteSimpleSMTQ(Set<LinearSet> sls, Vector<Integer> target){
        String result = "(assert (or ";
        for(LinearSet sl : sls){
            result += "(and ";
            for(int i = 0; i < target.size(); i++){
                result += "(= "+ target.get(i)+" "+sl.getBase().get(i)+")";
            }
            result +=")";
        }
        result +=")) (check-sat)";
        return  result;
    }

    static int count = 0;
    public static boolean checkSat(Vector<Integer> spec, Set<LinearSet> start) {
        count = 0;
        Iterator<LinearSet> iterator = start.iterator();
        while(iterator.hasNext()){
            if(checkInLinearSet(spec,iterator.next())) {
                //System.out.print(spec+" "+ls);
                return true;
            }
            iterator.remove();
            //System.out.println(" start next Q");
        }
        return false;
    }
    public static Boolean checkInLinearSet(Vector<Integer> target, LinearSet ls){
        count++;
        if(count%10000 ==0 ){
            System.out.print(count+" :");

        }
        int dim = target.size();
        Expr body = em.mkConst(true);
        Expr zero = em.mkConst(new Rational(0));
        Expr assert_nature = em.mkConst(true);
        List<Vector<Integer>> peroid_list = new ArrayList<>(ls.getPeriod());

        List<Expr> bound_vars = new ArrayList<>();
        for(int i = 0; i < ls.getPeriod().size();i++){
                bound_vars.add(em.mkVar("z"+"_"+i,integer));
                assert_nature = em.mkExpr(Kind.AND,assert_nature,em.mkExpr(Kind.GEQ,bound_vars.get(i),zero));

        }

        body = assert_nature;

        for(int j = 0; j < dim; j++){
            Expr body_j = em.mkConst(new Rational(ls.getBase().get(j)));
            for(int i = 0; i < ls.getPeriod().size(); i++){
                body_j = em.mkExpr(Kind.PLUS,body_j,em.mkExpr(Kind.MULT,bound_vars.get(i),em.mkConst(new Rational(peroid_list.get(i).get(j)))));
            }
            body_j = em.mkExpr(Kind.EQUAL,body_j,em.mkConst(new Rational(target.get(j))));
            body = em.mkExpr(Kind.AND, body,body_j);
        }
        //System.runFinalization();
        //System.out.print("body got: ");
        //System.out.println(body);
        return smt.checkSat(body).toString().equals("sat");
    }

    public static Set<Vector<Boolean>> getBVSet(Set<LinearSet> left, Set<LinearSet> right, String bop) {
        Set<Vector<Boolean>> result = new HashSet<>();
        List<LinearSet> leftList = new ArrayList<>(left);
        List<LinearSet> rightList = new ArrayList<>(right);
        if(leftList.size() == 0 || rightList.size() == 0)
            return result;

        int dim = leftList.get(0).getBase().size();
        Vector<Boolean> currentBv = new Vector();
        return getBVSet_recursion(leftList,rightList,bop,dim,result,currentBv);
    }

    private static Set<Vector<Boolean>> getBVSet_recursion(List<LinearSet> left, List<LinearSet> right, String bop, int remain, Set<Vector<Boolean>> result, Vector<Boolean> currentBv) {
       for(LinearSet leftLS:left){
           for(LinearSet rightLS:right){
               result.addAll(getBVSet_recursion(leftLS,rightLS,bop,remain,result,currentBv));

               if(result.size()==Math.pow(2,left.get(0).getBase().size()))
                   return result;
           }
       }
       return result;
    }

    private static Set<Vector<Boolean>> getBVSet_recursion(LinearSet left, LinearSet right, String bop, int remain, Set<Vector<Boolean>> result, Vector<Boolean> currentBv) {
        if(remain != 0){
            Vector<Boolean> currentBv_T = new Vector(currentBv);
            currentBv_T .add(true);
            Vector<Boolean> currentBv_F = new Vector(currentBv);
            currentBv_F.add(false);
            result.addAll(getBVSet_recursion(left, right, bop, remain-1, result, currentBv_T));
            result.addAll(getBVSet_recursion(left, right, bop, remain-1, result, currentBv_F));
            return  result;
        }
        if(result.contains(currentBv))
            return result;

        int dim = currentBv.size();
        if(result.size()==Math.pow(2,dim))
            return result;

        Expr body = em.mkConst(true);
        // body = true /\ (z = bx1 + x*px1 \/ z = bx2 + x*px2 \/ ...) /\ (z bop by1 + y*py1 \/ ..)
        //                        z \in left                                   z bop z' \in right

        List<List<Expr>> boundx_list = new ArrayList<>();
        List<List<Expr>> boundy_list = new ArrayList<>();

        Expr assertx = em.mkConst(true);
        Expr asserty = em.mkConst(true);
        Expr zero = em.mkConst(new Rational(0));

        List<Vector<Integer>> period_list_x = new ArrayList<>(left.getPeriod());
        List<Vector<Integer>> period_list_y = new ArrayList<>(right.getPeriod());

        for(int ix = 0; ix < left.getPeriod().size(); ix++  ){
            boundx_list.add(new ArrayList<>());

            for(int d = 0; d < dim; d++){;
                    boundx_list.get(ix).add(em.mkVar("x_"+ix+"_"+"d",integer));
                    assertx = em.mkExpr(Kind.AND,assertx,em.mkExpr(Kind.GEQ,boundx_list.get(ix).get(d),zero));
            }
        }

        for(int iy = 0; iy < right.getPeriod().size(); iy++  ){
            boundy_list.add(new ArrayList<>());

            for(int d = 0; d < dim; d++){;
                boundy_list.get(iy).add(em.mkVar("y_"+iy+"_"+"d",integer));
                asserty = em.mkExpr(Kind.AND,asserty,em.mkExpr(Kind.GEQ,boundy_list.get(iy).get(d),zero));
            }
        }

        for(int d = 0; d < dim; d++){
            Expr body_left = em.mkConst(new Rational(left.getBase().get(d)));
            Expr body_right = em.mkConst(new Rational(right.getBase().get(d)));
            for(int i = 0; i < period_list_x.size();i++){
                body_left = em.mkExpr(Kind.PLUS,body_left,em.mkExpr(Kind.MULT,boundx_list.get(i).get(d),em.mkConst(new Rational(period_list_x.get(i).get(d)))));
            }
            for(int i = 0; i < period_list_y.size();i++){
                body_right = em.mkExpr(Kind.PLUS,body_right,em.mkExpr(Kind.MULT,boundy_list.get(i).get(d),em.mkConst(new Rational(period_list_y.get(i).get(d)))));
            }
            if(currentBv.get(d))
            body =em.mkExpr(Kind.AND,body,em.mkExpr(parse_bop(bop),body_left,body_right));
            else
                body =em.mkExpr(Kind.AND,body,em.mkExpr(Kind.NOT,em.mkExpr(parse_bop(bop),body_left,body_right)));
        }

        body = em.mkExpr(Kind.AND,body,assertx);
        body = em.mkExpr(Kind.AND,body,asserty);
        body.

        if(smt.checkSat(body).toString().equals("sat")) {
            // System.out.println("SAT: "+currentBv+" "+body);
            result.add(currentBv);
        }

        return result;
    }

    private static Kind parse_bop(String bop){
        switch (bop){
            case "<":return Kind.LT;
            case ">":return Kind.GT;
            case "<=":return Kind.LEQ;
            case ">=":return Kind.GEQ;
            case "=":
            case "==":return Kind.EQUAL;
        }
        return  null;
    }

}
