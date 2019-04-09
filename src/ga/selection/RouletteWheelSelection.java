package ga.selection;

import ga.Cell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RouletteWheelSelection implements Selection {

    @Override
    public Cell[] execute(List<Cell> population) {

        List<Cell> round = new ArrayList<Cell>();


        Collections.sort(population);

        Cell[] parents = {population.get(0), population.get(1)};

        return parents;
    }
}
