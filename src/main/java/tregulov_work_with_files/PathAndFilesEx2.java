package tregulov_work_with_files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathAndFilesEx2 {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("test15.txt");
        Path directoryPath = Paths.get("C:\\Users\\Дима\\Desktop\\M");
        Path directoryBPath = Paths.get("C:\\Users\\Дима\\Desktop\\B");

        Files.copy(filePath, directoryPath.resolve(filePath), StandardCopyOption.REPLACE_EXISTING);
        Files.copy(filePath, directoryPath.resolve("test16.txt"));

        Files.copy(directoryBPath, directoryPath.resolve("B"));
        System.out.println("Done!");

        Files.move(filePath, directoryPath.resolve("test15.txt"));

        Files.move(Paths.get("test10.txt"), (Paths.get("test11.txt")));

        Files.delete(Paths.get("test5.txt"));

        Files.delete(directoryPath);
    }
}
