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



    abstract
    public List<Chromosome> initializeGenerations();

}
