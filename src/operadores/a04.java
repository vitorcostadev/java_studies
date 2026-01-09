package src.operadores;

public class a04 {
    public static void main(String[] args) {
        // Operador logico OR
        double contaCorrente = 200;
        double contaPoupanca = 10000;

        float valorPS5 = 3600;

        if(contaCorrente > valorPS5 || contaPoupanca > valorPS5){
            System.out.println("O PS5 é comprável.");
        }else System.out.println("O PS5 não é comprável.");
    }
}
