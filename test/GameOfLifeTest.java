import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class GameOfLifeTest {
    @Test
    void shouldReturnDeadForNoSeedPopulation(){
        Grid grid = new Grid(2, 2);
        GameOfLife game = new GameOfLife(grid);

        game.seedPopulation();

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
}
