import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        List<Pair<Integer, Integer>> seed = GameOfLifeFileReader.readInputFromFile("/Users/tanvi.aggarwal/IdeaProjects/GameOfLife/test/Testcase1.txt");

        game.seedPopulation(seed);
        game.computeNextGeneration();
        List<Pair<Integer, Integer>> liveCells = game.getLiveCellsInCurrentState();

        assertTrue(GameOfLifeFileReader.matchOutputWithFile("/Users/tanvi.aggarwal/IdeaProjects/GameOfLife/test/Solution1.txt", liveCells));
    }

    @Test
    void shouldReturnSameForStillLifeTest2(){
        Grid grid = new Grid(3, 3);
        GameOfLife game = new GameOfLife(grid);
        List<Pair<Integer, Integer>> seed = GameOfLifeFileReader.readInputFromFile("/Users/tanvi.aggarwal/IdeaProjects/GameOfLife/test/Testcase2.txt");

        game.seedPopulation(seed);
        game.computeNextGeneration();
        List<Pair<Integer, Integer>> liveCells = game.getLiveCellsInCurrentState();

        assertTrue(GameOfLifeFileReader.matchOutputWithFile("/Users/tanvi.aggarwal/IdeaProjects/GameOfLife/test/Solution2.txt", liveCells));
    }

    @Test
    void shouldOscillateForBlinkerTest3(){
        Grid grid = new Grid(3, 3);
        GameOfLife game = new GameOfLife(grid);
        List<Pair<Integer, Integer>> seed = GameOfLifeFileReader.readInputFromFile("/Users/tanvi.aggarwal/IdeaProjects/GameOfLife/test/Testcase3.txt");

        game.seedPopulation(seed);
        game.computeNextGeneration();
        List<Pair<Integer, Integer>> liveCells = game.getLiveCellsInCurrentState();

        assertTrue(GameOfLifeFileReader.matchOutputWithFile("/Users/tanvi.aggarwal/IdeaProjects/GameOfLife/test/Solution3.txt", liveCells));
    }

    @Test
    void shouldOscillateForToadTest4(){
        Grid grid = new Grid(5, 5);
        GameOfLife game = new GameOfLife(grid);
        List<Pair<Integer, Integer>> seed = GameOfLifeFileReader.readInputFromFile("/Users/tanvi.aggarwal/IdeaProjects/GameOfLife/test/Testcase4.txt");

        game.seedPopulation(seed);
        game.computeNextGeneration();
        List<Pair<Integer, Integer>> liveCells = game.getLiveCellsInCurrentState();

        assertTrue(GameOfLifeFileReader.matchOutputWithFile("/Users/tanvi.aggarwal/IdeaProjects/GameOfLife/test/Solution4.txt", liveCells));
    }
}
