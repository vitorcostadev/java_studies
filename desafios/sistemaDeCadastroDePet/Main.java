package desafios.sistemaDeCadastroDePet;

import java.util.List;

import desafios.sistemaDeCadastroDePet.domain.Pets;
import desafios.sistemaDeCadastroDePet.services.PetWriterAndReader;

public class Main {
    public static void main(String[] args) {
        PetWriterAndReader pw = new PetWriterAndReader("desafios\\sistemaDeCadastroDePet\\db");
        List<Pets> pets = pw.getAllPets();

        for(Pets pet : pets){
            System.out.println(pet.getName()+" "+pet.getSubname());
        }
    }
}
