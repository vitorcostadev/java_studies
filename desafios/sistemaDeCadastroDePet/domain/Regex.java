package desafios.sistemaDeCadastroDePet.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    
    public static boolean isValidNameAndSubName(String nameOrSubName){
        Pattern pattern = Pattern.compile("^[\\p{L}\\s]+$");
        Matcher matcher = pattern.matcher(nameOrSubName);

        return matcher.find();
    }

    public static boolean isValidAgeOrSize(String ageOrSize){
        Pattern pattern = Pattern.compile("^[\\p{N},\\.]+$");
        Matcher matcher = pattern.matcher(ageOrSize);

        return matcher.find();
    }

    public static boolean isValidGender(String gender){
        Pattern pattern = Pattern.compile("^[\\p{L}\\s]+$");
        Matcher matcher = pattern.matcher(gender);

        return matcher.find();
    }
}
