package src.io.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest {
    void main(){
        File file = new File("C:\\Users\\yori0\\OneDrive\\Documentos\\Cjava\\files\\file.txt");
        try(FileWriter fw = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fw)) {
            br.write("O pai é lindao tmj!");
            br.newLine();
            br.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
