package ga.crossover;

import ga.Cell;
import ga.GA;


public class SinglePointCrossover implements Crossover {

    public Cell[] execute(Cell c1, Cell c2) {

        int length = c1.getGenes().length;

        float[] genesOffspring1 = new float[length];
        float[] genesOffspring2 = new float[length];

        float splitPoint = GA.getRandomNumber(1, length - 1);

        for (int i = 0; i < length; i++) {

            if (i < splitPoint) {
                genesOffspring1[i] = c1.getGenes()[i];
                genesOffspring2[i] = c2.getGenes()[i];
            } else {
                genesOffspring2[i] = c1.getGenes()[i];
                genesOffspring1[i] = c2.getGenes()[i];
            }
        }

        Cell[] offspring = {new Cell(genesOffspring1), new Cell(genesOffspring2)};

        return offspring;
    }
}
