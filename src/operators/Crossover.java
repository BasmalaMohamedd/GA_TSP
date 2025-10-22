package operators;

import java.util.List;

import core.Chromosome;

public interface Crossover {

    public abstract List<Chromosome> cross(List<Chromosome> parents);

}
