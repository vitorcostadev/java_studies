package src.poo.heranca.tests;

import src.poo.heranca.classes.Address;
import src.poo.heranca.classes.Funcionario;
import src.poo.heranca.classes.Pessoa;

public class HerancaTest {
    public static void main(String[] args) {
        Address address = new Address();
        address.setRua("Rua Coelho");
        address.setCep("88111650");

        Pessoa pessoa = new Pessoa("Asuna Yuuki");
        pessoa.setAddress(address);
        pessoa.setCpf("000.000.000-00");

        Funcionario func = new Funcionario("Asuna Yuuki", 2500);

        func.setAddress(address);
        func.setCpf("0000000");

        pessoa.imprimirInfo();
        System.out.println("------------------------------------------");
        func.imprimirInfo();
    }
    
}
    