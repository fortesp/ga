package ga.selection;

import ga.Cell;
import ga.GA;

import java.util.*;

public class TournamentSelection implements Selection {

    @Override
    public Cell[] execute(List<Cell> population) {

        List<Cell> round = new ArrayList<Cell>();

        for(int i = 0; i < population.size() * SIZE_PROPORTION; i++)
            round.add(population.get(GA.getRandomNumber(0, population.size() - 1)));

        Collections.sort(round);

        Cell[] parents = {round.get(0), round.get(1)};

        return parents;
    }
}
