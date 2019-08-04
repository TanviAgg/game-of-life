import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.lang.Integer.max;

// Represents a point in a 2D grid
class Coordinate {
    private int x;
    private int y;
    private static List<Pair<Integer, Integer>> neighbourMatrix;

    Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    static Pair<Integer, Integer> calculateGridSize(List<Coordinate> coordinates){
        int rows = 0;
        int columns = 0;
        for(Coordinate coordinate: coordinates){
            rows = max(rows, coordinate.x);
            columns = max(columns, coordinate.y);
        }
        return new Pair<Integer, Integer>(rows+1, columns+1);
    }

    boolean isNeighbourOf(Coordinate that){
        if(neighbourMatrix == null){
            setNeighbourMatrix();
        }
        for(Pair<Integer, Integer> neighbour: neighbourMatrix){
            if(this.x == that.x + neighbour.getKey() && this.y == that.y + neighbour.getValue()){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    private static void setNeighbourMatrix(){
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
}
