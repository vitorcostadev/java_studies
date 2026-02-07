package src.poo.metodos.tests;

import src.poo.metodos.classes.Pessoa;


public class PessoaTest {
    public static void main(String[] args) {
        Pessoa people = new Pessoa();

        people.setNome("Jorge");
        people.setIdade(25);
        System.out.println(people.getNome());
        System.out.println(people.getIdade());
    }
    
}
