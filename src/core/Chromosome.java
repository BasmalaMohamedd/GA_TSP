package core;

import java.util.ArrayList;
import java.util.List;

public class Chromosome<T> {
    private List<T> chromosomeList = new ArrayList<>();
    private T fitness;

    public void addGene(T gene)
    {
        chromosomeList.add(gene);
    }

    public void setGene(int index,T gene)
    {
        if(index < chromosomeList.size())
        {
            chromosomeList.set(index, gene);
        }
        
    }

    public int getLength(){
        return chromosomeList.size();
    }

    public T getGeneAt(int index)
    {
        return chromosomeList.get(index);
    }

    public void setFitness(T fitness)
    {
        this.fitness = fitness;
    }

    public T getFitness()
    {
        return fitness;
    }

    

}
