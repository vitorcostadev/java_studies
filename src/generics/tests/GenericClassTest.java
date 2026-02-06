package src.generics.tests;

import src.generics.domain.Carro;
import src.generics.service.RentCarService;

public class GenericClassTest {
    public static void main(String[] args) {
        RentCarService rentCarService = new RentCarService();
        Carro car = rentCarService.retrieveAvailableCar();
        System.out.println("Usando o carro por 1 mês...");
        rentCarService.retrieveCarAlugado(car);
    }
}
