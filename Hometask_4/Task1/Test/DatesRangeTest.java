import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class DatesRangeTest {

    @Test
    void getDateArray() {
        LocalDate date1 = LocalDate.of(2023, 02, 28);
        LocalDate date2 = LocalDate.of(2023, 02, 28);
        String[] ld = {"2023-02-28"};
        String[] result = DatesRange.getDateArray(date1, date2);
        for(int i = 0; i < ld.length; i++){
            assertEquals(ld[i], result[i]);
        }

        date1 = LocalDate.of(2023, 11, 12);
        date2 = LocalDate.of(2023, 11, 11);
        String[] ld2 = {};
        String[] result2 = DatesRange.getDateArray(date1, date2);
        for(int i = 0; i < ld2.length; i++){
            assertEquals(ld2[i], result2[i]);
        }

        date1 = LocalDate.of(2020, 05, 28);
        date2 = LocalDate.of(2020, 06, 02);
        String[] ld3 = {"2020-05-28", "2020-05-29", "2020-05-30", "2020-05-31",
                "2020-06-01", "2020-06-02"};
        String[] result3 = DatesRange.getDateArray(date1, date2);
        for(int i = 0; i < ld3.length; i++){
            assertEquals(ld3[i], result3[i]);
        }


        date1 = LocalDate.of(1901, 01, 01);
        date2 = LocalDate.of(1901, 12, 31);
        String[] ld4 = {"1901-03-01", "1901-01-02", "1901-01-03", "1901-12-31"};
        String[] result4 = DatesRange.getDateArray(date1, date2);
        assertEquals(365, result4.length);
        assertEquals(ld4[0], result4[59]);
        assertEquals(ld4[1], result4[1]);
        assertEquals(ld4[2], result4[2]);
        assertEquals(ld4[ld4.length - 1], result4[364]);
    }
}