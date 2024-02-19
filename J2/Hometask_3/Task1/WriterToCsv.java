package J2.Hometask_3.Task1;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.Writer;
import java.util.ArrayList;

public class WriterToCsv {
    public static boolean save(ArrayList<MoexData> weatherList, Writer writer) {
        try {
            StatefulBeanToCsv<MoexData> beanToCsv = new StatefulBeanToCsvBuilder<MoexData>(writer)
                    .build();
            beanToCsv.write(weatherList);
            return true;
        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            return false;
        }
    }
}
