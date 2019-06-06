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
}
