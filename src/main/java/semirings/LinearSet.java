package semirings;

import javax.sound.sampled.Line;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class LinearSet {
    Integer dimension;
    Vector<Integer> base;
    Set<Vector<Integer>> period;

    public LinearSet(Integer dimension, Vector<Integer> base, Set<Vector<Integer>> period) {
        this.dimension = dimension;
        this.base = base;
        this.period = period;
    }

    public LinearSet(Vector<Integer> base){
        this.dimension = base.size();
        this.base = base;
        this.period = new HashSet<>();
    }

    public LinearSet clone(){
        return new LinearSet(dimension,(Vector<Integer>) base.clone(),(HashSet)((HashSet)this.period).clone());
    }

    public LinearSet(Integer dimension) {
        this.dimension = dimension;
        this.base = zeorVecotr(dimension);
        this.period = new HashSet<>();
    }

    public LinearSet dicSum(LinearSet w){
        Vector newBase = new Vector();
        for(int i = 0; i < dimension; i++){
            newBase.add(this.getBase().get(i)+w.getBase().get(i));
        }
        Set newPeriod = (HashSet)((HashSet)period).clone();
        newPeriod.addAll(w.getPeriod());
        return new LinearSet(dimension,newBase,newPeriod);
    }

    // Construct zero vector
    private Vector<Integer> zeorVecotr(Integer dimension){
        Vector<Integer> result = new Vector<>();
        for(int i = 0; i < dimension; i++){
            result.add(0);
        }
        return result;
    }

    public Integer getDimension() {
        return dimension;
    }

    public void setDimension(Integer dimension) {
        this.dimension = dimension;
    }

    public Vector<Integer> getBase() {
        return base;
    }

    public void setBase(Vector<Integer> base) {
        this.base = base;
    }

    public Set<Vector<Integer>> getPeriod() {
        return period;
    }

    public void setPeriod(Set<Vector<Integer>> period) {
        this.period = period;
    }

    public String toString(){
        String result = "";
        result+="base: "+base+"\n";
        result+="period: "+period+"\n";
        return  result;
    }
}
