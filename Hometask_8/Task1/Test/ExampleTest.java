import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {
    @Test
    void getMessage() {
        Example example = new Example();
        assertEquals("", example.getMessage("1"));
        assertEquals("", example.getMessage("2"));
        assertEquals("", example.getMessage("3"));
        assertEquals("Значение: 1, позиция: 4", example.getMessage("1"));
        assertEquals("", example.getMessage("4"));
    }
}