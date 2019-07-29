import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GridTest {
    @Test
    void shouldReturnDeadForNewCellByDefault(){
        Grid grid = new Grid(2, 2);

        assertFalse(grid.isCellAlive(0, 0));
    }

    @Test
    void shouldReturnAliveForLiveCell(){
        Grid grid = new Grid(2, 2);

        grid.makeCellAlive(0,0);

        assertTrue(grid.isCellAlive(0, 0));
    }

    @Test
    void shouldReturnDeadForKilledCell(){
        Grid grid = new Grid(2, 2);

        grid.killCell(0,0);

        assertFalse(grid.isCellAlive(0, 0));
    }
}
