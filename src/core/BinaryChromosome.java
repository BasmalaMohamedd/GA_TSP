package core;

import java.util.ArrayList;
import java.util.List;

public class BinaryChromosome implements Chromosome{
    private double fitness = 0.00;
    private List<Integer> genesList = new ArrayList<>();
    private int determineGeneValue(int gene)
    {
        if(gene == 0)
        {
            return gene;
        }
        else
        {
            return 1;
        }
    }
    public void addGene(int gene)
    {
        genesList.add(determineGeneValue(gene));
        
    }

    public void setGene(int index,int gene)
    {
        if(index < genesList.size())
        {
            genesList.set(index, determineGeneValue(gene));
        }
        
    }
    @Override
    public int getLength(){
        return genesList.size();
    }

    public int getGeneAt(int index)
    {
        return genesList.get(index);
    }


    @Override
    public void setFitness(double fitness)
    {
        this.fitness = fitness;
    }

    @Override
    public double getFitness()
    {
        return fitness;
    }

    @Override
    public void randomize(int chromosomeLength)
    {
            for(int j = 0; j < chromosomeLength; j++)
            {
                this.genesList.add((int)(Math.random() * 2));

            }
    }


    @Override
    public List<Integer> getGenesList(){
        return genesList;
    }


    




}
