import java.util.List;

// Represents the state of one square in the grid
class Cell {
    private State state;
    CoOrdinate coOrdinate;

    Cell(int x, int y, State state) {
        this.state = state;
        this.coOrdinate = new CoOrdinate(x, y);
    }

    Cell(CoOrdinate coOrdinate, State state) {
        this.state = state;
        this.coOrdinate = coOrdinate;
    }

    private boolean isAlive(){
        return this.state == State.LIVE;
    }

    Cell tick(List<Cell> liveCells){
        int neighbourCount = 0;
        for(Cell liveCell: liveCells){
            if(this.coOrdinate.isNeighbourOf(liveCell.coOrdinate)){
                neighbourCount++;
            }
        }
        if(isAlive()){
            if(neighbourCount > 3 || neighbourCount < 2){
                return null;
            }
            return this;
        }
        if(neighbourCount == 3){
            return new Cell(this.coOrdinate, State.LIVE);
        }
        return null;
    }
}
