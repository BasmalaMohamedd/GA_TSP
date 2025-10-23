package core;

import java.util.ArrayList;
import java.util.List;

public class BinaryChromosome implements Chromosome{
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

    public void setGene(int index,double gene)
    {
        if(index < genesList.size())
        {
            genesList.set(index, determineGeneValue((int)gene));
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


    

    public Chromosome clone()
    {
        BinaryChromosome copy = new BinaryChromosome();
        for (int gene : this.genesList) {
            copy.addGene(gene);
        }
        return copy;
    }



}
