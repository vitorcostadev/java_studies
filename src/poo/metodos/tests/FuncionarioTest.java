package src.poo.metodos.tests;

import java.util.Scanner;

import src.poo.metodos.classes.Funcionario;


public class FuncionarioTest {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        Scanner scan = new Scanner(System.in);

        do{
            IO.print("Digite o nome do funcionario: "); funcionario.nome = scan.next().strip();

            if(!funcionario.nome.isEmpty()){
                IO.print("Digite a idade do funcionario: "); funcionario.idade = scan.nextInt();

                if(!(funcionario.idade < 0)){
                    for(int i = 0; i<3; i++){
                        IO.print("Digite o "+i+1+" salario do funcionario: "); funcionario.salario[i] = scan.nextInt();
                    }

                    if(funcionario.salario.length == 3){
                        System.out.println("Imprimindo informações...");
                        funcionario.imprimirInfo();
                    }else System.out.println("Deve ter pelo menos três salários no array.");

                }else System.out.println("A idade do funcionário não pode ser negativa.");

            }else System.out.println("O nome do funcionário não pode ficar vazio.");

            IO.print("Você deseja continuar? [S/N] ::");
            if(scan.next().strip().toLowerCase().contentEquals("s")){
                continue;
            }else break;
            
        }while(true);

        scan.close();
    }
}
