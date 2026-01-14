package src.poo.polimorfismo.tests;

import src.poo.polimorfismo.domain.Computador;
import src.poo.polimorfismo.domain.Produto;
import src.poo.polimorfismo.service.CalculadoraImposto;

public class ProdutoTest02 {
    static void main(String[] args) {
        Produto produto = new Computador("Ryzen 9", 5000);
        CalculadoraImposto.calcularImposto(produto);
    }
}
