package library;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import core.Chromosome;
import operators.Crossover;
import operators.GenerationIntializater;
import operators.Mutation;
import operators.Replacement;
import operators.Selection;

public abstract class GeneticAlgorithm {
    //initialize types of genetic algorithm steps 
    protected int populationSize;
    protected int chromosomeLength;
    protected float crossoverRate;
    protected float mutationRate;
    protected int generations;
    protected Function fitnessFunction;
    protected Selection selection;
    protected Crossover crossover;
    protected Mutation mutation;
    protected Replacement replacement;

    // protected GenerationIntializater generationIntializater;
    

    public GeneticAlgorithm(int populationSize, int chromosomeLength, float crossoverRate, float mutationRate, Function fitnessFunction)
    {
        this.populationSize = populationSize;
        this.chromosomeLength = chromosomeLength;
        this.crossoverRate = crossoverRate;
        this.mutationRate = mutationRate;
        this.fitnessFunction = fitnessFunction;
    }

    public void setSelection(Selection selection)
    {
        this.selection = selection;
    }

    public void setCrossover(Crossover crossover) {
        this.crossover = crossover;
    }

    public void setMutation(Mutation mutation) {
        this.mutation = mutation;
    }
    public void setReplacement(Replacement replacement) {
        this.replacement = replacement;
    }


    public abstract List<Double> evaluateFitness(List<Chromosome> currentGeneration);



    
    public abstract List<Chromosome> initializeGenerations();

     
    
    
    // public abstract List<Chromosome> select_rankBased();

    // public abstract List<Chromosome> select_tournament();

    // public abstract List<Chromosome> crossover_singlePoint();
    
    // public abstract List<Chromosome> crossover_multiplePoint();

    // public abstract List<Chromosome> crossover_uniform();

    // public abstract List<Chromosome> mutation(); //two methods min

    // public abstract List<Chromosome> replacement(); //three methods min

    public boolean isOptimal(List<Chromosome> currentGeneration)
    {
        return false;
    }
    public Chromosome run()
    {
        List<Chromosome> initialGeneration = new ArrayList<>();
        initialGeneration.addAll(initializeGenerations());
        List<Double> fitnessList = new ArrayList<>();
        fitnessList.addAll(evaluateFitness(initialGeneration));
        List<Chromosome> currentGeneration = new ArrayList<>();
        currentGeneration.addAll(initialGeneration);
        //check if the similarity between generations is close -> terminate
        for(int i = 0; i < generations || isOptimal(currentGeneration); i++)
        {
            List<Integer> selecedIndexes = new ArrayList<>();
            selecedIndexes.addAll(selection.select(fitnessList));
            List<Chromosome> parents = new ArrayList<>();
            //if index matches the currentchromosome index add the chromosome to list
            for(int j = 0; j < selecedIndexes.size(); j++)
            {
                for(int k = 0; k < selecedIndexes.size(); k++)
                {
                    parents.add(currentGeneration.get(j));
                }
            }

            List<Chromosome> children = new ArrayList<>();

            children.addAll(crossover.cross(parents));
            List<Chromosome> parentsAfterMutation = new ArrayList<>();
            List<Chromosome> childrenAfterMutation = new ArrayList<>();

            parentsAfterMutation.addAll(mutation.mutate(parents));
            childrenAfterMutation.addAll(mutation.mutate(children));
            currentGeneration.clear();
            currentGeneration.addAll(replacement.replace(parentsAfterMutation, childrenAfterMutation));
            fitnessList.clear();
            fitnessList.addAll(evaluateFitness(currentGeneration));

        }


        return null;
    }
}
