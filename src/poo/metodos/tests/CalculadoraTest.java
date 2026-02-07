package src.poo.metodos.tests;

import src.poo.metodos.classes.Calculadora;

public class CalculadoraTest {
    public static void main(String[] args) {
        // Varargs
        Calculadora calc = new Calculadora();

        System.out.println(calc.sumArrayVarArgs(1,2,3,4,5,6,7,8,9));
    }
    
}
