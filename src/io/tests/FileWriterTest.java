package src.io.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\yori0\\OneDrive\\Documentos\\Cjava\\files\\file.txt");
        try(FileWriter fw = new FileWriter(file, true);) {
            fw.write("O pai é lindao tmj!");
            fw.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
