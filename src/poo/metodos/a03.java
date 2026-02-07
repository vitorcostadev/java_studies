package src.poo.metodos;

import src.poo.metodos.classes.Car;

public class a03 {
    public static void main(String[] args) {
        // Parametros por referencia + this
        Car carro = new Car();

        carro.ano = 2025;
        carro.modelo = "Exclusive";
        carro.nome = "Virtus";

        carro.imprimeInfo();
    }
    
}
