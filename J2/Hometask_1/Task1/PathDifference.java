package J2.Hometask_1.Task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PathDifference {
    public static boolean isNotExists(Path path1, Path path2){
        return (!Files.exists(path1) || !Files.exists(path2));
    }
    public static boolean isSameFile(Path path1, Path path2) throws IOException {
        return (Files.isSameFile(path1, path2));
    }
    public static boolean isBiggerFile(Path path1, Path path2) throws IOException {
        return (Files.size(path1) > Files.size(path2));
    }
    public static boolean isSmallerFile(Path path1, Path path2) throws IOException {
        return (Files.size(path1) < Files.size(path2));
    }
    public static boolean isSameSizeFile(Path path1, Path path2) throws IOException {
        return (Files.size(path1) == Files.size(path2));
    }
    public static boolean isSameDirectory(Path path1, Path path2) throws IOException {
        return (Files.isDirectory(path1) && Files.isDirectory(path2) && path1.equals(path2));
    }
    public static boolean isSameAbsoluteNameDepth(Path path1, Path path2) throws IOException {
        if(path1.isAbsolute() && path2.isAbsolute()) {
            if (path1.getNameCount() == path2.getNameCount()) {
                return true;
            }
        }
        Path absolutePath1 = path1.toAbsolutePath();
        Path absolutePath2 = path2.toAbsolutePath();
        if(absolutePath1.getNameCount() == absolutePath2.getNameCount()){
            return true;
        }
        return false;
    }

    public static boolean isSamePrefix(Path path1, Path path2) throws IOException {
        return (path1.getParent().equals(path2.getParent()));
    }

    public static boolean isSameRoot(Path path1, Path path2){
        if(path1.getRoot() != null && path2.getRoot() != null){
            if(path1.getRoot().equals(path2.getRoot())){
                return true;
            }
        }
        if(path1.getParent().equals(path2.getParent())){
            return true;
        }
        return false;
    }

    public static boolean isSubPath(Path path1, Path path2) {
        return (!path1.relativize(path2).isAbsolute());
    }

    public static List<PathDifferenceStatus> difference(Path path1, Path path2) throws IOException {
        List<PathDifferenceStatus> differences = new ArrayList<>();

        if (isNotExists(path1, path2)) {
            differences.add(PathDifferenceStatus.NOT_EXISTS);
        }

        if (isSameFile(path1, path2)){
            differences.add(PathDifferenceStatus.SAME_FILE);
        }

        if(isBiggerFile(path1, path2)){
            differences.add(PathDifferenceStatus.BIGGER_FILE);
        }
        if (isSmallerFile(path1, path2)) {
            differences.add(PathDifferenceStatus.SMALLER_FILE);
        }
        if(isSameSizeFile(path1, path2)) {
            differences.add(PathDifferenceStatus.SAME_SIZE_FILE);
        }

        if(isSameDirectory(path1, path2)){
            differences.add(PathDifferenceStatus.SAME_DIRECTORY);
        }

        if(isSameAbsoluteNameDepth(path1, path2)){
            differences.add(PathDifferenceStatus.SAME_ABSOLUTE_NAME_DEPTH);
        }

        if(isSamePrefix(path1, path2)){            //не работает
            differences.add(PathDifferenceStatus.SAME_PREFIX);
        }

        if(isSameRoot(path1, path2)){
            differences.add(PathDifferenceStatus.SAME_ROOT);
        }

        if (isSubPath(path1, path2)) {      //не работает
            differences.add(PathDifferenceStatus.SUB_PATH);
        }
        if (isSubPath(path2, path1)) {
            differences.add(PathDifferenceStatus.PARENT_PATH);
        }

        return differences;
    }
}

enum PathDifferenceStatus{
    NOT_EXISTS,                 //хотя бы один из двух путей ведет к несуществующему файлу/каталогу
    SAME_FILE,                  //оба пути ведут к одному файлу
    BIGGER_FILE,                //оба пути ведут к файлу, при этом размер path1 > path2
    SMALLER_FILE,               //оба пути ведут к файлу, при этом размер path1 < path2
    SAME_SIZE_FILE,             //оба пути ведут к файлу, при этом размеры файлов совпадают
    SAME_DIRECTORY,             //оба пути ведут к одной директории
    SAME_ABSOLUTE_NAME_DEPTH,   //глубина (число частей) абсолютного пути к файлам одинаковая
    SAME_PREFIX,                //пути имеют общее начало (не считая корня)
    SAME_ROOT,                  //пути имеют общий корень
    SUB_PATH,                   //path2 находится внутри path1
    PARENT_PATH                 //path1 находится внутри path2
}