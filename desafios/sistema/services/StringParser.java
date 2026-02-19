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

    public static Double isNumber(String number){
        if(number.isEmpty()) return null;
        if(!Character.isDigit(number.charAt(0)) && number.charAt(0) != '-') return null;
        if(number.contains(",")) number = number.replace(",", ".");

        byte point = 0;
        for (int i = 0; i < number.length(); i++) {
            if(!Character.isDigit(number.charAt(i))){
                if(number.charAt(i) == '.') point++;
            }
            if(!Character.isDigit(number.charAt(i)) && number.charAt(i) == '.' && point != 1) return null;
        }
        return Double.valueOf(number);
    }

}
