import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CellTest {
    @Test
    void shouldReturnDeadForNewCellByDefault(){
        Cell cell = new Cell();

        assertFalse(cell.isAlive());
    }

    @Test
    void shouldReturnAliveForLiveCell(){
        Cell cell = new Cell();

        cell.makeAlive();

        assertTrue(cell.isAlive());
    }

    @Test
    void shouldReturnDeadForKilledCell(){
        Cell cell = new Cell();

        cell.kill();

        assertFalse(cell.isAlive());
    }
}
