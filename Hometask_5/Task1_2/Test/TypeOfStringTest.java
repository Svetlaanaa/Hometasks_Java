import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TypeOfStringTest {
    @Test
    void checkType() {
        assertEquals("email", TypeOfString.checkType("user.name@example.com"));

        assertEquals("none", TypeOfString.checkType("@example.com"));

        assertEquals("username", TypeOfString.checkType("user.name.example.com"));

        assertEquals("none", TypeOfString.checkType("user.name@example"));

        assertEquals("email", TypeOfString.checkType("user_name1@some.example.com"));

        assertEquals("телефон", TypeOfString.checkType("+7-(123)-456-78-90"));

        assertEquals("телефон", TypeOfString.checkType("+7(123)456-78-90"));

        assertEquals("телефон", TypeOfString.checkType("+7-123-456-78-90"));

        assertEquals("телефон", TypeOfString.checkType("+71234567890"));

        assertEquals("none", TypeOfString.checkType("71234567890"));

        assertEquals("ИНН", TypeOfString.checkType("1234567890"));

        assertEquals("ИНН", TypeOfString.checkType("000000000000"));

        assertEquals("none", TypeOfString.checkType("7777-8888-9999"));

        assertEquals("username", TypeOfString.checkType("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz.$1234_"));

        assertEquals("username", TypeOfString.checkType("aaaa1111"));

        assertEquals("none", TypeOfString.checkType("a"));

        assertEquals("none", TypeOfString.checkType("qwerty 456"));

        assertEquals("none", TypeOfString.checkType("4abc"));

        assertEquals("none", TypeOfString.checkType("$asdfghjk"));

        assertEquals("none", TypeOfString.checkType(""));
    }
}