package src.exceptions.tests;

import src.exceptions.domain.Funcionario;
import src.exceptions.domain.Pessoa;
import src.exceptions.exception.domain.InvalidLoginException;

public class UnderwritingWithExceptionTest {
    public static void main(String[] args) {
        Pessoa people = new Pessoa();
        Funcionario funcionario = new Funcionario();

        try {
            funcionario.save();
        } catch (InvalidLoginException e) {
            e.printStackTrace();
        }
    }
}
