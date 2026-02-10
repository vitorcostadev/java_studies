package desafios.sistemaDeCadastroDePet.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    
    public static boolean isValidNameAndSubName(String nameOrSubName){
        return isValidGender(nameOrSubName);
    }

    public static boolean isValidAgeOrSize(String ageOrSize){
        Pattern pattern = Pattern.compile("^[\\p{N},.]+$");
        Matcher matcher = pattern.matcher(ageOrSize);

        return matcher.find();
    }

    public static boolean isValidGender(String gender){
        Pattern pattern = Pattern.compile("^[\\p{L}\\s]+$");
        Matcher matcher = pattern.matcher(gender);

        return matcher.find();
    }
}
