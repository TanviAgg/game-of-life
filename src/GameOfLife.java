import javafx.util.Pair;

import java.util.List;

// Describes the operations on the 2D universe
class GameOfLife {
    static final int MINIMUM_NEIGHBOUR_THRESHOLD = 2;
    static final int MAXIMUM_NEIGHBOUR_THRESHOLD = 3;
    static final int OPTIMAL_NEIGHBOUR_THRESHOLD = 3;
    private LiveCells liveCells;
    private Pair<Integer, Integer> size;

    GameOfLife(Pair<Integer, Integer> size){
        this.size = size;
        this.liveCells = new LiveCells();
    }

    void computeNextGeneration(){
        LiveCells nextGen = new LiveCells();
        computeNextStateOfLiveCells(nextGen);
        computeNextStateOfDeadCells(nextGen);
        updateGeneration(nextGen);
    }

    void seedPopulation(List<Coordinate> cells){
        this.liveCells = new LiveCells(cells);
    }

    List<Coordinate> getLiveCellsInCurrentState(){
        return this.liveCells.allLiveCellCoordinates();
    }

    private void computeNextStateOfLiveCells(LiveCells nextGen) {
        this.liveCells.tick(nextGen);
    }

    private void computeNextStateOfDeadCells(LiveCells nextGen){
        List<Coordinate> liveCoordinates = getLiveCellsInCurrentState();
        for(int i = 0; i <= size.getKey(); i++){
            for(int j = 0; j <= size.getValue(); j++){
                Coordinate deadCellCoordinate = new Coordinate(i, j);
                if(!liveCoordinates.contains(deadCellCoordinate)){
                    tickDeadCell(deadCellCoordinate, nextGen);
                }
            }
        }
    }

    private void tickDeadCell(Coordinate deadCellCoordinate, LiveCells nextGen) {
        Cell deadCell = new Cell(deadCellCoordinate, State.DEAD);
        int neighbours = this.liveCells.countLiveNeighboursOf(deadCell);
        nextGen.addCell(deadCell.tick(neighbours));
    }

    private void updateGeneration(LiveCells nextGen) {
        this.liveCells = nextGen;
        this.size = Coordinate.calculateGridSize(getLiveCellsInCurrentState());
    }
}
