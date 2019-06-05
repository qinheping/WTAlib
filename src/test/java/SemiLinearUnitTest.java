
import semirings.LinearSet;
import semirings.SemilinearSemiring;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class SemiLinearUnitTest {
    @org.junit.Test
    public void testSemilinearSet(){
        Vector<Integer> v1 = new Vector<>();
        v1.add(0);
        v1.add(1);
        v1.add(1);


        Vector<Integer> v2 = new Vector<>();
        v2.add(2);
        v2.add(1);
        v2.add(0);

        Vector<Integer> v3 = new Vector<>();
        v3.add(1);
        v3.add(0);
        v3.add(2);

        Set<Vector<Integer>> peroid1 = new HashSet<>();
        peroid1.add(v2);
        Set<LinearSet> sl1 = new HashSet<>();
        sl1.add(new LinearSet(3,v1,peroid1));

        Set<Vector<Integer>> peroid2 = new HashSet<>();
        peroid2.add(v3);
        Set<LinearSet> sl2 = new HashSet<>();
        sl2.add(new LinearSet(3,v2,peroid2));

        SemilinearSemiring slsm = new SemilinearSemiring();
        System.out.println(sl1);
        System.out.println(sl2);
        System.out.println(slsm.plus(sl1,sl2));
        System.out.println(slsm.times(sl1,sl2));
        System.out.println(slsm.times(slsm.times(slsm.plus(sl1,sl2),sl2),sl2));

    }
}
