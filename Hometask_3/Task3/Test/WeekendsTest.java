import org.junit.jupiter.api.Test;
import java.util.Calendar;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WeekendsTest {

    @Test
    void getCountWeekend() {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2023, 11, 01);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2023, 11, 01);
        assertEquals(0, Weekends.getCountWeekend(calendar1, calendar2));

        calendar1.set(2023, 05, 01);
        calendar2.set(2023, 05, 03);
        assertEquals(0, Weekends.getCountWeekend(calendar1, calendar2));

        calendar1.set(2023, 01, 01);
        calendar2.set(2023, 01, 01);
        assertEquals(1, Weekends.getCountWeekend(calendar1, calendar2));

        calendar1.set(2023, 05, 01);
        calendar2.set(2023, 05, 06);
        assertEquals(1, Weekends.getCountWeekend(calendar1, calendar2));

        calendar1.set(2023, 05, 07);
        calendar2.set(2023, 05, 10);
        assertEquals(1, Weekends.getCountWeekend(calendar1, calendar2));

        calendar1.set(2023, 05, 01);
        calendar2.set(2023, 05, 07);
        assertEquals(2, Weekends.getCountWeekend(calendar1, calendar2));

        calendar1.set(2023, 05, 06);
        calendar2.set(2023, 05, 07);
        assertEquals(2, Weekends.getCountWeekend(calendar1, calendar2));

        calendar1.set(2023, 05, 06);
        calendar2.set(2023, 05, 9);
        assertEquals(2, Weekends.getCountWeekend(calendar1, calendar2));

        calendar1.set(2023, 05, 01);
        calendar2.set(2023, 05, 16);
        assertEquals(4, Weekends.getCountWeekend(calendar1, calendar2));

        calendar1.set(2023, 01, 01);
        calendar2.set(2023, 12, 31);
        assertEquals(105, Weekends.getCountWeekend(calendar1, calendar2));
    }
}