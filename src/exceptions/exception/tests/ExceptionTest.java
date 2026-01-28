package src.exceptions.exception.tests;

import java.io.File;
import java.io.IOException;

public class ExceptionTest {
    static void main() {
        createNewFile();
    }

    public static void createNewFile()  {
        File file = new File("files\\teste.txt");
        try{
            boolean isFileCreated = file.createNewFile();
            System.out.println("O arquivo foi criado! "+isFileCreated);
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
