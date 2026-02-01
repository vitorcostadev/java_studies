package desafios.sistemaDeCadastroDePet.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import desafios.sistemaDeCadastroDePet.domain.Regex;
import desafios.sistemaDeCadastroDePet.domain.TypePet;

public class MenuService {
    private String fluxogramaPath;
    private int start, end;

    public MenuService(){
        this.fluxogramaPath = "desafios\\sistemaDeCadastroDePet\\docs\\forms.txt";
        this.start = 0;
        this.end = 6;
    }
    public MenuService(String fluxogramaPath, int start, int end){
        this.fluxogramaPath = fluxogramaPath;
        this.start = start;
        this.end = end;
    }

    private String getAnswerFromFluxogram(int answerId) throws IOException{
        try(FileReader fr = new FileReader(this.fluxogramaPath);
            BufferedReader br = new BufferedReader(fr)){
                String linha;
                while((linha = br.readLine()) != null){
                    int id = Integer.parseInt(linha.split(" : ")[0].trim());

                    if(id == answerId){
                        return linha.split(" : ")[1].trim();
                    }
                }
        }
        return null;
    }

    public void startMenu() throws IOException{
        Scanner scanner = new Scanner(System.in);
        String firstName = null, lastName = null;
        TypePet tp = null;

        for(int i = this.start; i < this.end; i++){
            IO.print(getAnswerFromFluxogram(i+1));
            switch(i){
                case 0:
                    String input = scanner.nextLine(); 
                    String[] parts = input.split(",");
                    
                    if(parts.length < 2 ||
                       !Regex.isValidNameAndSubName(parts[0].trim()) ||
                       !Regex.isValidNameAndSubName(parts[1].trim())){
                        System.out.println("O nome digitado é inválido, tente novamente.");
                        i--; 
                        continue;
                    }
                    
                    firstName = parts[0].trim();
                    lastName = parts[1].trim();
                    break;
                    
                case 1:
                    System.out.println("\nEscolha o tipo do pet: ");
                    System.out.println("1 : Gato");
                    System.out.println("2 : Cachorro");
                    
                    String escolha = scanner.nextLine();
                    int choose = Integer.parseInt(escolha);

                    switch(choose){
                        case 1:
                            tp = TypePet.CAT;
                            break;
                        case 2:
                            tp = TypePet.DOG;
                            break;
                        default:
                            System.out.println("Opção inválida");
                            i--;
                            continue;
                    }
                    break;
                
                default:
                    break;
            }
        }
        scanner.close();
    }
    void main() {
        try {
            System.out.println(getAnswerFromFluxogram(7));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
