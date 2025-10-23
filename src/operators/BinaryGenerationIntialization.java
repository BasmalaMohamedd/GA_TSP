package operators;

import java.util.ArrayList;
import java.util.List;

import core.BinaryChromosome;
import core.Chromosome;

public class BinaryGenerationIntialization implements GenerationIntializater{
    public List<Chromosome> initializeGenerations(int populationSize, int chromosomeLength){
        List<Chromosome> chromosomes = new ArrayList<>();
        for(int i = 0; i < populationSize; i ++)
        {
            Chromosome chromosome = new BinaryChromosome();
            chromosome.randomize(chromosomeLength);
            chromosomes.add(chromosome);
        }
        
        return chromosomes;
    }

}
