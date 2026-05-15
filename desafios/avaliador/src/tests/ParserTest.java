package desafios.avaliador.src.tests;

import desafios.avaliador.src.domain.ExpressionValidator;

public class ParserTest {
    public static void main(String[] args) {
        ExpressionValidator exp = new ExpressionValidator("((90*3)+(213+(111+2))+(123/2)*(342/5)+(3/1)-(123*2)/(3*6))");
        exp.toPostfix();
        System.out.println(exp.getPostfix());
        System.out.println(exp.getResult());
    }


}
