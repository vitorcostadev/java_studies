package src.exercicios.logictraining.Exercise12;
import java.util.Scanner;


public class Client {
    static void main() {
        int opcao=0;
        Scanner scan = new Scanner(System.in);
        double valorProduto=0;

        do{
            System.out.println("Digite o valor do produto: ");
            valorProduto = scan.nextDouble();
        }while(valorProduto < 0);

        Produto produto = new Produto();

        do{
            System.out.println("ESCOLHA A FORMA DE PAGAMENTO");
            System.out.println("----------------------------");
            System.out.println("[1] : A vista no PIX/DINHEIRO");
            System.out.println("[2] : A vista no CARTÃO DE CRÉDITO");
            System.out.println("[3] : Parcelado no debito");
            System.out.println("[4] : Sair");
            System.out.println("----------------------------");
            opcao = scan.nextInt();
            produto.setValor(valorProduto);

            switch(opcao){
                case 1:
                    System.out.println("----------------------------");
                    System.out.println("A vista no dinheiro e pix, o valor fica: "+Payment.MONEY.calcularImposto(produto));
                    System.out.println("15% de desconto ao valor anterior ("+valorProduto+")!");
                    System.out.println("----------------------------");
                    break;
                case 2:
                    System.out.println("----------------------------");
                    System.out.println("A vista no cartão de crédito, o valor fica: "+Payment.CREDIT.calcularImposto(produto));
                    System.out.println("10% de desconto ao valor anterior ("+valorProduto+")!");
                    System.out.println("----------------------------");
                    break;
                case 3:
                    int parcelas=0;
                    do{
                        System.out.println("Digite em quantas vezes deseja parcelar: ");
                        parcelas = scan.nextInt();
                    }while(parcelas < 0);

                    System.out.println("----------------------------");
                    produto.setParcelas(parcelas);
                    System.out.println("Parcelando em "+parcelas+"x, o valor fica: "+parcelas+"x de "+Payment.DEBIT.calcularImposto(produto));
                    if(parcelas <= 2) System.out.println("Como foi em até 2x, o valor não sofreu alteração.");
                    else System.out.println("Como você optou por parcelar igual ou maior que 3x, então sofreu uma adição de 10% de juros.");
                    System.out.println("----------------------------");
                    break;

                case 4:
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while(opcao != 4);

        scan.close();
    }
}
