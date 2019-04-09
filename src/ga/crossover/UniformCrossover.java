package ga.crossover;

import ga.Cell;

public class UniformCrossover implements Crossover {

    public Cell[] execute(Cell c1, Cell c2) {

        int length = c1.getGenes().length;

        float[] genesOffspring1 = new float[length];
        float[] genesOffspring2 = new float[length];

        // Needs work - Temporary way to randomize UniformCrossover
        float evenodd = (Math.random() < 0.5)?0:1;

        for (int i = 0; i < length; i++) {

            if (i % 2 == evenodd) {
                genesOffspring1[i] = c1.getGenes()[i];
                genesOffspring2[i] = c2.getGenes()[i];
            } else {
                genesOffspring1[i] = c2.getGenes()[i];
                genesOffspring2[i] = c1.getGenes()[i];
            }
        }

        Cell[] offspring = {new Cell(genesOffspring1), new Cell(genesOffspring2)};

        return offspring;
    }
}
