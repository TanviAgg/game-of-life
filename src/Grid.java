import java.util.ArrayList;

// Represents the 2D matrix of cells
class Grid {
    private ArrayList<ArrayList<Cell>> grid;

    Grid(int rowSize, int columnSize){
        this.grid = new ArrayList<ArrayList<Cell>>();
        this.initialiseGrid(rowSize, columnSize);
    }

    private void initialiseGrid(int rowSize, int columnSize){
        for(int i = 0; i <= rowSize; i++){
            grid.add(new ArrayList<Cell>());
            initialiseGridRow(i, columnSize);
        }
    }

    private void initialiseGridRow(int row, int columnSize){
        for(int j = 0; j <= columnSize; j++){
            grid.get(row).add(new Cell());
        }
    }

    void killCell(int row, int column){
        grid.get(row).get(column).kill();
    }

    void makeCellAlive(int row, int column){
        grid.get(row).get(column).makeAlive();
    }

    boolean isCellAlive(int row, int column){
        return grid.get(row).get(column).isAlive();
    }
}
