package utilities;

import semirings.LinearSet;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class SemilinearFactory {
    public static Set<LinearSet> getEmpty(){
        return new HashSet<>();
    }

    public static Set<LinearSet> dot(Set<LinearSet> left, Set<LinearSet> right) {


        Set<LinearSet> result = new HashSet<>();
        for(LinearSet lsLeft: left){
            for(LinearSet lsRight: right){
                result.add(lsLeft.dicSum(lsRight));
            }
        }

        return result;
    }

    public static Set<LinearSet> union(Set<LinearSet> left, Set<LinearSet> right) {
        Set<LinearSet> result = new HashSet<>();
        result.addAll(left);
        result.addAll(right);

        return result;
    }

    public static Set<LinearSet> star(Set<LinearSet> sl, int dim) {
        Set result = new HashSet();
        Vector  zeroBase = new Vector<>();
        for(int i = 0; i < dim; i++){
            zeroBase.add(0);
        }
        Set<Vector<Integer>> peroid = new HashSet<>();
        if(sl.size() == 0) {
            result.add(new LinearSet(dim, zeroBase, peroid));
            return result;
        }
        for(LinearSet lset: sl){
            peroid.add(lset.getBase());
            peroid.addAll(lset.getPeriod());
        }
        LinearSet resultLS = new LinearSet(dim,zeroBase,peroid);
        result.add(resultLS);
        return result;
        
    }
}
