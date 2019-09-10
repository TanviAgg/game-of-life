import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {
    private Coordinate coordinate1_2;
    private Coordinate coordinate2_2;

    @BeforeEach
    void initialize(){
        coordinate1_2 = new Coordinate(1, 2);
        coordinate2_2 = new Coordinate(2, 2);
    }

    @Test
    void shouldReturnTrueForIsNeighbour(){
        assertTrue(coordinate2_2.isNeighbourOf(coordinate1_2));
    }

    @Test
    void shouldReturnGridSize3x3(){
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(coordinate1_2);
        coordinates.add(coordinate2_2);
        assertEquals(3, Coordinate.calculateGridSize(coordinates).getValue());
        assertEquals(3, Coordinate.calculateGridSize(coordinates).getKey());
    }
}
