import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

// Represents the state of the 2D matrix of cells at a given point of time
class Grid {
    private ArrayList<ArrayList<Cell>> grid;
    private int rows;
    private int columns;
    private static List<Pair<Integer, Integer>> neighbourMatrix;

    Grid(int rowSize, int columnSize){
        this.grid = new ArrayList<ArrayList<Cell>>();
        this.rows = rowSize;
        this.columns = columnSize;
        this.initialiseGrid();
        this.setNeighbourMatrix();
    }

    private void initialiseGrid(){
        for(int i = 0; i <= rows; i++){
            grid.add(new ArrayList<Cell>());
            initialiseGridRow(i);
        }
    }

    private void initialiseGridRow(int row){
        for(int j = 0; j <= columns; j++){
            grid.get(row).add(new Cell());
        }
    }

    Pair<Integer, Integer> getSize(){
        return new Pair<Integer, Integer>(rows, columns);
    }

    void killCell(int row, int column){
        grid.get(row).get(column).kill();
    }

    void makeCellAlive(int row, int column){
        if(!isValidCell(row, column)){
            return;
        }
        grid.get(row).get(column).makeAlive();
    }

    boolean isCellAlive(int row, int column){
        if(!isValidCell(row, column)){
            return false;
        }
        return grid.get(row).get(column).isAlive();
    }

    private boolean isValidCell(int row, int column){
        if(row < 0 || row > columns || column < 0 || column > columns){
            return false;
        }
        return true;
    }
    private void setNeighbourMatrix(){
        neighbourMatrix = new ArrayList<Pair<Integer, Integer>>();
        neighbourMatrix.add(new Pair<Integer, Integer>(0, 1));
        neighbourMatrix.add(new Pair<Integer, Integer>(0, -1));
        neighbourMatrix.add(new Pair<Integer, Integer>(1, 1));
        neighbourMatrix.add(new Pair<Integer, Integer>(-1, 1));
        neighbourMatrix.add(new Pair<Integer, Integer>(1, -1));
        neighbourMatrix.add(new Pair<Integer, Integer>(1, 0));
        neighbourMatrix.add(new Pair<Integer, Integer>(-1, 0));
        neighbourMatrix.add(new Pair<Integer, Integer>(-1, -1));
    }

    int neighbourCount(int row, int column){
        if(!isValidCell(row, column)){
            return 0;
        }
        int neighboursAlive = 0;
        for(Pair<Integer, Integer> neighbour: neighbourMatrix){
            if(isCellAlive(row + neighbour.getKey(), column + neighbour.getValue())){
                neighboursAlive++;
            }
        }
        return neighboursAlive;
    }
}
