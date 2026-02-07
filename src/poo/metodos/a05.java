package src.poo.metodos;

import src.poo.metodos.classes.Carro;

public class a05 {
    public static void main(String[] args) {
        Carro car = new Carro("BMW", 275);
        Carro car2 = new Carro("Mercedes-Benz", 280);
        Carro car3 = new Carro("Audi", 290);

        Carro.setSpeedLimit(180);
        car.imprimirInfo();
        car2.imprimirInfo();
        car3.imprimirInfo();


    }
    
}
