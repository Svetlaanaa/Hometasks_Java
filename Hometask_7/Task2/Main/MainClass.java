import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        People people = new People();
        String input;
        while (true){
            System.out.print("Введите свое имя и список любимок через двоеточие: ");
            input = scanner.nextLine();
            if (!input.matches("[а-яА-Я]+\\s*:[\\s*[а-яА-Я],\\s*]+[а-яА-Я]+\\s*")){
                System.out.println("Неверный формат ввода");
            }else {
                String[] parts = input.split(":\\s*");
                String name = parts[0].toLowerCase();
                List<String> favorites = new ArrayList<String>();
                parts = parts[1].split("\\s*,\\s*");
                for (int i = 0; i < parts.length; i++){
                    favorites.add(parts[i].toLowerCase());
                }

                people.addMan(new Man(name, favorites));
                System.out.println(people.getAllFavorites());
                System.out.println(people.getUniversalFavorites());
            }

        }
    }
}
