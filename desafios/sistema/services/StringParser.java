package desafios.sistema.services;

import java.util.List;

public class StringParser {
    public static boolean isString(String name){
        if(name.isEmpty()) return false;
        for(char c : name.trim().toCharArray()){
            if(!Character.isAlphabetic(c) && !Character.isSpaceChar(c)) return false;
        }
        return true;
    }

    public static boolean isNumber(String number){
        if(number.isEmpty()) return false;
        if(!Character.isDigit(number.charAt(0)) && number.charAt(0) != '-') return false;
        if(number.contains(",")) number = number.replace(",", ".");

        byte point = 0;
        for (int i = 0; i < number.length(); i++) {
            if(!Character.isDigit(number.charAt(i))){
                if(number.charAt(i) == '.') point++;
            }
            if(!Character.isDigit(number.charAt(i)) && number.charAt(i) == '.' && point != 1) return false;
        }
        return true;
    }

}
