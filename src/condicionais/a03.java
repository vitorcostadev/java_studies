package src.condicionais;

public class a03 {
    public static void main(String[] args) {
        // IF Ternário
        double salario = 3000;
        String message = "Doação será realizada.";
        String notMessage = "Não vou doar nada.";

        String result = salario > 5000 ? message : notMessage;
        // <condition> ? <true> : <false>

        System.out.println(result);

    
    }
}
