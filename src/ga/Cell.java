package ga;

public class Cell implements Comparable<Cell> {

    private float[] genes;
    private float fitness;

    public Cell(int length) {

        genes = new float[length];

        for(int i = 0; i < genes.length; i++) {
            genes[i] = (float)Math.random();
        }
    }

    public Cell(float[] genes) {

        this.genes = genes;
    }

    public float[] getGenes() {
        return genes;
    }

    public float getSingleGene(int index) {
        return genes[index];
    }

    public void setGenes(float[] genes) {
        this.genes = genes;
    }

    public void setSingleGene(int index, float value)  {
        this.genes[index] = value;
    }

    public float getFitness() {
        return fitness;
    }

    public void setFitness(float fitness) {
        this.fitness = fitness;
    }

    public int compareTo(Cell cell) {
        if(this.getFitness() < cell.getFitness()) return 1;
        if(this.getFitness() == cell.getFitness()) return 0;
        else return -1;
    }

    public boolean equals(Object obj) {

        if(!(obj instanceof Cell)) return false;

        for(int i = 0; i < genes.length; i++) {
            if(genes[i] != ((Cell) obj).getSingleGene(i)) return false;
        }

        return true;
    }

    public String toString() {

        String ret = "";
        for(int i = 0; i < genes.length; i++) {
            ret += genes[i] + " ";
        }

        return ret;
    }
}

