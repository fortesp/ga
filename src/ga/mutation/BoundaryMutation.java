package ga.mutation;

import ga.Cell;
import ga.GA;

public class BoundaryMutation implements Mutation {


    @Override
    public void execute(Cell cell) {

        float bound = (Math.random() < 0.5)?0:0.999f;

        int index = GA.getRandomInt(0, cell.getGenes().length - 1);

        cell.setSingleGene(index, bound);
    }
}
