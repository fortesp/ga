package ga.selection;

import ga.Cell;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ElitistSelection implements Selection {

    @Override
    public Cell[] execute(List<Cell> population) {

        Collections.sort(population);

        Cell[] parents = {population.get(0), population.get(1)};

        return parents;
    }

}
