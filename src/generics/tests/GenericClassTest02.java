package src.generics.tests;

import src.generics.domain.Barco;
import src.generics.service.RentBarcoService;

public class GenericClassTest02 {
    public static void main(String[] args) {
        RentBarcoService rentBarcoService = new RentBarcoService();
        Barco barco = rentBarcoService.retrieveAvailableBarco();
        System.out.println("Usando o barco por 1 mês...");
        rentBarcoService.retrieveBarcoAlugado(barco);

    }
}
