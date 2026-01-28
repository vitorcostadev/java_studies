package src.exceptions.exception.tests;

import src.exceptions.exception.domain.Leitor1;
import src.exceptions.exception.domain.Leitor2;

import java.io.*;

public class TryWithResourcesTest {
    static void main() {
        readArchive();
    }

    public static void readArchive(){
        try(Leitor1 leitor1 = new Leitor1();
            Leitor2 leitor2 = new Leitor2()){

        }catch(IOException e){

        }
    }
    public static void readArchive2(){
        Reader reader = null;
        try {
            reader = new BufferedReader(new FileReader("teste.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally{
            try {
                if(reader != null){
                    reader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
