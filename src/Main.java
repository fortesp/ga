import ga.Cell;
import ga.GA;

import java.util.Collections;
import java.util.List;

public class Main {


    public static void main(String[] args) {


        String testStr = "Search for the work of humans.";
 
        float[] target = new float[testStr.length()];

        for(int i = 0; i < testStr.length(); i++) {

             target[i] = (float)(char)testStr.charAt(i)/1000;
             System.out.print(target[i] + "(");
             System.out.print((int)testStr.charAt(i) + ") ");
        }


        GA ga = new GA(500, target);

        List<Cell> population = ga.getPopulation();
        boolean quit = false;

        for(int i = 1; quit == false; i++) {

            population = ga.evolve();

            Collections.sort(population);

            System.out.println("\nGeneration #" + i);
            for(Cell cell : population.subList(0, 3)) {

                quit = true;
                for(int gi = 0; gi < cell.getGenes().length; gi++) {

                    char car = (char)Math.round(cell.getSingleGene(gi) * 1000);
                    char targetCar = (char)Math.round(target[gi] * 1000);

                    if(car != targetCar) quit = false;

                    System.out.print(Character.toString(car));
                }
                System.out.print( " -> " + cell.getFitness() + "\n");
            }



        }

    }


}