import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateDifference {
    public static String getDifferences(String dateTimeUTC, String zone1, String zone2){
        LocalDateTime utcDateTime = LocalDateTime.parse(dateTimeUTC, DateTimeFormatter.ISO_DATE_TIME);
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(utcDateTime, ZoneId.of(zone1));
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(utcDateTime, ZoneId.of(zone2));
        if (ChronoUnit.YEARS.between(zonedDateTime1, zonedDateTime2) != 0) {
            return "YEAR";
        }else if (ChronoUnit.MONTHS.between(zonedDateTime1, zonedDateTime2) != 0) {
            return "MONTH";
        } else if (ChronoUnit.DAYS.between(zonedDateTime1, zonedDateTime2) != 0) {
            return "DAY";
        } else if (ChronoUnit.HOURS.between(zonedDateTime1, zonedDateTime2) != 0) {
            return "HOUR";
        }else {
            return "0";
        }
    }

}
