package desafios.avaliador.src.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class Parser {

    public static final List<Character> OPERATORS = List.of(
            '+', '-', '/', '*', '(', ')'
    );

    public static String removeAllInvalidChar(String phrase) {
        if (phrase.isEmpty()) {
            throw new IllegalArgumentException("The parameter phrase is empty.");
        }

        phrase = phrase.trim();
        StringBuilder newString = new StringBuilder();

        for (char c : phrase.toCharArray()) {
            if (Character.isSpaceChar(c) ||
                    Character.isDigit(c) ||
                    Character.isAlphabetic(c) ||
                    OPERATORS.contains(c)) {

                newString.append(c);
            }
        }

        return newString.toString();
    }

    public static int getPriority(char c) {

        return switch (c) {
            case '\uF070' -> 0; // π
            case '\uF06C' -> 1; // λ
            case '(', ')' -> 2;
            case '+', '-' -> 3;
            case '*', '/' -> 4;
            default -> 5; // operando (número/letra)
        };
    }
}