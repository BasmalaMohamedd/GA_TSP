package core;
import java.util.List;

public interface Chromosome {
    
    public void setFitness(double fitness);

    public double getFitness();

    public void randomize(int chromosomeLength);

    public List getGenesList();

    public int getLength();
}
