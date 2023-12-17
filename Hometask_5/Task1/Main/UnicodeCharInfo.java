public class UnicodeCharInfo {
    private char symbol;
    private final String DIGIT = "DIGIT";
    private final String LETTER_UPPER = "LETTER_UPPER";
    private final String LETTER_LOWER = "LETTER_LOWER";
    private final String SPACE = "SPACE";
    private final String OTHER = "OTHER";


    public UnicodeCharInfo(char symbol){
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getUnicodeDec(){
        return (int)symbol;
    }

    public String getUnicodeHex(){
        String hex = Integer.toHexString((int)symbol | 0x0000).toUpperCase();
        if(hex.length() == 1){
            hex = "000" + hex;
        } else if (hex.length() == 2) {
            hex = "00" + hex;
        } else if (hex.length() == 3) {
            hex = "0" + hex;
        }
        return "U+" + hex;
    }

    public char getNextUnicode(){
        return (char) (symbol + 1);
    }
    public char getPrevUnicode(){
        return (char) (symbol - 1);
    }

    public String getType(){
        if(Character.isDigit(symbol)){
            return DIGIT;
        } else if (Character.isAlphabetic(symbol) & Character.isLowerCase(symbol)) {
            return LETTER_LOWER;
        } else if (Character.isAlphabetic(symbol) & Character.isUpperCase(symbol)) {
            return LETTER_UPPER;
        } else if (Character.isWhitespace(symbol)) {
            return SPACE;
        } else {
            return OTHER;
        }
    }

    public int getAlphabetNumber() {
        char upcase = Character.toUpperCase(symbol);
        if ((int)upcase <= 90 & (int)upcase >= 65) {
            return upcase - 'A' + 1;
        } else {
            return -1;
        }
    }
}
