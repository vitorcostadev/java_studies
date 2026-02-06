package src.regex.tests;

import java.util.Scanner;

public class ScannerTest01 {
    public static void main(String[] args) {
        String texto = "";
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter(",");

        System.out.print("Digite um texto: ");
        while(scan.hasNextLine()){
            System.out.println(scan.nextLine());
        }
    }
}
