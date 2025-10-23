package library;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import core.Chromosome;
import operators.Crossover;
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
    protected Function<Chromosome, Double> fitnessFunction;
    protected Selection selection;
    protected Crossover crossover;
    protected Mutation mutation;
    protected Replacement replacement;
    

    public GeneticAlgorithm(int populationSize, int chromosomeLength, float crossoverRate, float mutationRate,int generations, Function<Chromosome, Double> fitnessFunction)
    {
        this.populationSize = populationSize;
        this.chromosomeLength = chromosomeLength;
        this.crossoverRate = crossoverRate;
        this.mutationRate = mutationRate;
        this.generations = generations;
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

     
    public boolean isOptimal(List<Chromosome> currentGeneration)
    {
        return false;
    }


    public Chromosome run() {
        List<Chromosome> currentGeneration = initializeGenerations();
        List<Double> fitnessList = evaluateFitness(currentGeneration);

        for (int i = 0; i < generations && !isOptimal(currentGeneration); i++) {
            List<Integer> selectedIndexes = selection.select(fitnessList);
            List<Chromosome> parents = new ArrayList<>();
            for (int index : selectedIndexes) {
                parents.add(currentGeneration.get(index));
            }

            List<Chromosome> children = crossover.cross(parents, chromosomeLength, crossoverRate);

            List<Chromosome> mutatedParents = mutation.mutate(parents);
            List<Chromosome> mutatedChildren = mutation.mutate(children);

            currentGeneration = replacement.replace(mutatedParents, mutatedChildren);
            fitnessList = evaluateFitness(currentGeneration);
        }

        Chromosome best = currentGeneration.get(0);
        double bestFitness = fitnessList.get(0);
        for (int i = 1; i < fitnessList.size(); i++) {
            if (fitnessList.get(i) > bestFitness) {
                bestFitness = fitnessList.get(i);
                best = currentGeneration.get(i);
            }
        }

        return best;
    }

}
