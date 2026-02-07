package src.io.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedFileReader {
    public static void main(String[] args) {
        File file = new File("files\\file.txt");
        try(FileReader fw = new FileReader(file);
            BufferedReader br = new BufferedReader(fw)){
                String linha;
                while((linha = br.readLine()) != null){
                    System.out.println(linha.trim());
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            
    }
    
}
