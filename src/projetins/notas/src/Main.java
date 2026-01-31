package src.projetins.notas.src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        String path = "C:\\Users\\yori0\\OneDrive\\Documentos\\Cjava\\src\\projetins\\notas\\files";

        File file = new File(path+"\\notas.txt");

        try{
            if(!file.exists()){
                boolean isCreated = file.createNewFile();
                System.out.println("Arquivo criado: "+(!isCreated ? "Não" : "Sim"));
            }

        }catch(IOException e){
            throw new RuntimeException(e);
        }

        try(FileWriter fw = new FileWriter(file, true)){
            Scanner scan = new Scanner(System.in);
            IO.print("Digite um texto para ser salvo: ");
            fw.write(scan.nextLine().trim()+"\n");
            fw.flush();

            scan.close();
        }catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
