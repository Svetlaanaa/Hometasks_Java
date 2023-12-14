import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DateDifferenceTest {

    @Test
    void getDifferences() {
        assertEquals("0", DateDifference.getDifferences("2023-11-12T00:00:00Z", "UTC+00", "UTC+00"));
        assertEquals("HOUR", DateDifference.getDifferences("2020-06-01T14:25:16Z", "UTC+01", "UTC+02"));
        assertEquals("HOUR", DateDifference.getDifferences("2020-06-01T14:25:16Z", "UTC+05", "UTC+01"));
        assertEquals("DAY", DateDifference.getDifferences("2023-05-10T23:00:00Z", "UTC-03", "UTC+04"));
        assertEquals("MONTH", DateDifference.getDifferences("2024-10-01T04:59:59Z", "UTC-08", "UTC-04"));
        assertEquals("YEAR", DateDifference.getDifferences("2010-12-31T20:15:00Z", "Europe/Moscow", "Asia/Vladivostok"));
    }
}