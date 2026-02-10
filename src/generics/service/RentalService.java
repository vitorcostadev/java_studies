package src.generics.service;

import src.generics.domain.Barco;
import src.generics.domain.Carro;
import src.generics.domain.Name;

import java.util.List;

public class RentalService<T extends Name>{
    private List<T> veiculosDisponiveis;

    public RentalService(List<T> veiculosDisponiveis) {
        this.veiculosDisponiveis = veiculosDisponiveis;
    }

    public void retrieveAvailableCar(){
        T obj = veiculosDisponiveis.remove(0);
        System.out.println("Buscando carros disponiveis");
        System.out.println("Alugando carro: " + obj.getName());
        System.out.println("Carro disponiveis para alugar: ");
        veiculosDisponiveis.forEach(vei -> {
            System.out.println("\t- "+vei.getName());
        });

    }

    public void retrieveCarAlugado(T obj){
        System.out.println("Devolvendo carro: "+obj.getName());
        veiculosDisponiveis.add(obj);
        System.out.println("Carros disponiveis para alugar: ");
        veiculosDisponiveis.forEach(vei -> {
            System.out.println("\t- "+vei.getName());
        });
    }
}
