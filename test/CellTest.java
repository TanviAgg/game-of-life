import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    private Cell liveCell1_2;
    private Cell deadCell2_1;

    @BeforeEach
    void initialize(){
        liveCell1_2 = new Cell(1, 2, State.LIVE);
        deadCell2_1 = new Cell(2, 1, State.DEAD);
    }

    @Test
    void shouldReturnNullForTickForOneNeighbour(){
        assertNull(liveCell1_2.tick(1));
    }

    @Test
    void shouldNotReturnNullForTickForTwoNeighbours(){
        assertNotNull(liveCell1_2.tick(2));
    }

    @Test
    void shouldNotReturnNullForTickForThreeNeighbours(){
        assertNotNull(deadCell2_1.tick(3));
    }

    @Test
    void shouldReturnTrueForIsNeighbour(){
        assertTrue(deadCell2_1.isNeighbourOf(liveCell1_2));
    }
}
