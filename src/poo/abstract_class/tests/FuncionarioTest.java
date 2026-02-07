package src.poo.abstract_class.tests;

import src.poo.abstract_class.classes.Developer;
import src.poo.abstract_class.classes.Gerente;

public class FuncionarioTest {
    public static void main(String[] args) {
        Gerente func = new Gerente("Zoro", 2500);
        Developer dev = new Developer("Nami", 4500);
        
        func.imprime();
        dev.imprime();
    }
}
