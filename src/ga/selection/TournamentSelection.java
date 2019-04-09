package ga.selection;

import ga.Cell;
import ga.GA;

import java.util.*;

public class TournamentSelection implements Selection {

    final float SIZE_PROPORTION = 0.3f;

    @Override
    public Cell[] execute(List<Cell> population) {

        List<Cell> round = new ArrayList<Cell>();

        for(int i = 0; i < population.size() * SIZE_PROPORTION; i++)
            round.add(population.get(GA.getRandomInt(0, population.size() - 1)));

        Collections.sort(round);

        Cell[] parents = {round.get(0), round.get(1)};

        return parents;
    }
}
