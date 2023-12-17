import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransliterationTest {

    @Test
    void getTransliterationToLatin() {
        assertEquals("Odnoznachno, klyuchevye osobennosti struktury proekta ob'edineny v " +
                "tselye klastery sebe podobnykh. Takzhe kak ukreplenie i razvitie vnutrenney " +
                "struktury obespechivaet shirokomu krugu (spetsialistov) uchastie v formirovanii " +
                "standartnykh podkhodov. Prinimaya vo vnimanie pokazateli uspeshnosti, novaya model' " +
                "organizatsionnoy deyatel'nosti obespechivaet shirokomu krugu (spetsialistov) uchastie " +
                "v formirovanii pervoocherednykh trebovaniy.", Transliteration.getTransliterationToLatin("Однозначно, ключевые особенности структуры проекта " +
                "объединены в целые кластеры себе подобных. Также как укрепление и развитие" +
                " внутренней структуры обеспечивает широкому кругу (специалистов) участие в " +
                "формировании стандартных подходов. Принимая во внимание показатели успешности, " +
                "новая модель организационной деятельности обеспечивает широкому кругу (специалистов) " +
                "участие в формировании первоочередных требований."));
    }
    @Test
    void getTransliterationToRussian() {
        assertEquals("Однозначно, ключевые особенности структуры проекта " +
                "объединены в целые кластеры себе подобных. Также как укрепление и развитие" +
                " внутренней структуры обеспечивает широкому кругу (специалистов) участие в " +
                "формировании стандартных подходов. Принимая во внимание показатели успешности, " +
                "новая модель организационной деятельности обеспечивает широкому кругу (специалистов) " +
                "участие в формировании первоочередных требований.",
                Transliteration.getTransliterationToRussian("Odnoznachno, klyuchevye osobennosti struktury " +
                        "proekta ob'edineny v tselye klastery sebe podobnykh. Takzhe kak ukreplenie i razvitie vnutrenney " +
                        "struktury obespechivaet shirokomu krugu (spetsialistov) uchastie v formirovanii " +
                        "standartnykh podkhodov. Prinimaya vo vnimanie pokazateli uspeshnosti, novaya model' " +
                        "organizatsionnoy deyatel'nosti obespechivaet shirokomu krugu (spetsialistov) uchastie " +
                        "v formirovanii pervoocherednykh trebovaniy."));
    }
}