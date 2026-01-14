package src.poo.polimorfismo.tests;

import src.poo.polimorfismo.repositorio.Repositorio;
import src.poo.polimorfismo.service.RepositorioDatabase;
import src.poo.polimorfismo.service.RepositorioMemory;

public class RepositorioTest {
    static void main() {
        Repositorio repositorio = new RepositorioMemory();
        repositorio.save();
    }
}
