import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

class GameOfLifeTest {
    @Test
    void shouldReturnDeadForNoSeedPopulation(){
        Grid grid = new Grid(2, 2);
        GameOfLife game = new GameOfLife(grid);

        game.seedPopulation(new ArrayList<Pair<Integer, Integer>>());

        assertFalse(grid.isCellAlive(0, 0));
    }

    @Test
    void shouldReturnDeadForNextGenerationByDefault(){
        Grid grid = new Grid(2, 2);
        GameOfLife game = new GameOfLife(grid);

        game.computeNextGeneration();

        assertFalse(grid.isCellAlive(0, 0));
    }

    @Test
    void shouldReturnDeadForLiveCellsByDefault(){
        Grid grid = new Grid(2, 2);
        GameOfLife game = new GameOfLife(grid);

        game.getLiveCellsInCurrentState();

        assertFalse(grid.isCellAlive(0, 0));
    }

    @Test
    void shouldReturnSameForStillLifeTest1(){
        Grid grid = new Grid(3, 3);
        GameOfLife game = new GameOfLife(grid);
        List<Pair<Integer, Integer>> seed = new ArrayList<Pair<Integer, Integer>>();
        seed.add(new Pair<Integer, Integer>(1,1));
        seed.add(new Pair<Integer, Integer>(1,2));
        seed.add(new Pair<Integer, Integer>(2,1));
        seed.add(new Pair<Integer, Integer>(2,2));

        game.seedPopulation(seed);
        game.computeNextGeneration();
        List<Pair<Integer, Integer>> liveCells = game.getLiveCellsInCurrentState();

        assertFalse(grid.isCellAlive(0, 0));
    }

    @Test
    void shouldReturnSameForStillLifeTest2(){
        Grid grid = new Grid(3, 3);
        GameOfLife game = new GameOfLife(grid);
        List<Pair<Integer, Integer>> seed = new ArrayList<Pair<Integer, Integer>>();
        seed.add(new Pair<Integer, Integer>(0,1));
        seed.add(new Pair<Integer, Integer>(1,0));
        seed.add(new Pair<Integer, Integer>(2,1));
        seed.add(new Pair<Integer, Integer>(0,2));
        seed.add(new Pair<Integer, Integer>(1,2));

        game.seedPopulation(seed);
        game.computeNextGeneration();
        List<Pair<Integer, Integer>> liveCells = game.getLiveCellsInCurrentState();

        assertFalse(grid.isCellAlive(0, 0));
    }

    @Test
    void shouldOscillateForBlinkerTest3(){
        Grid grid = new Grid(3, 3);
        GameOfLife game = new GameOfLife(grid);
        List<Pair<Integer, Integer>> seed = new ArrayList<Pair<Integer, Integer>>();
        seed.add(new Pair<Integer, Integer>(1,1));
        seed.add(new Pair<Integer, Integer>(1,0));
        seed.add(new Pair<Integer, Integer>(2,1));

        game.seedPopulation(seed);
        game.computeNextGeneration();
        List<Pair<Integer, Integer>> liveCells = game.getLiveCellsInCurrentState();

        assertFalse(grid.isCellAlive(0, 0));
    }

    @Test
    void shouldOscillateForToadTest4(){
        Grid grid = new Grid(5, 5);
        GameOfLife game = new GameOfLife(grid);
        List<Pair<Integer, Integer>> seed = new ArrayList<Pair<Integer, Integer>>();
        seed.add(new Pair<Integer, Integer>(1,1));
        seed.add(new Pair<Integer, Integer>(1,2));
        seed.add(new Pair<Integer, Integer>(1,3));
        seed.add(new Pair<Integer, Integer>(2,2));
        seed.add(new Pair<Integer, Integer>(2,3));
        seed.add(new Pair<Integer, Integer>(2,4));

        game.seedPopulation(seed);
        game.computeNextGeneration();
        List<Pair<Integer, Integer>> liveCells = game.getLiveCellsInCurrentState();

        assertFalse(grid.isCellAlive(0, 0));
    }
}
