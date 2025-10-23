package casestudy;

import core.*;
import library.BinaryGeneticAlgorithm;
import library.GeneticAlgorithm;
import operators.*;

public class BinaryGATest {
    
    public static void main(String[] args) {
        System.out.println("=== Binary GA Test - OneMax Problem ===");
        System.out.println("Goal: Maximize number of 1s in binary string\n");

        int chromosomeLength = 20;

        // Fitness function: Count number of 1s (OneMax problem)
        FitnessFunction fitnessFunction = new FitnessFunction() {
            @Override
            public double evaluate(Chromosome chromosome) {
                BinaryChromosome binary = (BinaryChromosome) chromosome;
                int count = 0;
                for (int i = 0; i < binary.getLength(); i++) {
                    count += binary.getGeneAt(i);
                }
                return count;
            }
        };

        // No infeasibility for this simple problem
        InfeasibilityCheck infeasibilityCheck = new InfeasibilityCheck() {
            @Override
            public boolean isInfeasible(Chromosome chromosome) {
                return false;
            }
        };

        // Configure GA
        GeneticAlgorithm ga_engine = new BinaryGeneticAlgorithm(
            50,                 // populationSize
            chromosomeLength,   // chromosomeLength
            0.7f,              // crossoverRate
            0.05f,             // mutationRate
            100,               // generations
            (c) -> fitnessFunction.evaluate(c)
        );

        // Set operators
        ga_engine.setSelection(new RouletteWheelSelection());
        ga_engine.setCrossover(new SinglePointCrossover());
        ga_engine.setMutation(new BitFlipMutation(0.05f));
        ga_engine.setReplacement(new GenerationalReplacement());
        ga_engine.setInfeasibilityCheck(infeasibilityCheck);

        System.out.println("GA Configuration:");
        System.out.println("  Population Size: 50");
        System.out.println("  Chromosome Length: " + chromosomeLength);
        System.out.println("  Crossover: SinglePointCrossover");
        System.out.println("  Mutation: BitFlipMutation (rate: 0.05)");
        System.out.println("  Replacement: GenerationalReplacement");
        System.out.println("  Selection: RouletteWheelSelection");
        System.out.println("  Generations: 100\n");

        System.out.println("Running Genetic Algorithm...\n");

        // Run GA
        Chromosome bestSolution = ga_engine.run();

        // Display results
        System.out.println("\n=== Best Solution Found ===");
        BinaryChromosome bestBinary = (BinaryChromosome) bestSolution;
        System.out.print("Best Chromosome: ");
        for (int i = 0; i < bestBinary.getLength(); i++) {
            System.out.print(bestBinary.getGeneAt(i));
        }
        System.out.println();
        
        double fitness = fitnessFunction.evaluate(bestBinary);
        System.out.println("Number of 1s: " + (int)fitness + " out of " + chromosomeLength);
        System.out.println("Fitness: " + fitness);
        
        if (fitness == chromosomeLength) {
            System.out.println("\n✓ OPTIMAL SOLUTION FOUND! All bits are 1!");
        } else {
            System.out.println("\nPercentage: " + String.format("%.1f", (fitness/chromosomeLength)*100) + "%");
        }
    }
}
