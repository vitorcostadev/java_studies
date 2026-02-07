package src.poo.polimorfismo.service;

import src.poo.polimorfismo.domain.Computador;
import src.poo.polimorfismo.domain.Produto;
import src.poo.polimorfismo.domain.Tomate;

public class CalculadoraImposto {

    public static void calcularImposto(Produto produto){
        System.out.println("Relatorio de imposto: ");
        double imposto = produto.calcularImposto();

        System.out.println("Produto: "
                +produto.getName()+
                "\nValor: "+produto.getValor()+
                "\nImposto: "+imposto
        );
        if(produto instanceof Tomate){
            System.out.println("\nData de validade: "+((Tomate) produto).getDataDeValidade());
        }
    }
}
