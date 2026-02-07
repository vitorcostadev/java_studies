package src.exercicios.logictraining.imc.main;

import src.exercicios.logictraining.imc.domain.Imc;
import src.exercicios.logictraining.imc.domain.Pessoa;

public class Main {
    public static void main(String[] args) {
        Pessoa people = new Pessoa("Vitor Costa", 56);

        System.out.println(people.calcularImc().toString());
    }
}
