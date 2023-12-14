import java.time.LocalDate;
import java.util.Calendar;

public class Weekends {
    static public int getCountWeekend(LocalDate date1, LocalDate date2){
        int countWeekend = 0;
        while (!date1.isAfter(date2)){
            if(date1.getDayOfWeek().getValue() == 6 | date1.getDayOfWeek().getValue() == 7){
                countWeekend++;
            }
            date1 = date1.plusDays(1);
        }
        return countWeekend;
    }
}
