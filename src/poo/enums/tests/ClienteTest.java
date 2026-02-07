package src.poo.enums.tests;

import src.poo.enums.classes.Cliente;
import src.poo.enums.classes.TypeCliente;
import src.poo.enums.classes.typePayment;

public class ClienteTest {
    public static void main(String[] args) {
        Cliente cliente01 = new Cliente("Nooby", TypeCliente.PESSOA_FISICA);
        Cliente cliente02 = new Cliente("Quantum", TypeCliente.PESSOA_JURIDICA);

        System.out.println(cliente01);
        System.out.println(cliente02);

        double desconto = typePayment.CREDIT.calcularDesconto(100);
        System.out.println(desconto);
    }

    
}
