import java.util.ArrayList;
import java.util.List;

// Represents the collection of cells in living state
class LiveCells {
    private List<Cell> liveCells;

    LiveCells(){
        this.liveCells = new ArrayList<>();
    }

    LiveCells(List<Coordinate> cells){
        this.liveCells = new ArrayList<>();
        for(Coordinate coOrdinate: cells){
            this.liveCells.add(new Cell(coOrdinate, State.LIVE));
        }
    }

    void addCell(Cell cell){
        if(cell != null) {
            liveCells.add(cell);
        }
    }

    void tick(LiveCells nextGen){
        for(Cell cell: this.liveCells){
            int neighbourCount = this.countLiveNeighboursOf(cell);
            Cell nextStateOfCell = cell.tick(neighbourCount);
            nextGen.addCell(nextStateOfCell);
        }
    }

    List<Coordinate> allLiveCellCoordinates(){
        ArrayList<Coordinate> liveCellCoordinates = new ArrayList<Coordinate>();
        for(Cell cell: this.liveCells){
            liveCellCoordinates.add(cell.coordinate);
        }
        return liveCellCoordinates;
    }

    int countLiveNeighboursOf(Cell other){
        int neighbours = 0;
        for(Cell cell: liveCells){
            if(cell.isNeighbourOf(other)){
                neighbours++;
            }
        }
        return neighbours;
    }
}
