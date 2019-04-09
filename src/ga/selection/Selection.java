package ga.selection;

import ga.Cell;

import java.util.List;

public interface Selection {

    Cell[] execute(List<Cell> population);
}
