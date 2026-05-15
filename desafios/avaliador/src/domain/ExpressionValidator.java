package desafios.avaliador.src.domain;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class ExpressionValidator {

    private final String expression;
    private final Queue<Character> infix = new LinkedBlockingQueue<>();
    private final Queue<Character> postfix = new LinkedBlockingQueue<>();
    private final Stack<Character> stack = new Stack<>();

    public ExpressionValidator(String expression) {
        this.expression = expression;

        for (char c : Parser.removeAllInvalidChar(expression).toCharArray()) {
            infix.add(c);
        }
    }

    public String getExpression() {
        return expression;
    }

    public Queue<Character> getInfix() {
        return infix;
    }

    public Queue<Character> getPostfix() {
        return postfix;
    }

    public void toPostfix() {
        infix.add('\uF06C');

        stack.push('\uF070');

        char x, y;

        do {
            x = infix.poll();
            if(Character.isSpaceChar(x)) continue;

            if (Parser.getPriority(x) == 5) {
                postfix.add(x);

            } else if (x == '(') {
                stack.push(x);

            } else if (x == ')') {
                y = stack.pop();

                while (y != '(') {
                    postfix.add(y);
                    y = stack.pop();
                }

            } else {
                while (Parser.getPriority(x) <= Parser.getPriority(stack.peek())) {
                    y = stack.pop();
                    postfix.add(y);
                }

                stack.push(x);
            }

        } while (x != '\uF06C');
    }

    public double getResult() {
        if (postfix.isEmpty()) {
            throw new RuntimeException("Expressão vazia");
        }

        Stack<Double> stack = new Stack<>();

        for (Character c : postfix) {
            if (Character.isSpaceChar(c)) continue;

            if (Parser.getPriority(c) == 5) {
                stack.push((double) (c - '0'));

            } else {

                if (stack.size() < 2) {
                    throw new RuntimeException("Expressão inválida");
                }

                double b = stack.pop();
                double a = stack.pop();

                double result = switch (c) {
                    case '+' -> a + b;
                    case '-' -> a - b;
                    case '*' -> a * b;
                    case '/' -> a / b;
                    default -> throw new RuntimeException("Operador inválido: " + c);
                };

                stack.push(result);
            }
        }

        if (stack.size() != 1) {
            throw new RuntimeException("Expressão mal formada");
        }

        return stack.pop();
    }
}