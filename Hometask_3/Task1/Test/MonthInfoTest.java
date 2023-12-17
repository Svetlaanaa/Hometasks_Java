import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Calendar;
import static org.junit.jupiter.api.Assertions.*;

class MonthInfoTest {

    @Test
    void getMonthTitle() {
        LocalDate localDate = LocalDate.of(2023, 11, 12);
        MonthInfo monthInfo = new MonthInfo(localDate);
        String result = monthInfo.getMonthTitle();
        String expected = "ноябрь";
        assertEquals(expected, result);

        localDate = LocalDate.of(1900, 01, 01);
        monthInfo = new MonthInfo(localDate);
        result = monthInfo.getMonthTitle();
        expected = "январь";
        assertEquals(expected, result);

        localDate = LocalDate.of(2020, 02, 12);
        monthInfo = new MonthInfo(localDate);
        result = monthInfo.getMonthTitle();
        expected = "февраль";
        assertEquals(expected, result);
    }

    @Test
    void getMonthNumber() {
        LocalDate localDate = LocalDate.of(2023, 11, 12);
        MonthInfo monthInfo = new MonthInfo(localDate);
        int result = monthInfo.getMonthNumber();
        int expected = 11;
        assertEquals(expected, result);

        localDate = LocalDate.of(1900, 01, 01);
        monthInfo = new MonthInfo(localDate);
        result = monthInfo.getMonthNumber();
        expected = 1;
        assertEquals(expected, result);

        localDate = LocalDate.of(2020, 02, 12);
        monthInfo = new MonthInfo(localDate);
        result = monthInfo.getMonthNumber();
        expected = 2;
        assertEquals(expected, result);
    }
    @Test
    void getFirstDayOfWeek() {
        LocalDate localDate = LocalDate.of(2023, 11, 12);
        MonthInfo monthInfo = new MonthInfo(localDate);
        String result = monthInfo.getFirstDayOfWeek();
        String expected = "ср";
        assertEquals(expected, result);

        localDate = LocalDate.of(1900, 01, 01);
        monthInfo = new MonthInfo(localDate);
        result = monthInfo.getFirstDayOfWeek();
        expected = "пн";
        assertEquals(expected, result);

        localDate = LocalDate.of(2020, 02, 12);
        monthInfo = new MonthInfo(localDate);
        result = monthInfo.getFirstDayOfWeek();
        expected = "сб";
        assertEquals(expected, result);
    }
    @Test
    void getLastDayOfWeek() {
        LocalDate localDate = LocalDate.of(2023, 11, 12);
        MonthInfo monthInfo = new MonthInfo(localDate);
        String result = monthInfo.getLastDayOfWeek();
        String expected = "2023-11-30";
        assertEquals(expected, result);

        localDate = LocalDate.of(1900, 01, 01);
        monthInfo = new MonthInfo(localDate);
        result = monthInfo.getLastDayOfWeek();
        expected = "1900-01-31";
        assertEquals(expected, result);

        localDate = LocalDate.of(2020, 02, 12);
        monthInfo = new MonthInfo(localDate);
        result = monthInfo.getLastDayOfWeek();
        expected = "2020-02-29";
        assertEquals(expected, result);
    }

    @Test
    void getMonthLength(){
        LocalDate localDate = LocalDate.of(2023, 11, 12);
        MonthInfo monthInfo = new MonthInfo(localDate);
        int result = monthInfo.getMonthLength();
        int expected = 30;
        assertEquals(expected, result);

        localDate = LocalDate.of(1900, 01, 01);
        monthInfo = new MonthInfo(localDate);
        result = monthInfo.getMonthLength();
        expected = 31;
        assertEquals(expected, result);

        localDate = LocalDate.of(2020, 02, 12);
        monthInfo = new MonthInfo(localDate);
        result = monthInfo.getMonthLength();
        expected = 29;
        assertEquals(expected, result);
    }

    @Test
    void getQuarter() {
        LocalDate localDate = LocalDate.of(2023, 11, 12);
        MonthInfo monthInfo = new MonthInfo(localDate);
        String result = monthInfo.getQuarter();
        String expected = "2023 Q4";
        assertEquals(expected, result);

        localDate = LocalDate.of(1900, 01, 01);
        monthInfo = new MonthInfo(localDate);
        result = monthInfo.getQuarter();
        expected = "1900 Q1";
        assertEquals(expected, result);

        localDate = LocalDate.of(2020, 02, 12);
        monthInfo = new MonthInfo(localDate);
        result = monthInfo.getQuarter();
        expected = "2020 Q1";
        assertEquals(expected, result);
    }
}