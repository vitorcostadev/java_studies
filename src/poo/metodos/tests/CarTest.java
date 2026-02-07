package src.poo.metodos.tests;

import src.poo.metodos.classes.Car;


public class CarTest {
    public static void main(String[] args) {
        Car carro = new Car();
        Car carro2 = new Car();

        carro.nome = "BMW M4";
        carro.ano = 2017;
        carro.modelo = "M4";

        carro2.nome = "ByD Seal";
        carro2.ano = 2024;
        carro2.modelo = "Seal";

        System.out.println(carro.nome + " " + carro.ano + " " + carro.modelo);
        System.out.println(carro2.nome + " " + carro2.ano + " " + carro2.modelo);
    }
    
}
