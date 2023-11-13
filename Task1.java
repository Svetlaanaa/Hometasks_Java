import java.util.Scanner;

public class Task1 {
    public static void one_task(){
        double[] array = {30.0, 10000.1, 12.5, 99.99, 0.0, -23.45, -4.5, -129.675};
        System.out.printf("%9s |%8s |%8s |%8s |\n", "значение", "round", "ceil", "floor");
        System.out.println("-----------------------------------------");
        for (double value : array) {
            System.out.printf("%9s |", value);
            System.out.printf("%8s |", Math.round(value));
            System.out.printf("%8s |", Math.ceil(value));
            System.out.printf("%8s |\n", Math.floor(value));
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
        Scanner in = new Scanner(System.in);
        int max_length = 0;
        try {
            System.out.println("Введите длину последовательности");
            int count = in.nextInt();
            int length = 0;
            int i = 0;
            int value = (int) (Math.random() * (1000 + 1000) - 1000);
            System.out.print(value + " ");
            while (i < count) {
                while (value > 0 & i < count) {
                    value = (int) (Math.random() * (1000 + 1000) - 1000);
                    System.out.print(value + " ");
                    length++;
                    i++;
                    if (max_length < length) max_length = length;
                }
                length = 0;
                while (value < 0 & i < count) {
                    value = (int) (Math.random() * (1000 + 1000) - 1000);
                    System.out.print(value + " ");
                    length++;
                    i++;
                    if (max_length < length) max_length = length;
                }
                length = 0;
            }
            System.out.println();
            System.out.println("Максимальная длина знакоповторяющейся последовательности: " + max_length);
        } catch (NumberFormatException e) {
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
