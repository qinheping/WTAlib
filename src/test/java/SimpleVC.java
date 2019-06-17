/*********************                                                        */
/*! \file SimpleVC.java
 ** \verbatim
 ** Top contributors (to current version):
 **   Morgan Deters
 ** This file is part of the CVC4 project.
 ** Copyright (c) 2009-2019 by the authors listed in the file AUTHORS
 ** in the top-level source directory) and their institutional affiliations.
 ** All rights reserved.  See the file COPYING in the top-level source
 ** directory for licensing information.\endverbatim
 **
 ** \brief A simple demonstration of the Java interface
 **
 ** A simple demonstration of the Java interface.
 **
 ** To run the resulting class file, you need to do something like the
 ** following:
 **
 **   java \
 **     -classpath path/to/CVC4.jar \
 **     -Djava.library.path=/dir/containing/java/CVC4.so \
 **     SimpleVC
 **
 ** For example, if you are building CVC4 without specifying your own
 ** build directory, the build process puts everything in builds/, and
 ** you can run this example (after building it with "make") like this:
 **
 **   java \
 **     -classpath builds/examples:builds/src/bindings/CVC4.jar \
 **     -Djava.library.path=builds/src/bindings/java/.libs \
 **     SimpleVC
 **/

import edu.nyu.acsys.CVC4.*;

import java.util.Map;

public class SimpleVC {
    public static void main(String[] args) {

        long startTime = System.nanoTime();

        System.loadLibrary("cvc4jni");

        ExprManager em = new ExprManager();
        SmtEngine smt = new SmtEngine(em);

        // Prove that for integers x and y:
        //   x > 0 AND y > 0  =>  2x + y >= 3


        Type integer = em.integerType();
        Type bool = em.booleanType();


        Expr x = em.mkVar("x", integer);
        Expr y = em.mkVar("y", integer);
        Expr zero = em.mkConst(new Rational(0));

        Expr x_positive = em.mkExpr(Kind.GT, x, zero);
        Expr y_positive = em.mkExpr(Kind.GT, y, zero);

        Expr two = em.mkConst(new Rational(2));

        Expr four = em.mkConst(new Rational(4));
        Expr twox = em.mkExpr(Kind.MULT, two, x);
        Expr twox_plus_y = em.mkExpr(Kind.PLUS, twox, y);

        Expr three = em.mkConst(new Rational(3));
        Expr twox_plus_y_geq_3 = em.mkExpr(Kind.GEQ, twox_plus_y, three);

        Expr formula =
                new Expr(em.mkExpr(Kind.AND, x_positive, y_positive)).
                        impExpr(new Expr(twox_plus_y_geq_3));

        System.out.println("Checking validity of formula " + formula + " with CVC4.");
        System.out.println("CVC4 should report VALID.");
        System.out.println("Result from CVC4 is: " + smt.query(formula));
        long endTime = System.nanoTime();

        // get difference of two nanoTime values
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in milliseconds : " +
                timeElapsed / 1000000);

        Expr bx = em.mkBoundVar("bx", integer);
        Expr by = em.mkBoundVar("by", integer);
        Expr z = em.mkVar("z", integer);
        Expr var_list_forall = em.mkExpr(Kind.BOUND_VAR_LIST,bx);
        Expr var_list_exists = em.mkExpr(Kind.BOUND_VAR_LIST,by);

        Expr eq = em.mkExpr(Kind.EQUAL,em.mkExpr(Kind.MULT,four,em.mkBoundVar("bx", integer)),em.mkExpr(Kind.MULT,two,by));
        Expr q = em.mkExpr(Kind.FORALL,var_list_forall,em.mkExpr(Kind.EXISTS,var_list_exists,eq));
        System.out.println(smt.query(q));
        System.out.println("here");

    }
}