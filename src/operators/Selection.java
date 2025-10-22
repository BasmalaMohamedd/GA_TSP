package operators;

import java.util.List;

import core.Chromosome;

public interface Selection {
    public abstract List<Integer> select(List<Double> fitnessList);

}
