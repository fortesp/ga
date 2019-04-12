package ga.mutation;

import ga.Cell;
import ga.GA;

public class UniformMutation implements Mutation {

    @Override
    public void execute(Cell cell) {

        for (int i = 0; i < cell.getGenes().length; i++)
            if (Math.random() <= MUTATION_PROBABILITY)
                cell.setSingleGene(GA.getRandomNumber(0, cell.getGenes().length - 1), (float) Math.random());
    }
}
