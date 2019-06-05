package semirings;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SemilinearSemiring extends Semiring <Set<LinearSet>> {

    // union
    @Override
    public Set<LinearSet> plus(Set<LinearSet> w1, Set<LinearSet> w2) {
        Set<LinearSet> w1cp = copySet(w1);
        Set<LinearSet> w2cp = copySet(w2);
        w1cp.addAll(w2cp);
        return w1cp;
    }

    private Set<LinearSet> copySet(Set<LinearSet> w){
        Set<LinearSet> result = new HashSet<>();
        Iterator<LinearSet> it = w.iterator();
        while(it.hasNext()){
            result.add(it.next().clone());
        }
        return result;
    }

    @Override
    public Set<LinearSet> times(Set<LinearSet> w1, Set<LinearSet> w2) {
        Set<LinearSet> result = new HashSet<LinearSet>();

        Iterator<LinearSet> it1 = w1.iterator();
        while(it1.hasNext()){
            Iterator<LinearSet> it2 = w2.iterator();
            while(it2.hasNext())
            result.add(it1.next().dicSum(it2.next()));
        }
        return result;
    }

    @Override
    public Set<LinearSet> divide(Set<LinearSet> w1, Set<LinearSet> w2) {
        return null;
    }

    @Override
    public Set<LinearSet> zero() {
        return null;
    }

    @Override
    public Set<LinearSet> one() {
        return null;
    }

    @Override
    public boolean isMember(Set<LinearSet> w) {
        return false;
    }

    @Override
    public boolean lessThan(Set<LinearSet> w1, Set<LinearSet> w2) {
        return false;
    }

    @Override
    public Set<LinearSet> parse(String s) {
        return null;
    }

    @Override
    public String getName() {
        return "SELI";
    }


    @Override
    public Set<LinearSet> reverse(Set<LinearSet> w1) {
        // TODO: ???
        System.out.println("Not Implemented");
        return null;
    }
}
