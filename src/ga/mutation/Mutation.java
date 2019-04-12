package ga.mutation;

import ga.Cell;

public interface Mutation {

    float MUTATION_PROBABILITY = 0.01f;

    void execute(Cell cell);
}
