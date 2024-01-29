package J2.Hometask_1.Task2;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class MaxDepth implements FileVisitor<Path> {
    private int maxDepth = -1;
    private int currentDepth = 0;

    public int getMaxDepth() {
        return maxDepth;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        if (currentDepth > maxDepth) {
            maxDepth = currentDepth;
        }
        currentDepth++;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        currentDepth--;
        return FileVisitResult.CONTINUE;
    }
}
