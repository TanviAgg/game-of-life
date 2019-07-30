import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

// Describes the operations on the 2D universe
class GameOfLife {
    private Grid grid;

    GameOfLife(Grid grid){
        this.grid = grid;
    }

    void computeNextGeneration(){
        Pair<Integer, Integer> size = grid.getSize();
        Grid nextState = new Grid(size.getKey()+1, size.getValue()+1);
        for(int i = 0; i <= size.getKey(); i++){
            for(int j = 0; j <= size.getValue(); j++){
                if(!grid.isCellAlive(i, j) && grid.neighbourCount(i, j) == 3){
                    nextState.makeCellAlive(i, j);
                    continue;
                }
                if(grid.isCellAlive(i, j)){
                    if(grid.neighbourCount(i, j) > 3 || grid.neighbourCount(i ,j) < 2){
                        continue;
                    }
                    nextState.makeCellAlive(i, j);
                }
            }
        }
        this.grid = nextState;
    }

    void seedPopulation(List<Pair<Integer, Integer>> liveCells){
        for(Pair<Integer, Integer> coOrdinates : liveCells){
            this.grid.makeCellAlive(coOrdinates.getKey(), coOrdinates.getValue());
        }
    }

    List<Pair<Integer, Integer>> getLiveCellsInCurrentState(){
        ArrayList<Pair<Integer, Integer>> liveCells = new ArrayList<Pair<Integer, Integer>>();
        Pair<Integer, Integer> size = grid.getSize();
        for(int i = 0; i < size.getKey(); i++){
            for(int j = 0; j < size.getValue(); j++){
                if(grid.isCellAlive(i, j)){
                    liveCells.add(new Pair<Integer, Integer>(i, j));
                }
            }
        }
        return liveCells;
    }
}
