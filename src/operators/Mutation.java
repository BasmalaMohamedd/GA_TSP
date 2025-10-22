package operators;

import java.util.List;

import core.Chromosome;

public interface Mutation {
    public abstract List<Chromosome> mutate(List<Chromosome> currentGeneration);
}
