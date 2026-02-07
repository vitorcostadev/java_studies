package src.generics.service;

import src.generics.domain.Carro;

import java.util.ArrayList;
import java.util.List;

public class RentCarService {
    private List<Carro> carrosAlloweds = new ArrayList<>(
            List.of(new Carro("BMW"),
                    new Carro("Mercedes"))
    );

    public Carro retrieveAvailableCar(){
        System.out.println("Buscando carros disponiveis");
        Carro carro = carrosAlloweds.remove(0);
        System.out.println("Alugando carro: "+carro.getName());
        System.out.println("Carro disponiveis para alugar: ");
        System.out.println(carrosAlloweds);
        return carro;
    }

    public void retrieveCarAlugado(Carro car){
        System.out.println("Devolvendo carro: "+car.getName());
        carrosAlloweds.add(car);
        System.out.println("Carros disponiveis para alugar: ");
        System.out.println(carrosAlloweds);
    }
}
