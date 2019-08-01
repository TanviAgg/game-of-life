import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameOfLifeTest {
    @Test
    void shouldReturnDeadForNoSeedPopulation(){
        Pair<Integer, Integer> grid = new Pair<>(2, 2);
        GameOfLife game = new GameOfLife(grid);

        game.seedPopulation(new ArrayList<>());

        assertTrue(game.getLiveCellsInCurrentState().size() == 0);
    }

    @Test
    void shouldReturnDeadForNextGenerationByDefault(){
        Pair<Integer, Integer> grid = new Pair<>(2, 2);
        GameOfLife game = new GameOfLife(grid);

        game.computeNextGeneration();

        assertTrue(game.getLiveCellsInCurrentState().size() == 0);
    }

    @Test
    void shouldReturnDeadForLiveCellsByDefault(){
        Pair<Integer, Integer> grid = new Pair<>(2, 2);
        GameOfLife game = new GameOfLife(grid);

        game.getLiveCellsInCurrentState();

        assertTrue(game.getLiveCellsInCurrentState().size() == 0);
    }

    @Test
    void shouldReturnSameForStillLifeTest1(){
        List<CoOrdinate> seed = GameOfLifeFileReader.readInputFromFile("/Users/tanvi.aggarwal/IdeaProjects/GameOfLife/test/Testcase1.txt");
        Pair<Integer, Integer> grid = CoOrdinate.gridSize(seed);
        GameOfLife game = new GameOfLife(grid);

        game.seedPopulation(seed);
        game.computeNextGeneration();
        List<CoOrdinate> liveCells = game.getLiveCellsInCurrentState();

        assertTrue(GameOfLifeFileReader.matchOutputWithFile("/Users/tanvi.aggarwal/IdeaProjects/GameOfLife/test/Solution1.txt", liveCells));
    }

    @Test
    void shouldReturnSameForStillLifeTest2(){
        List<CoOrdinate> seed = GameOfLifeFileReader.readInputFromFile("/Users/tanvi.aggarwal/IdeaProjects/GameOfLife/test/Testcase2.txt");
        Pair<Integer, Integer> grid = CoOrdinate.gridSize(seed);
        GameOfLife game = new GameOfLife(grid);

        game.seedPopulation(seed);
        game.computeNextGeneration();
        List<CoOrdinate> liveCells = game.getLiveCellsInCurrentState();

        assertTrue(GameOfLifeFileReader.matchOutputWithFile("/Users/tanvi.aggarwal/IdeaProjects/GameOfLife/test/Solution2.txt", liveCells));
    }

    @Test
    void shouldOscillateForBlinkerTest3(){
        List<CoOrdinate> seed = GameOfLifeFileReader.readInputFromFile("/Users/tanvi.aggarwal/IdeaProjects/GameOfLife/test/Testcase3.txt");
        Pair<Integer, Integer> grid = CoOrdinate.gridSize(seed);
        GameOfLife game = new GameOfLife(grid);

        game.seedPopulation(seed);
        game.computeNextGeneration();
        List<CoOrdinate> liveCells = game.getLiveCellsInCurrentState();

        assertTrue(GameOfLifeFileReader.matchOutputWithFile("/Users/tanvi.aggarwal/IdeaProjects/GameOfLife/test/Solution3.txt", liveCells));
    }

    @Test
    void shouldOscillateForToadTest4(){
        List<CoOrdinate> seed = GameOfLifeFileReader.readInputFromFile("/Users/tanvi.aggarwal/IdeaProjects/GameOfLife/test/Testcase4.txt");
        Pair<Integer, Integer> grid = CoOrdinate.gridSize(seed);
        GameOfLife game = new GameOfLife(grid);

        game.seedPopulation(seed);
        game.computeNextGeneration();
        List<CoOrdinate> liveCells = game.getLiveCellsInCurrentState();

        assertTrue(GameOfLifeFileReader.matchOutputWithFile("/Users/tanvi.aggarwal/IdeaProjects/GameOfLife/test/Solution4.txt", liveCells));
    }
}
