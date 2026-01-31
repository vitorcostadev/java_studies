package src.regex.tests;

import java.util.Scanner;

public class ScannerTest01 {
    void main(){
        String texto = "";
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter(",");

        IO.print("Digite um texto: ");
        while(scan.hasNextLine()){
            System.out.println(scan.nextLine());
        }
    }
}
