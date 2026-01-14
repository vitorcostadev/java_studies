package src.poo.polimorfismo.service;

import src.poo.polimorfismo.repositorio.Repositorio;

public class RepositorioDatabase implements Repositorio {
    @Override
    public void save() {
        System.out.println("Saving in the database...");
    }
}
