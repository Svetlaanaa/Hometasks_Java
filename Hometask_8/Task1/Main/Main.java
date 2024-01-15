import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Example example = new Example();
        String value;
        while (true){
            System.out.println("Введите текстовое значение");
            value =  scanner.nextLine();
            example.getMessage(value);

            if (value.equalsIgnoreCase("конец")) {
                break;
            }
        }
    }
}
