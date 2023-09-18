package tregulov_work_with_files;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TryWithRes {
    public static void main(String[] args) throws IOException {
        String text = "Hello!!!\n";
        try (FileReader reader = new FileReader("test2.txt");
             FileWriter writer = new FileWriter("test2.txt", true);) {
            int character;
            writer.write(text);
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            System.out.println();
            System.out.println("Done!");
        }
    }
}
