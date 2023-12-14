import org.junit.jupiter.api.Test;
import java.util.Calendar;
import static org.junit.jupiter.api.Assertions.*;

class MonthInfoTest {

    @Test
    void getMonthTitle() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, 11, 12);
        MonthInfo monthInfo = new MonthInfo(calendar.getTime());
        String result = monthInfo.getMonthTitle();
        String expected = "ноябрь";
        assertEquals(expected, result);

        calendar.set(1900, 01, 01);
        monthInfo = new MonthInfo(calendar.getTime());
        result = monthInfo.getMonthTitle();
        expected = "январь";
        assertEquals(expected, result);

        calendar.set(2020, 02, 12);
        monthInfo = new MonthInfo(calendar.getTime());
        result = monthInfo.getMonthTitle();
        expected = "февраль";
        assertEquals(expected, result);
    }

    @Test
    void getMonthNumber() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, 11, 12);
        MonthInfo monthInfo = new MonthInfo(calendar.getTime());
        int result = monthInfo.getMonthNumber();
        int expected = 11;
        assertEquals(expected, result);

        calendar.set(1900, 01, 01);
        monthInfo = new MonthInfo(calendar.getTime());
        result = monthInfo.getMonthNumber();
        expected = 1;
        assertEquals(expected, result);

        calendar.set(2020, 02, 12);
        monthInfo = new MonthInfo(calendar.getTime());
        result = monthInfo.getMonthNumber();
        expected = 2;
        assertEquals(expected, result);
    }
    @Test
    void getFirstDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, 11, 12);
        MonthInfo monthInfo = new MonthInfo(calendar.getTime());
        String result = monthInfo.getFirstDayOfWeek();
        String expected = "ср";
        assertEquals(expected, result);

        calendar.set(1900, 01, 01);
        monthInfo = new MonthInfo(calendar.getTime());
        result = monthInfo.getFirstDayOfWeek();
        expected = "пн";
        assertEquals(expected, result);

        calendar.set(2020, 02, 12);
        monthInfo = new MonthInfo(calendar.getTime());
        result = monthInfo.getFirstDayOfWeek();
        expected = "сб";
        assertEquals(expected, result);
    }
    @Test
    void getLastDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, 11, 12);
        MonthInfo monthInfo = new MonthInfo(calendar.getTime());
        String result = monthInfo.getLastDayOfWeek();
        String expected = "2023-11-30";
        assertEquals(expected, result);

        calendar.set(1900, 01, 01);
        monthInfo = new MonthInfo(calendar.getTime());
        result = monthInfo.getLastDayOfWeek();
        expected = "1900-01-31";
        assertEquals(expected, result);

        calendar.set(2020, 02, 12);
        monthInfo = new MonthInfo(calendar.getTime());
        result = monthInfo.getLastDayOfWeek();
        expected = "2020-02-29";
        assertEquals(expected, result);
    }

    @Test
    void getMonthLength(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, 11, 12);
        MonthInfo monthInfo = new MonthInfo(calendar.getTime());
        int result = monthInfo.getMonthLength();
        int expected = 30;
        assertEquals(expected, result);

        calendar.set(1900, 01, 01);
        monthInfo = new MonthInfo(calendar.getTime());
        result = monthInfo.getMonthLength();
        expected = 31;
        assertEquals(expected, result);

        calendar.set(2020, 02, 12);
        monthInfo = new MonthInfo(calendar.getTime());
        result = monthInfo.getMonthLength();
        expected = 29;
        assertEquals(expected, result);
    }

    @Test
    void getQuarter() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, 11, 12);
        MonthInfo monthInfo = new MonthInfo(calendar.getTime());
        String result = monthInfo.getQuarter();
        String expected = "2023 Q4";
        assertEquals(expected, result);

        calendar.set(1900, 01, 01);
        monthInfo = new MonthInfo(calendar.getTime());
        result = monthInfo.getQuarter();
        expected = "1900 Q1";
        assertEquals(expected, result);

        calendar.set(2020, 02, 12);
        monthInfo = new MonthInfo(calendar.getTime());
        result = monthInfo.getQuarter();
        expected = "2020 Q1";
        assertEquals(expected, result);
    }
}