package src.poo.metodos.classes;

public class Calculadora {
    
    public int somar(int a, int b){
        return a + b;
    }

    public int subtrair(int a, int b){
        return a-b;
    }

    public double dividir(int a, int b){
        return b > 0 ? a/b : 0;
    }

    public int multiplicar(int a, int b){
        return a * b;
    }

    public int restoDivisao(int a, int b){
        return a % b;
    }

    public long fatorial(int a){
        if(a < 1) return 1;
        else{
            return a * fatorial(a-1);
        }
    }

    public void inverterVet(int[] vet){
        for(int i = 0; i<vet.length/2; i++){
            int lastIndex = vet.length - i - 1;
            
            int temp = vet[lastIndex];
            vet[lastIndex] = vet[i];
            vet[i] = temp;
        }
    }

    public int sumArray(int[] arr){
        int soma = 0;
        for(int temp : arr) soma += temp;

        return soma;
    }

    public int sumArrayVarArgs(int... nums){
        int soma=0;
        for(int temp : nums) soma += temp;

        return soma;
    }
}
