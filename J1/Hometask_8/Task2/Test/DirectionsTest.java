import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionsTest {
    @Test
    void directions(){
        assertEquals("Вверх", Directions.UP.getTitle());
        assertEquals(40, Directions.DOWN.getCode());
        assertEquals(-1, Directions.LEFT.getVector()[0]);
        assertEquals(0, Directions.LEFT.getVector()[1]);
    }
}