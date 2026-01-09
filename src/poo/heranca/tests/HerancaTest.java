package src.poo.heranca.tests;

import src.poo.heranca.classes.Address;
import src.poo.heranca.classes.Pessoa;

public class HerancaTest {
    public static void main(String[] args) {
        Address address = new Address();
        address.setRua("Rua Coelho");
        address.setCep("88111650");

        Pessoa pessoa = new Pessoa();
        pessoa.setAddress(address);
        pessoa.setName("Asuna Yuuki");
        pessoa.setCpf("000.000.000-00");
    }
    
}
    