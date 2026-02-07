package src.exceptions.domain;

import src.exceptions.exception.domain.InvalidLoginException;

public class Funcionario extends Pessoa{
    @Override
    public void save() throws InvalidLoginException {
        System.out.println("Saving funcionario...");
    }
}
