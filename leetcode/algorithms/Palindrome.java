package leetcode.algorithms;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        try(Scanner scan = new Scanner(System.in)){
            isPalindrome(scan);
        }
    }

    public static void isPalindrome(Scanner scanner){

        String phrase;
        
        while(true){
            System.out.print("Digite uma frase: ");
            phrase = scanner.nextLine().trim().toLowerCase();

            for(int i = 0; i < phrase.length()/2; i++){
                int j = phrase.length() - 1 - i;

                if(phrase.charAt(i) != phrase.charAt(j)){
                    System.out.println(phrase + " não é palindromo!");
                    return;
                }
            }
            System.out.println(phrase + " é palindromo!");
        }
    }
}
