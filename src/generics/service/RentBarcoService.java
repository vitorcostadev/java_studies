package src.generics.service;

import src.generics.domain.Barco;

import java.util.ArrayList;
import java.util.List;

public class RentBarcoService {
    private List<Barco> barcosAlloweds = new ArrayList<>(
            List.of(new Barco("ZKKS"),
                    new Barco("Luau"))
    );

    public Barco retrieveAvailableBarco(){
        System.out.println("Buscando barcoros disponiveis");
        Barco barco = barcosAlloweds.remove(0);
        System.out.println("Alugando barco: "+barco.getName());
        System.out.println("Barco disponiveis para alugar: ");
        System.out.println(barcosAlloweds);
        return barco;
    }

    public void retrieveBarcoAlugado(Barco barco){
        System.out.println("Devolvendo barco: "+barco.getName());
        barcosAlloweds.add(barco);
        System.out.println("Barcos disponiveis para alugar: ");
        System.out.println(barcosAlloweds);
    }
}
