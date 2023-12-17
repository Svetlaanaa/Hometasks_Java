import java.util.HashMap;
import java.util.Map;

public class Transliteration {
    private static final String[] rusLetters = {"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и",
        "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ",
        "ы", "ь", "э", "ю", "я"};
    private static final String[] latLetters = {"a", "b", "v", "g", "d", "e", "yo", "zh",
            "z", "i", "i'", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "f", "x",
            "c", "ch", "sh", "shh", "``", "y'", "`", "e`", "yu", "ya"};

    public static String getTransliterationToLatin(String russianText) {
        Map<String, String> translitMap = new HashMap<>();
        for (int i = 0; i < rusLetters.length; i++) {
            translitMap.put(rusLetters[i], latLetters[i]);
            translitMap.put(rusLetters[i].toUpperCase(), latLetters[i].toUpperCase());
        }

        StringBuilder result = new StringBuilder();
        for (char c : russianText.toCharArray()) {
            String symbol = String.valueOf(c);
            if (translitMap.containsKey(symbol)) {
                result.append(translitMap.get(symbol));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String getTransliterationToRussian(String latinText) {
        Map<String, String> translitMap = new HashMap<>();
        for (int i = 0; i < rusLetters.length; i++) {
            translitMap.put(latLetters[i], rusLetters[i]);
            translitMap.put(latLetters[i].toUpperCase(), rusLetters[i].toUpperCase());
        }

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < latinText.length()) {
            String symbol = String.valueOf(latinText.charAt(i));
            if (i + 1 < latinText.length() && translitMap.containsKey(latinText.substring(i, i + 2))) {
                result.append(translitMap.get(latinText.substring(i, i + 2)));
                i += 2;
            } else if (translitMap.containsKey(symbol)) {
                result.append(translitMap.get(symbol));
                i++;
            } else {
                result.append(latinText.charAt(i));
                i++;
            }
        }
        return result.toString();
    }
}
