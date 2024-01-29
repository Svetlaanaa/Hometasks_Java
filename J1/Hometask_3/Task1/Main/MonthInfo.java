import com.sun.source.tree.UsesTree;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class MonthInfo {
    private final LocalDate localDate;

    public MonthInfo(LocalDate localDate) {
        this.localDate = localDate;
    }
    public MonthInfo(){
        this.localDate = LocalDate.now();
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public String getMonthTitle(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("LLLL");
        return localDate.format(formatter);
    }
    public int getMonthNumber(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M");
        return Integer.parseInt(localDate.format(formatter));
    }
    public String getFirstDayOfWeek(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E");
        LocalDate localDate2 = LocalDate.of(localDate.getYear(), localDate.getMonth() , 1);
        return localDate2.format(formatter);
    }

    public String getLastDayOfWeek(){
        int lengthOfMonth = localDate.lengthOfMonth();
        LocalDate localDate2 = LocalDate.of(localDate.getYear(), localDate.getMonth() , lengthOfMonth);
        return localDate2.toString();
    }

    public int getMonthLength(){
        int lengthOfMonth = localDate.lengthOfMonth();
        return lengthOfMonth;
    }

    public String getQuarter(){
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
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
