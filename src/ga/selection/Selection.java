package ga.selection;

import ga.Cell;

import java.util.List;

public interface Selection {

    float SIZE_PROPORTION = 0.4f;

    Cell[] execute(List<Cell> population);
}
