package operators;

import java.util.ArrayList;
import java.util.List;

import core.Chromosome;

public class SinglePointCrossover extends Crossover{
    
    public List<Chromosome> crossTwo(Chromosome parent1, Chromosome parent2, int chromosomeLength)
    {
        int crossoverPoint = (int)(Math.random() * chromosomeLength);
        List<Chromosome> children = new ArrayList<>();
        for(int i = 0; i < chromosomeLength; i++)
        {
            
        }
        return null;
    }


}
