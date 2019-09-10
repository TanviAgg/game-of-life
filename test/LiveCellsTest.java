import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LiveCellsTest {
    private Cell liveCell1_2;
    private Cell liveCell2_2;
    private Cell liveCell4_5;
    private LiveCells liveCells;

    @BeforeEach
    void initialize(){
        liveCell1_2 = new Cell(1, 2, State.LIVE);
        liveCell2_2 = new Cell(2, 2, State.LIVE);
        liveCell4_5 = new Cell(4, 4, State.LIVE);
        liveCells = new LiveCells();
    }

    @Test
    void shouldReturnCountOneForLiveNeighbour(){
        liveCells.addCell(liveCell1_2);
        liveCells.addCell(liveCell2_2);
        liveCells.addCell(liveCell4_5);

        assertEquals(1, liveCells.countLiveNeighboursOf(liveCell1_2));
    }

    @Test
    void shouldReturnCountZeroForLiveNeighbour(){
        liveCells.addCell(liveCell1_2);
        liveCells.addCell(liveCell2_2);
        liveCells.addCell(liveCell4_5);

        assertEquals(0, liveCells.countLiveNeighboursOf(liveCell4_5));
    }

    @Test
    void shouldReturnCountThreeForLiveCellCoordinates(){
        liveCells.addCell(liveCell1_2);
        liveCells.addCell(liveCell2_2);
        liveCells.addCell(liveCell4_5);

        assertEquals(3, liveCells.allLiveCellCoordinates().size());
    }

    @Test
    void shouldReturnCountZeroForNextGeneration(){
        liveCells.addCell(liveCell1_2);
        liveCells.addCell(liveCell2_2);
        liveCells.addCell(liveCell4_5);
        LiveCells nextGen = new LiveCells();

        liveCells.tick(nextGen);

        assertEquals(0, nextGen.allLiveCellCoordinates().size());
    }


}
