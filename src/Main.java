import ga.Cell;
import ga.GA;

import java.util.Collections;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        int generations = 50;
        float[] target = {1, 0.5f, 1, 0.5f, 1, 1};

        GA ga = new GA(20, target);

        List<Cell> population = ga.getPopulation();
        for(int i = 1; i <= generations; i++) {

            population = ga.evolve();

            Collections.sort(population);

            System.out.println("\nGeneration #" + i);
            for(Cell cell : population) {
                System.out.println(cell + " -> " + cell.getFitness());
            }

        }

    }


}