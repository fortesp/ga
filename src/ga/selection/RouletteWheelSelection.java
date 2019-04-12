package ga.selection;

import ga.Cell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RouletteWheelSelection implements Selection {

    @Override
    public Cell[] execute(List<Cell> population) {

        List<Cell> round = new ArrayList<Cell>();

        List<Cell> temp = new ArrayList<Cell>(population);
        Collections.sort(temp);

        Cell fittest = temp.get(0);

        Cell[] parents = new Cell[2];
        for(int i = 0; i < parents.length; i++) {

            float rand = (float)Math.random();

          //  if(rand > 0.5 + )
        }


        return parents;
    }

    float[] normalizeData(float[] data) {

        float max = Float.MIN_VALUE;
        float min = Float.MAX_VALUE;

        for (int i = 0; i < data.length; i++) {
            if (data[i] > max) max = data[i];
            else if (data[i] < min) min = data[i];
        }

        for (int i = 0; i < data.length; i++) {
            data[i] = (data[i] - min) / (max - min);
        }

        return data;
    }
}
