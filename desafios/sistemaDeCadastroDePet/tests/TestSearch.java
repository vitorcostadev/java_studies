package desafios.sistemaDeCadastroDePet.tests;

import desafios.sistemaDeCadastroDePet.domain.Pets;
import desafios.sistemaDeCadastroDePet.domain.SearchCrit;
import desafios.sistemaDeCadastroDePet.services.PetWriterAndReader;

import java.util.List;

public class TestSearch {
    public static void main(String[] args) {
        PetWriterAndReader pw = new PetWriterAndReader("C:\\Users\\yori0\\OneDrive\\Documentos\\Cjava\\desafios\\sistemaDeCadastroDePet\\db");
        List<Pets> petsList = pw.find(name -> name.getSubname().equalsIgnoreCase("Luiza"), pw.getAllPets());

        petsList.forEach(System.out::println);
    }
}
