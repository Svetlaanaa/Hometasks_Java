import com.sun.source.tree.UsesTree;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class MonthInfo {
    private final Calendar calendar;

    public MonthInfo(Date date) {
        this.calendar = Calendar.getInstance();
        this.calendar.setTime(date);
    }
    public MonthInfo(){
        this.calendar = Calendar.getInstance();
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public String getMonthTitle(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("LLLL");
        LocalDate localDate = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) , calendar.get(Calendar.DAY_OF_MONTH));
        return localDate.format(formatter);
    }
    public int getMonthNumber(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M");
        LocalDate localDate = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) , calendar.get(Calendar.DAY_OF_MONTH));
        return Integer.parseInt(localDate.format(formatter));
    }
    public String getFirstDayOfWeek(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E");
        LocalDate localDate = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) , 1);
        return localDate.format(formatter);
    }

    public String getLastDayOfWeek(){
        LocalDate currentDay = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) , calendar.get(Calendar.DAY_OF_MONTH));
        int lengthOfMonth = currentDay.lengthOfMonth();
        LocalDate localDate = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) , lengthOfMonth);
        return localDate.toString();
    }

    public int getMonthLength(){
        LocalDate currentDay = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) , calendar.get(Calendar.DAY_OF_MONTH));
        int lengthOfMonth = currentDay.lengthOfMonth();
        return lengthOfMonth;
    }

    public String getQuarter(){
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        if(month <= 3)
            return year + " Q" + 1;
        else if(month > 3 & month <= 6)
            return year + " Q" + 2;
        else if(month > 6 & month <= 9)
            return year + " Q" + 3;
        else
            return year + " Q" + 4;
    }
}
