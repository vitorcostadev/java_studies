package src.condicionais;

public class a01_e_a02 {
    public static void main(String[] args) {
        // Estrutura Condicionais
        int idade = 9;

        if(idade >= 18){
            System.out.println("Maior de idade.");
        }else if(idade < 18 && idade > 10){
            System.out.println("Menor de idade.");
        }else{
            System.out.println("Muito novo!");
        }
    }
}
