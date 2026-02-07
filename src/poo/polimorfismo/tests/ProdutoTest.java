package src.poo.polimorfismo.tests;

import src.poo.polimorfismo.domain.Computador;
import src.poo.polimorfismo.domain.Televisao;
import src.poo.polimorfismo.domain.Tomate;
import src.poo.polimorfismo.service.CalculadoraImposto;

public class ProdutoTest {
    public static void main(String[] args) {
        Computador computer = new Computador("PC DA NASA", 9500);
        Tomate tomate = new Tomate("Cereja", 25);
        Televisao tv = new Televisao("LG 50\"", 3199);
        tomate.setDataDeValidade("22/11/2026");


        CalculadoraImposto.calcularImposto(computer);
        System.out.println("---------------------------------");
        CalculadoraImposto.calcularImposto(tomate);
        System.out.println("---------------------------------");
        CalculadoraImposto.calcularImposto(tv);

    }
}
