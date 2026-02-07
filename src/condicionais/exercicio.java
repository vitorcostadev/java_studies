package src.condicionais;

import java.util.Scanner;


public class exercicio {
    public static void main(String[] args) {
        double from = 0;
        double tax = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o valor de entrada: ");
        from=scan.nextDouble();
        scan.close();
        
        if(from >= 0 && from < 34713){
            tax = 9.7;
        }else if(from >= 34713 && from < 68508){
            tax = 37.35;
        }else{
            tax = 49.50;
        }
        double from_with_tax = from + (from * tax);

        System.out.println("From: " + from + "\nTax: " + tax + "%");
        System.out.println("From with tax: " + from_with_tax);
    }
    
}
