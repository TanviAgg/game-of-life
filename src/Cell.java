// Represents the state of one square in the grid
class Cell {
    private State state;
    Coordinate coordinate;

    Cell(int x, int y, State state) {
        this.state = state;
        this.coordinate = new Coordinate(x, y);
    }

    Cell(Coordinate coordinate, State state) {
        this.state = state;
        this.coordinate = coordinate;
    }

    Cell tick(int neighbourCount){
        if(this.isAlive()){
            if(this.isLonely(neighbourCount) || this.isOvercrowded(neighbourCount)){
                return null;
            }
            return this;
        }
        if(this.canBecomeAlive(neighbourCount)){
            return new Cell(this.coordinate, State.LIVE);
        }
        return null;
    }

    boolean isNeighbourOf(Cell other) {
        return this.coordinate.isNeighbourOf(other.coordinate);
    }

    private boolean isAlive(){
        return this.state == State.LIVE;
    }

    private boolean isLonely(int neighbourCount){
        return neighbourCount < GameOfLife.MINIMUM_NEIGHBOUR_THRESHOLD;
    }

    private boolean isOvercrowded(int neighbourCount){
        return neighbourCount > GameOfLife.MAXIMUM_NEIGHBOUR_THRESHOLD;
    }

    private boolean canBecomeAlive(int neighbourCount){
        return neighbourCount == GameOfLife.OPTIMAL_NEIGHBOUR_THRESHOLD;
    }
}
