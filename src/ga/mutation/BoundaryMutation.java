package ga.mutation;

import ga.Cell;
import ga.GA;

public class BoundaryMutation implements Mutation {

    @Override
    public void execute(Cell cell) {

        for (int i = 0; i < cell.getGenes().length; i++)
            if (Math.random() <= MUTATION_PROBABILITY) {

                float bound = (Math.random() < 0.5) ? 0 : 0.999f;
                int index = GA.getRandomNumber(0, cell.getGenes().length - 1);

                cell.setSingleGene(index, bound);
            }
    }

}
