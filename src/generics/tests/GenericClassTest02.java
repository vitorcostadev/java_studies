package src.generics.tests;

import src.generics.domain.Barco;
import src.generics.domain.Carro;
import src.generics.service.RentalService;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class GenericClassTest02 {
    public static void main(String[] args) {
        List<Carro> carros = new ArrayList<>(
                List.of(new Carro("BMW"),
                        new Carro("Mercedes"))
        );

        List<Barco> barcos = new ArrayList<>(
                List.of(new Barco("BMW"),
                        new Barco("Koenigsegg"))
        );

        RentalService<Carro> carService = new RentalService<>(carros);
        RentalService<Barco> barcoService = new RentalService<>(barcos);

        Carro car = new Carro("BMW");
        Barco barco = new Barco("Koenigsegg");

        carService.retrieveAvailableCar();
        System.out.println("Usando o carro por 1 mes...");
        carService.retrieveCarAlugado(car);
    }
}
