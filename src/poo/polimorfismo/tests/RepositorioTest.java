package src.poo.polimorfismo.tests;

import src.poo.polimorfismo.repositorio.Repositorio;
import src.poo.polimorfismo.service.RepositorioDatabase;
import src.poo.polimorfismo.service.RepositorioMemory;

public class RepositorioTest {
    public static void main(String[] args) {
        Repositorio repositorio = new RepositorioMemory();
        repositorio.save();
    }
}
