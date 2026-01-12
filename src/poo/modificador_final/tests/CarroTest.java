package src.poo.modificador_final.tests;

import src.poo.modificador_final.classes.Carro;
import src.poo.modificador_final.classes.Comprador;

public class CarroTest {
    public static void main(String[] args) {
        Carro carro = new Carro();
        Comprador comprador = new Comprador();

        System.out.println(carro);
        System.out.println(comprador);
        System.out.println(Carro.SPEED_LIMIT);
    }
}
