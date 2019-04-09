package ga;

import ga.crossover.*;
import ga.mutation.Mutation;
import ga.mutation.UniformMutation;
import ga.selection.Selection;
import ga.selection.TournamentSelection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GA {

    final float PRESELECTION_PROBABILITY = 0.80f;
    final float MUTATION_PROBABILITY = 0.10f;

    private final int totalPopulation;

    private Selection selection;
    private Crossover crossover;
    private Mutation mutation;

    private List<Cell> population = new ArrayList<Cell>();
    private float[] target;

    public GA(int totalPopulation, float[] target) {

        this.totalPopulation = totalPopulation;
        this.target = target;

        // Different types of implementations for each genetic operators
        this.selection = new TournamentSelection();
        this.crossover = new TwoPointCrossover();
        this.mutation  = new UniformMutation();

        generatePopulation();
    }

    private void generatePopulation() {

        for (int i = 0; i < totalPopulation; i++) {
            Cell cell = new Cell(target.length);
            population.add(cell);

            calculateFitness(cell);
        }
    }

    void calculateFitness(Cell cell) {

        float score = 0;

        // Higher the distance, between the genes and the target weights, higher the punishment
        for (int i = 0; i < cell.getGenes().length; i++) {
            score -= Math.abs(cell.getSingleGene(i) - target[i]);
        }

        cell.setFitness(score);
    }

    private List<Cell> preSelection() {

        int limit = Math.round(population.size() * PRESELECTION_PROBABILITY);

        Collections.sort(population);

        return population.subList(0, limit);
    }

    final public List<Cell> evolve() {

        List<Cell> newPopulation = new ArrayList<Cell>();

        // Pre selection/selection of the population (survival of the fittest)
        population = preSelection();

        while(newPopulation.size() < this.totalPopulation) {

            // Mating selection
            Cell[] parents = selection.execute(population);

            Cell c1 = parents[0];
            Cell c2 = parents[1];

            // Mating, crossover
            Cell[] offspring = crossover.execute(c1, c2);

            // Offspring mutation
            if(Math.random() < MUTATION_PROBABILITY)
                mutation.execute(offspring[0]);

            if(Math.random() < MUTATION_PROBABILITY)
                mutation.execute(offspring[1]);

            calculateFitness(offspring[0]);
            calculateFitness(offspring[1]);

            // Add offspring to the population. Parents do not pass through generation
            newPopulation.add(offspring[0]);
            newPopulation.add(offspring[1]);
        }

        population = newPopulation;

        return newPopulation;
    }

    final public List<Cell> evolve(int generations) {

        List <Cell> last_population = null;

        for(int i = 1; i <= generations; i++) {
            last_population = evolve();
        }

        return last_population;
    }

    public Cell getFittest() {

        Collections.sort(population);

        return population.get(0);
    }

    final public int getTotalPopulation() {
        return totalPopulation;
    }

    final public Selection getSelection() {
        return selection;
    }

    final public void setSelection(Selection selection) {
        this.selection = selection;
    }

    final public Crossover getCrossover() {
        return crossover;
    }

    final public void setCrossover(Crossover crossover) {
        this.crossover = crossover;
    }

    final public Mutation getMutation() {
        return mutation;
    }

    final public List<Cell> getPopulation() {

        List<Cell> list = new ArrayList<Cell>();
        list.addAll(population);

        return list;
    }

    final public void setMutation(Mutation mutation) {
        this.mutation = mutation;
    }

    final public float[] getTarget() {
        return target;
    }

    public static int getRandomInt(int min, int max) {

        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
