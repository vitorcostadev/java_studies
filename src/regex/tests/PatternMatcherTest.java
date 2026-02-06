package src.regex.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest {
    public static void main(String[] args) {
        String regex = "0xFFA321 0xF 0xFG 0x1";
        Pattern pattern = Pattern.compile("0[xX]([0-9a-fA-F])+(\\s|$)");
        List<String> matchers = getRegexString(pattern, regex);

        String regex2 = "fulanodetal@outlook.com, asuna992@gmail.com, #@!flamengogg@mail.br, teste@gmail.com.br, sakura@mail";
        Pattern pattern2 = Pattern.compile("([a-zA-Z0-9._-])+@([A-Za-z])+(\\.([a-z])+)+");
        List<String> matchers2 = getRegexString(pattern2, regex2);

        if(matchers2 != null){
            for(String match : matchers2){
                System.out.println(match);
            }
        }

    }

    public static List<String> getRegexString(Pattern pattern, String text){
        Matcher matcher = pattern.matcher(text);
        List<String> matchers = new ArrayList<>();

        while(matcher.find()){
            matchers.add(matcher.group());
        }

        return !matchers.isEmpty() ? matchers : null;

    }
}
