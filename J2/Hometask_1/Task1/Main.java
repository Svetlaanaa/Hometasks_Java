package J2.Hometask_1.Task1;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("C:\\Users\\Svetlana\\Downloads");
        Path path2 = Paths.get("C:\\Users\\Svetlana\\Downloads\\1.doc");
        System.out.println(PathDifference.difference(path1, path2));
    }
}
