import automata.fta.FTA;
import grammar.GrammarReduction;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.*;
import semirings.TropicalSemiring;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class mainUnitTest {
    @org.junit.Test
    public void testQSyGuS() throws FileNotFoundException,IOException,InterruptedException{
        String[] args = new String[2];
        args[0] = "ESolver";
        args[1] ="/u/q/h/qhu28/repositories/WTAlib/benchmarks/unitTest/max3_greater.sl";
        QSyGuS.main(args);
    }

}