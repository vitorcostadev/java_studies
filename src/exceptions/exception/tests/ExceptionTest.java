package src.exceptions.exception.tests;

import java.io.File;
import java.io.IOException;

public class ExceptionTest {
    public static void main(String[] args) throws IOException {
        createNewFile();
    }

    public static void createNewFile()  throws IOException{
        File file = new File("files\\teste.txt");
        boolean isFileCreated = file.createNewFile();
        System.out.println("O arquivo foi criado! "+isFileCreated);


    }
}
