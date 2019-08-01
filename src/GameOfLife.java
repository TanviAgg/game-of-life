import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

// Describes the operations on the 2D universe
class GameOfLife {
    private List<Cell> liveCells;
    private Pair<Integer, Integer> size;

    GameOfLife(Pair<Integer, Integer> size){
        this.size = size;
        this.liveCells = new ArrayList<>();
    }

    void computeNextGeneration(){
        ArrayList<Cell> nextGen = new ArrayList<Cell>();
        for(Cell cell: liveCells){
            Cell nextStateOfCell = cell.tick(liveCells);
            if(nextStateOfCell != null){
                nextGen.add(nextStateOfCell);
            }
        }
        List<CoOrdinate> currentLiveCoordinates = getLiveCellsInCurrentState();
        for(int i = 0; i < size.getKey(); i++){
            for(int j = 0; j < size.getValue(); j++){
                if(!currentLiveCoordinates.contains(new CoOrdinate(i, j))){
                    Cell deadCell = new Cell(i, j, State.DEAD);
                    Cell nextState = deadCell.tick(liveCells);
                    if(nextState != null){
                        nextGen.add(nextState);
                    }
                }
            }
        }
        this.liveCells = nextGen;
    }

    void seedPopulation(List<CoOrdinate> cells){
        this.liveCells = new ArrayList<Cell>();
        for(CoOrdinate coOrdinate : cells){
            this.liveCells.add(new Cell(coOrdinate, State.LIVE));
        }
    }

    List<CoOrdinate> getLiveCellsInCurrentState(){
        ArrayList<CoOrdinate> liveCellCoordinates = new ArrayList<CoOrdinate>();
        for(Cell cell: this.liveCells){
            liveCellCoordinates.add(cell.coOrdinate);
        }
        return liveCellCoordinates;
    }
}
