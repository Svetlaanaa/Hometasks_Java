import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    public static void one_task(){
        double[] array = {30.0, 10000.1, 12.5, 99.99, 0.0, -23.45, -4.5, -129.675};
        System.out.printf("%9s |%8s |%8s |%8s |%8s |\n", "значение", "round", "ceil", "floor", "rint");
        System.out.println("-----------------------------------------");
        for (double value : array) {
            System.out.printf("%9s |", value);
            System.out.printf("%8s |", Math.round(value));
            System.out.printf("%8s |", Math.ceil(value));
            System.out.printf("%8s |", Math.floor(value));
            System.out.printf("%8s |\n", Math.rint(value));
        }
        System.out.println();
    }
    public static void two_task(String value) {
        try {
            double number = Double.parseDouble(value);
            if (number == (int) number) {
                System.out.println("Это целое число");
            } else {
                System.out.println("Это рациональное число");
            }
        } catch (NumberFormatException e) {
            if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
                System.out.println("Это логическое значение");
            } else {
                System.out.println("Это текст");
            }
        }
    }
    public static void three_task(){
        Scanner in = new Scanner(System.in);
        int count = 0;
        double quantity = 0;
        double min = 0;
        double max = 0;
        try{
            System.out.print("Введите значение: ");
            double value = Double.parseDouble(in.nextLine());
            min = value;
            max = value;
            quantity += value;
            count++;
            while (true){
                System.out.print("Введите значение: ");
                value = Double.parseDouble(in.nextLine());
                if(min > value) min = value;
                if(max < value) max = value;
                quantity += value;
                count++;
            }
        }catch (NumberFormatException e){
            System.out.println("Количество чисел: " + count);
            System.out.println("Минимальное значение: " + min);
            System.out.println("Максимальное значение: " + max);
            System.out.println("Сумма чисел: " + quantity);
        }
    }

    public static void four_task() {
        try {
            Scanner in = new Scanner(System.in);
            int max_length;
            int length;
            int value;
            System.out.println("Введите длину последовательности");
            int count = in.nextInt();
            if(count > 0){
                value = (int) (Math.random() * (10 + 10) - 10);
                System.out.print(value + " ");
                boolean plus = value > 0;
                if (value == 0)
                    length = 0;
                else
                    length = 1;
                max_length = length;

                for (int i = 1; i < count; i++){
                    value = (int) (Math.random() * (10 + 10) - 10);
                    System.out.print(value + " ");
                    if ((plus & value < 0) | (!plus & value > 0)){
                        length = 0;
                        plus = value > 0;
                    }
                    if(value == 0)
                        length = -1;
                    length++;
                    if (max_length < length)
                        max_length = length;
                }
                System.out.println("\nМаксимальная длина знакоповторяющейся последовательности: " + max_length);
            }else System.out.println("Введите положительное число");
        } catch (InputMismatchException e) {
            System.out.println("Некорректный ввод");
        }
    }
    public static void main(String[] args) {
        System.out.println("    №1 ОКРУГЛЕНИЕ ЧИСЕЛ");
        one_task();

        System.out.println("    №2 ОПРЕДЕЛЕНИЕ ТИПА");
        Scanner in = new Scanner(System.in);
        System.out.print("Введите значение: ");
        String value = in.nextLine();
        two_task(value);

        System.out.println("    №3 РАБОТА С ПОСЛЕДОВАТЕЛЬНОСТЬЮ ЧИСЕЛ");
        three_task();

        System.out.println("    №4 САМАЯ ДЛИННАЯ СЕРИЯ ЗНАКОПОВТОРЕНИЙ");
        four_task();
    }
}
