package ga.mutation;

import ga.Cell;
import ga.GA;

public class UniformMutation implements Mutation {


    @Override
    public void execute(Cell cell) {

        cell.setSingleGene(GA.getRandomInt(0, cell.getGenes().length - 1), (float)Math.random());
    }
}
