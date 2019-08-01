import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CoOrdinateTest {
    private CoOrdinate coOrdinate1_2;
    private CoOrdinate coOrdinate2_2;

    @BeforeEach
    void initialize(){
        coOrdinate1_2 = new CoOrdinate(1, 2);
        coOrdinate2_2 = new CoOrdinate(2, 2);
    }

    @Test
    void shouldReturnTrueForIsNeighbour(){
        assertTrue(coOrdinate2_2.isNeighbourOf(coOrdinate1_2));
    }

    @Test
    void shouldReturnGridSizeThree(){
        List<CoOrdinate> coOrdinates = new ArrayList<>();
        coOrdinates.add(coOrdinate1_2);
        coOrdinates.add(coOrdinate2_2);
        assertEquals(3, CoOrdinate.gridSize(coOrdinates).getValue());
    }
}
