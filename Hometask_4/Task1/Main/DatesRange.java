import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DatesRange {
    static public String[] getDateArray(LocalDate date1, LocalDate date2){
        long countDays = ChronoUnit.DAYS.between(date1, date2) + 1;
        String[] localDates = new String[(int)countDays];
        for (int i = 0; i < countDays; i++){
            localDates[i] = date1.toString();
            date1 = date1.plusDays(1);
        }
        return localDates;
    }
}
