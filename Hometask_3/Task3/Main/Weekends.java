import java.time.LocalDate;
import java.util.Calendar;

public class Weekends {
    static public int getCountWeekend(Calendar calendar1, Calendar calendar2){
        int countWeekend = 0;
        LocalDate date1 = LocalDate.of(calendar1.get(Calendar.YEAR), calendar1.get(Calendar.MONTH) , calendar1.get(Calendar.DAY_OF_MONTH));
        LocalDate date2 = LocalDate.of(calendar2.get(Calendar.YEAR), calendar2.get(Calendar.MONTH) , calendar2.get(Calendar.DAY_OF_MONTH));
        while (!date1.isAfter(date2)){
            if(date1.getDayOfWeek().getValue() == 6 | date1.getDayOfWeek().getValue() == 7){
                countWeekend++;
            }
            date1 = date1.plusDays(1);
        }
        return countWeekend;
    }
}
