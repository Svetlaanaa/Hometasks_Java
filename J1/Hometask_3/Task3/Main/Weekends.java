import java.time.DayOfWeek;
import java.time.LocalDate;

public class Weekends {
    static public int getCountWeekend(LocalDate date1, LocalDate date2){
        int countWeekend = 0;
        while (!date1.isAfter(date2)){
            if(date1.getDayOfWeek().equals(DayOfWeek.SATURDAY) || date1.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
                countWeekend++;
            }
            date1 = date1.plusDays(1);
        }
        return countWeekend;
    }
}
