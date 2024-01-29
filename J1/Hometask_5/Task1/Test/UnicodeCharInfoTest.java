import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnicodeCharInfoTest {

    @Test
    void getUnicodeDec() {
        UnicodeCharInfo unicodeCharInfo = new UnicodeCharInfo('0');
        assertEquals(48, unicodeCharInfo.getUnicodeDec());

        unicodeCharInfo = new UnicodeCharInfo('N');
        assertEquals(78, unicodeCharInfo.getUnicodeDec());

        unicodeCharInfo = new UnicodeCharInfo('z');
        assertEquals(122, unicodeCharInfo.getUnicodeDec());

        unicodeCharInfo = new UnicodeCharInfo('Ж');
        assertEquals(1046, unicodeCharInfo.getUnicodeDec());

        unicodeCharInfo = new UnicodeCharInfo(' ');
        assertEquals(32, unicodeCharInfo.getUnicodeDec());

        unicodeCharInfo = new UnicodeCharInfo('\t');
        assertEquals(9, unicodeCharInfo.getUnicodeDec());

        unicodeCharInfo = new UnicodeCharInfo('&');
        assertEquals(38, unicodeCharInfo.getUnicodeDec());

        unicodeCharInfo = new UnicodeCharInfo('\u03BB');
        assertEquals(955, unicodeCharInfo.getUnicodeDec());
    }

    @Test
    void getUnicodeHex() {
        UnicodeCharInfo unicodeCharInfo = new UnicodeCharInfo('0');
        assertEquals("U+0030", unicodeCharInfo.getUnicodeHex());

        unicodeCharInfo = new UnicodeCharInfo('N');
        assertEquals("U+004E", unicodeCharInfo.getUnicodeHex());

        unicodeCharInfo = new UnicodeCharInfo('z');
        assertEquals("U+007A", unicodeCharInfo.getUnicodeHex());

        unicodeCharInfo = new UnicodeCharInfo('Ж');
        assertEquals("U+0416", unicodeCharInfo.getUnicodeHex());

        unicodeCharInfo = new UnicodeCharInfo(' ');
        assertEquals("U+0020", unicodeCharInfo.getUnicodeHex());

        unicodeCharInfo = new UnicodeCharInfo('\t');
        assertEquals("U+0009", unicodeCharInfo.getUnicodeHex());

        unicodeCharInfo = new UnicodeCharInfo('&');
        assertEquals("U+0026", unicodeCharInfo.getUnicodeHex());

        unicodeCharInfo = new UnicodeCharInfo('\u03BB');
        assertEquals("U+03BB", unicodeCharInfo.getUnicodeHex());
    }

    @Test
    void getNextUnicode() {
        UnicodeCharInfo unicodeCharInfo = new UnicodeCharInfo('0');
        assertEquals('1', unicodeCharInfo.getNextUnicode());

        unicodeCharInfo = new UnicodeCharInfo('N');
        assertEquals('O', unicodeCharInfo.getNextUnicode());

        unicodeCharInfo = new UnicodeCharInfo('z');
        assertEquals('{', unicodeCharInfo.getNextUnicode());

        unicodeCharInfo = new UnicodeCharInfo('Ж');
        assertEquals('З', unicodeCharInfo.getNextUnicode());

        unicodeCharInfo = new UnicodeCharInfo(' ');
        assertEquals('!', unicodeCharInfo.getNextUnicode());

        unicodeCharInfo = new UnicodeCharInfo('\t');
        assertEquals('\n', unicodeCharInfo.getNextUnicode());

        unicodeCharInfo = new UnicodeCharInfo('&');
        assertEquals('\'', unicodeCharInfo.getNextUnicode());

        unicodeCharInfo = new UnicodeCharInfo('\u03BB');
        assertEquals('μ', unicodeCharInfo.getNextUnicode());
    }

    @Test
    void getPrevUnicode() {
        UnicodeCharInfo unicodeCharInfo = new UnicodeCharInfo('0');
        assertEquals('/', unicodeCharInfo.getPrevUnicode());

        unicodeCharInfo = new UnicodeCharInfo('N');
        assertEquals('M', unicodeCharInfo.getPrevUnicode());

        unicodeCharInfo = new UnicodeCharInfo('z');
        assertEquals('y', unicodeCharInfo.getPrevUnicode());

        unicodeCharInfo = new UnicodeCharInfo('Ж');
        assertEquals('Е', unicodeCharInfo.getPrevUnicode());

        unicodeCharInfo = new UnicodeCharInfo(' ');
        assertEquals('\u001F', unicodeCharInfo.getPrevUnicode());

        unicodeCharInfo = new UnicodeCharInfo('\t');
        assertEquals('\b', unicodeCharInfo.getPrevUnicode());

        unicodeCharInfo = new UnicodeCharInfo('&');
        assertEquals('%', unicodeCharInfo.getPrevUnicode());

        unicodeCharInfo = new UnicodeCharInfo('\u03BB');
        assertEquals('κ', unicodeCharInfo.getPrevUnicode());
    }

    @Test
    void getType() {
        UnicodeCharInfo unicodeCharInfo = new UnicodeCharInfo('0');
        assertEquals("DIGIT", unicodeCharInfo.getType());

        unicodeCharInfo = new UnicodeCharInfo('N');
        assertEquals("LETTER_UPPER", unicodeCharInfo.getType());

        unicodeCharInfo = new UnicodeCharInfo('z');
        assertEquals("LETTER_LOWER", unicodeCharInfo.getType());

        unicodeCharInfo = new UnicodeCharInfo('Ж');
        assertEquals("LETTER_UPPER", unicodeCharInfo.getType());

        unicodeCharInfo = new UnicodeCharInfo(' ');
        assertEquals("SPACE", unicodeCharInfo.getType());

        unicodeCharInfo = new UnicodeCharInfo('\t');
        assertEquals("SPACE", unicodeCharInfo.getType());

        unicodeCharInfo = new UnicodeCharInfo('&');
        assertEquals("OTHER", unicodeCharInfo.getType());

        unicodeCharInfo = new UnicodeCharInfo('\u03BB');
        assertEquals("LETTER_LOWER", unicodeCharInfo.getType());
    }

    @Test
    void getAlphabetNumber() {
        UnicodeCharInfo unicodeCharInfo = new UnicodeCharInfo('0');
        assertEquals(-1, unicodeCharInfo.getAlphabetNumber());

        unicodeCharInfo = new UnicodeCharInfo('N');
        assertEquals(14, unicodeCharInfo.getAlphabetNumber());

        unicodeCharInfo = new UnicodeCharInfo('z');
        assertEquals(26, unicodeCharInfo.getAlphabetNumber());

        unicodeCharInfo = new UnicodeCharInfo('Ж');
        assertEquals(-1, unicodeCharInfo.getAlphabetNumber());

        unicodeCharInfo = new UnicodeCharInfo(' ');
        assertEquals(-1, unicodeCharInfo.getAlphabetNumber());

        unicodeCharInfo = new UnicodeCharInfo('\t');
        assertEquals(-1, unicodeCharInfo.getAlphabetNumber());

        unicodeCharInfo = new UnicodeCharInfo('&');
        assertEquals(-1, unicodeCharInfo.getAlphabetNumber());

        unicodeCharInfo = new UnicodeCharInfo('\u03BB');
        assertEquals(-1, unicodeCharInfo.getAlphabetNumber());
    }


}