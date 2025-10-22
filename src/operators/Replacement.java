package operators;

import java.util.List;

import core.Chromosome;

public interface Replacement {
    public abstract List<Chromosome> replace(List<Chromosome> parents, List<Chromosome> children);
}
