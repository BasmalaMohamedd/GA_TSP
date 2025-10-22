package library;

import java.util.List;
import java.util.function.Function;

import core.Chromosome;

public abstract class GeneticAlgorithm {
    protected int populationSize;
    protected int chromosomeLength;
    private float crossoverRate;
    private float mutationRate;
    private int generations;
    private Function fitnessFunction;

    public GeneticAlgorithm(int populationSize, int chromosomeLength, float crossoverRate, float mutationRate, Function fitnessFunction)
    {
        this.populationSize = populationSize;
        this.chromosomeLength = chromosomeLength;
        this.crossoverRate = crossoverRate;
        this.mutationRate = mutationRate;
        this.fitnessFunction = fitnessFunction;
    }



    
    // public abstract List<Chromosome> initializeGenerations();

     
    // public abstract List<Chromosome> select_roulettewheel();

    
    // public abstract List<Chromosome> select_rankBased();

    // public abstract List<Chromosome> select_tournament();

    // public abstract List<Chromosome> crossover_singlePoint();
    
    // public abstract List<Chromosome> crossover_multiplePoint();

    // public abstract List<Chromosome> crossover_uniform();

    // public abstract List<Chromosome> mutation(); //two methods min

    // public abstract List<Chromosome> replacement(); //three methods min


}
