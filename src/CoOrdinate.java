import javafx.util.Pair;

import java.util.List;
import java.util.Objects;

import static java.lang.Integer.max;

class CoOrdinate {
    private int x;
    private int y;

    CoOrdinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    static Pair<Integer, Integer> gridSize(List<CoOrdinate> coOrdinates){
        int rows = 0;
        int columns = 0;
        for(CoOrdinate coOrdinate: coOrdinates){
            rows = max(rows, coOrdinate.x);
            columns = max(columns, coOrdinate.y);
        }
        return new Pair<Integer, Integer>(rows+1, columns+1);
    }

    boolean isNeighbourOf(CoOrdinate that){
        return x == that.x + 1 && y == that.y ||
                x == that.x && y == that.y + 1 ||
                x == that.x - 1 && y == that.y ||
                x == that.x && y == that.y - 1 ||
                x == that.x + 1 && y == that.y + 1 ||
                x == that.x + 1 && y == that.y - 1 ||
                x == that.x - 1 && y == that.y + 1 ||
                x == that.x - 1 && y == that.y - 1;
    }

    int countNeighboursIn(List<CoOrdinate> coOrdinates){
        int neighbourCount = 0;
        for(CoOrdinate liveCell: coOrdinates){
            if(this.isNeighbourOf(liveCell)){
                neighbourCount++;
            }
        }
        return neighbourCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoOrdinate that = (CoOrdinate) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
