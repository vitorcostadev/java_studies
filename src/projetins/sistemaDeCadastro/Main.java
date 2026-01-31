package src.projetins.sistemaDeCadastro;

import src.projetins.sistemaDeCadastro.domain.Produto;
import src.projetins.sistemaDeCadastro.domain.Writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite as informações do produto (nome,stock,valor): ");
        String linha = scanner.nextLine();
        String[] linhaSplitted = linha.split(",");

        String prodName=null;
        int valor=0, stock=0;

        if(linhaSplitted.length != 3){
            System.out.println("Formato inválido, tente novamente.");
            return;
        }
        boolean match = linhaSplitted[0].trim().matches("^[a-zA-ZçÇ\\s]+$");
        if(match){
            prodName = linhaSplitted[0].trim();
            IO.print("Product name: "+ prodName+"\n");
        }

        boolean matchStockAndValue = (
                linhaSplitted[1].trim().matches("^[0-9]+$") &&
                        linhaSplitted[2].trim().matches("^[0-9]+$")
        );

        if(matchStockAndValue){
            valor = Integer.parseInt(linhaSplitted[2].trim());
            stock = Integer.parseInt(linhaSplitted[1].trim());

            System.out.println("Stock: "+stock+"\nValor R$: "+valor+"\n");
        }

        if(prodName != null && stock >= 0 && valor > 0) {

            Produto produto = new Produto(prodName, stock, valor);
            File file = new File("C:\\Users\\yori0\\OneDrive\\Documentos\\Cjava\\src\\projetins\\sistemaDeCadastro\\users\\users.txt");

            try {
                if (!file.exists()) {
                    boolean isCreated = file.createNewFile();
                    System.out.println("File created: " + isCreated);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try (FileWriter fw = new FileWriter(file, true)) {
                Writer w = new Writer(fw);
                boolean addSucessfull = w.addProduct(produto);

                System.out.println(!addSucessfull ? "Não foi posssivel escrever no arquivo." : "Arquivo escrito e salvo com sucesso.");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("Algumas das informações está incorreta, repita o processo.");
        }

    }
}
