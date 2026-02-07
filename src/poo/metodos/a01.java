package src.poo.metodos;

import src.poo.metodos.classes.Calculadora;


public class a01 {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        int[] vet = {1,2,3,4,5};

        calc.inverterVet(vet);
        for(int n : vet) System.out.println(n + " ");
    }
}
