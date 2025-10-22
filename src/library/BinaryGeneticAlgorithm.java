package library;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import core.Chromosome;
import operators.BinaryGenerationIntialization;
import operators.GenerationIntializater;

public class BinaryGeneticAlgorithm extends GeneticAlgorithm{

    public BinaryGeneticAlgorithm(int populationSize, int chromosomeLength, float crossoverRate, float mutationRate, Function fitnessFunction){
        super(populationSize, chromosomeLength, crossoverRate, mutationRate, fitnessFunction);
    }
    
    public List<Chromosome> initializeGenerations(){
        GenerationIntializater generationInitializor = new BinaryGenerationIntialization();
        return generationInitializor.initializeGenerations(populationSize, chromosomeLength);
        
    }

    public List<Double> evaluateFitness(List<Chromosome> currentGeneration)
    {
        return null;
    }

    

    public Chromosome run(){
        List<Double> fitnessList = new ArrayList<>();
        fitnessList.addAll(evaluateFitness(initializeGenerations()));
        List<Integer> selectedChromosomesIndexes = new ArrayList<>();
        selectedChromosomesIndexes.addAll(selection.select(fitnessList));


        return null;
    }
}
