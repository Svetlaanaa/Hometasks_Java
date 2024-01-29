package J2.Hometask_1.Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Неверное количество аргументов");
            return;
        }
        Path path = Paths.get(args[0]);

        MaxDepth visitor = new MaxDepth();
        try {
            Files.walkFileTree(path, visitor);
            System.out.println("Максимальная глубина вложенности: " + visitor.getMaxDepth());
            if (!Files.isDirectory(path)) {
                System.out.println("This is not a directory");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
