import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    private Cell liveCell1_2;
    private Cell deadCell2_1;
    private Cell liveCell2_2;
    private Cell liveCell1_1;

    @BeforeEach
    void initialize(){
        liveCell1_2 = new Cell(1, 2, State.LIVE);
        deadCell2_1 = new Cell(2, 1, State.DEAD);
        liveCell2_2 = new Cell(2, 2, State.LIVE);
        liveCell1_1 = new Cell(1, 1, State.LIVE);
    }

    @Test
    void shouldReturnNullForTickForOneNeighbour(){
        List<Cell> liveCells = new ArrayList<>();
        liveCells.add(liveCell1_2);
        liveCells.add(liveCell2_2);

        assertNull(liveCell1_2.tick(liveCells));
    }

    @Test
    void shouldNotReturnNullForTickForTwoNeighbours(){
        List<Cell> liveCells = new ArrayList<>();
        liveCells.add(liveCell1_2);
        liveCells.add(liveCell2_2);
        liveCells.add(liveCell1_1);

        assertNotNull(liveCell1_2.tick(liveCells));
    }

    @Test
    void shouldNotReturnNullForTickForThreeNeighbours(){
        List<Cell> liveCells = new ArrayList<>();
        liveCells.add(liveCell1_2);
        liveCells.add(liveCell2_2);
        liveCells.add(liveCell1_1);

        assertNotNull(deadCell2_1.tick(liveCells));
    }
}
