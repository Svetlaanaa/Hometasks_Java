import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Calendar;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WeekendsTest {

    @Test
    void getCountWeekend() {
        LocalDate date1 = LocalDate.of(2023, 11, 01);
        LocalDate date2 = LocalDate.of(2023, 11, 01);
        assertEquals(0, Weekends.getCountWeekend(date1, date2));

        date1 = LocalDate.of(2023, 05, 01);
        date2 = LocalDate.of(2023, 05, 03);
        assertEquals(0, Weekends.getCountWeekend(date1, date2));

        date1 = LocalDate.of(2023, 01, 01);
        date2 = LocalDate.of(2023, 01, 01);
        assertEquals(1, Weekends.getCountWeekend(date1, date2));

        date1 = LocalDate.of(2023, 05, 01);
        date2 = LocalDate.of(2023, 05, 06);
        assertEquals(1, Weekends.getCountWeekend(date1, date2));

        date1 = LocalDate.of(2023, 05, 07);
        date2 = LocalDate.of(2023, 05, 10);
        assertEquals(1, Weekends.getCountWeekend(date1, date2));

        date1 = LocalDate.of(2023, 05, 01);
        date2 = LocalDate.of(2023, 05, 07);
        assertEquals(2, Weekends.getCountWeekend(date1, date2));

        date1 = LocalDate.of(2023, 05, 06);
        date2 = LocalDate.of(2023, 05, 07);
        assertEquals(2, Weekends.getCountWeekend(date1, date2));

        date1 = LocalDate.of(2023, 05, 06);
        date2 = LocalDate.of(2023, 05, 9);
        assertEquals(2, Weekends.getCountWeekend(date1, date2));

        date1 = LocalDate.of(2023, 05, 01);
        date2 = LocalDate.of(2023, 05, 16);
        assertEquals(4, Weekends.getCountWeekend(date1, date2));

        date1 = LocalDate.of(2023, 01, 01);
        date2 = LocalDate.of(2023, 12, 31);
        assertEquals(105, Weekends.getCountWeekend(date1, date2));
    }
}