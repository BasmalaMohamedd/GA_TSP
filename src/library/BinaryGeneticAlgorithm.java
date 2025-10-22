package library;

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

}
