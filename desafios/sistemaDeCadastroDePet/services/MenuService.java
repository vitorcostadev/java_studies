package desafios.sistemaDeCadastroDePet.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import desafios.sistemaDeCadastroDePet.domain.*;

public class MenuService {
    private final String fluxogramaPath;
    private final int start;
    private final int end;

    public MenuService(){
        this.fluxogramaPath = "desafios\\sistemaDeCadastroDePet\\docs\\forms.txt";
        this.start = 0;
        this.end = 7;
    }
    public MenuService(String fluxogramaPath, int start, int end){
        this.fluxogramaPath = fluxogramaPath;
        this.start = start;
        this.end = end;
    }

    public void menu() throws IOException{
        String[] options = {
            "1 : Cadastrar novo pet",
            "2 : Atualizar um pet existente",
            "3 : Deletar um pet cadastrado",
            "4 : Listar todos os pets cadastrados",
            "5 : Listar pets por algum critério (idade, nome, raça)",
            "6 : Sair"
        };

        int choose = 0;
        Scanner scan = new Scanner(System.in);
        PetWriterAndReader pw = new PetWriterAndReader("desafios\\sistemaDeCadastroDePet\\db");

        do{
            for(String option : options){
                System.out.println(option);
            }
            IO.print("Faça sua escolha: ");
            
            if(scan.hasNextInt()){
                choose = scan.nextInt();
                scan.nextLine(); 
            } else {
                System.out.println("Entrada inválida. Digite um número.");
                scan.nextLine(); 
                continue;
            }

            switch(choose){
                case 1:
                    addNewPetFromCLI(scan);
                    break;
                case 2:
                    attAInsertedPet(scan);
                    break;
                case 3:
                    System.out.println("Digite o nome e sobrenome do pet (eg. Nooby, Pendragon): ");
                    String[] names = scan.nextLine().split(",");
                    if(names.length < 2){
                        System.out.println("O nome digitado é inválido, tente novamente.");
                        break;
                    }
                    try {
                        pw.deletePet(names[0].trim(), names[1].trim());
                        System.out.println("O pet foi deletado com sucesso!");
                    } catch (IOException e) {
                        System.out.println("Erro ao deletar o pet: "+e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Todos os pets cadastrados: ");
                    List<Pets> pets = pw.getAllPets();

                    for(Pets pet : pets){
                        System.out.println(pet.getName()+" "+pet.getSubname());
                    }
                    break;
                case 5:
                    IO.println("Digite quais critérios deseja usar, segue a lista dos possiveis: ");
                    IO.println("[1] : Nome ou sobrenome");
                    IO.println("[2] : Idade");
                    IO.println("[3] : Genêro");
                    IO.println("[4] : Peso");
                    IO.println("[5] : Raça");
                    IO.println("[6] : Endereço");
                    IO.println("Digite o número do critério separando-os por vírgula (max. 2 por busca) : ");
                    String[] userOption = scan.nextLine().trim().split(",");
                    
                    if(userOption.length == 0 || userOption.length > 2){
                        System.out.println("Escolha os critérios novamente, você digitou errado.");
                    }else{
                        if(userOption.length == 1 && Regex.isValidAgeOrSize(userOption[0])){
                            int option = Integer.parseInt(userOption[0]);
                            
                            switch (option){
                                
                                case 1 -> {
                                    System.out.print("Digite o nome ou sobrenome do pet: ");
                                    String name = scan.nextLine();
                                    
                                    if(name != null && Regex.isValidNameAndSubName(name)){
                                        List<Pets> petsFounded = SearchCrit.NAME.findPet(pw.getAllPets(), name);
                                        
                                        if(petsFounded != null){
                                            for(int i = 0; i<petsFounded.size(); i++){
                                                Pets pets1 = petsFounded.get(i);

                                                System.out.println((i+1) +
                                                        ". "+
                                                        pets1.getName()+
                                                        " "+
                                                        pets1.getSubname()+
                                                        " - "+
                                                        pets1.getGenrePet().getAttrName()+
                                                        " - "+
                                                        pets1.getAddressWhoFoundPet().getRoadOfHome()+
                                                        ", "+
                                                        pets1.getAddressWhoFoundPet().getNumberOfHome()+
                                                        " - "+
                                                        pets1.getAddressWhoFoundPet().getCityOfHome()+
                                                        " - "+
                                                        pets1.getAge()+
                                                                (pets1.getAge()>1 ? "anos" : "ano")+
                                                        " - "+
                                                        pets1.getSize()+"kg"+
                                                        " - "+
                                                        pets1.getSpecie()
                                                        );
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }while(choose != 6);
        
        scan.close();
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

    public void addNewPetFromCLI(Scanner scanner) throws IOException{
        String firstName = null, lastName = null, specie=null;
        TypePet tp = null;
        GenrePet gp = null;
        AddressWhoFoundPet address = null;
        Double age = null, size=null;

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
                
                case 2:
                    System.out.println("\nEscolha o genero do pet: ");
                    System.out.println("1 : Masculino");
                    System.out.println("2 : Feminino");
                    
                    String esc = scanner.nextLine();
                    int cho = Integer.parseInt(esc);

                    switch(cho){
                        case 1:
                            gp = GenrePet.MALE;
                            break;
                        case 2:
                            gp = GenrePet.FEMALE;
                            break;
                        default:
                            System.out.println("Opção inválida");
                            i--;
                            continue;
                    }
                    break;
                
                case 3:
                    String addInput = scanner.nextLine().trim();
                    String[] add = addInput.split(",");
                    
                    if(add.length < 3){
                        System.out.println("Endereço inválido. Forneça no formato: bairro, cidade, rua");
                        i--;
                        continue;
                    }
                    
                    address = new AddressWhoFoundPet(add[1].trim(), add[2].trim(), add[0].trim());
                    break;
                case 4:
                    String ageStr = scanner.nextLine().trim();
                    if(ageStr.contains(",")){
                        ageStr = ageStr.replace(",",".");
                    }

                    if(!Regex.isValidAgeOrSize(ageStr)){
                        System.out.println("A idade fornecida é inválida.");
                        i--;
                        continue;
                    }

                    age = Double.parseDouble(ageStr);
                    break;
                case 5:
                    String sizeStr = scanner.nextLine().trim();
                    if(sizeStr.contains(",")){
                        sizeStr = sizeStr.replace(",",".");
                    }

                    if(!Regex.isValidAgeOrSize(sizeStr)){
                        System.out.println("O peso fornecido é inválido.");
                        i--;
                        continue;
                    }

                    size = Double.parseDouble(sizeStr);
                    break;
                case 6:
                    String specieStr = scanner.nextLine().trim();
                    if(!Regex.isValidNameAndSubName(specieStr)){
                        System.out.println("A espécie digitada é inválida.");
                        i--;
                    }else{
                        specie = specieStr;
                    }
                        
                    break;
                default:
                    break;
            }
        }
        
        Pets pet = new Pets(firstName, lastName, tp, gp, address, age, size, specie, null);
        PetWriterAndReader pw = new PetWriterAndReader("desafios\\sistemaDeCadastroDePet\\db");
        pw.addNewPet(pet);

        System.out.println("O pet '"+firstName+" "+lastName+"' foi adicionado com sucesso!");
    }

    public void attAInsertedPet(Scanner scan){
        System.out.print("\nDigite o nome e sobrenome do pet (eg. Nooby, Pendragon): ");

            String[] names = scan.nextLine().split(",");
            if(names.length < 2){
                System.out.println("O nome digitado é inválido, tente novamente.");
                return;
            }

            PetWriterAndReader pw = new PetWriterAndReader("desafios\\sistemaDeCadastroDePet\\db");
            try {
                Pets pet = pw.findPetByName(names[0].trim(), names[1].trim());
                if(pet == null){
                    System.out.println("Pet não encontrado.");
                    return;
                }

                String[] petAttrs = {
                    "Nome",
                    "Sobrenome",
                    "Tipo do pet",
                    "Genero do pet",
                    "Endereço onde o pet foi encontrado",
                    "Idade do pet",
                    "Tamanho do pet",
                    "Espécie do pet"
                };

                for (int i = 0; i < petAttrs.length; i++) {
                    System.out.println((i+1)+" : "+petAttrs[i]);
                }

                IO.print("Faça sua escolha: ");
                int choose = scan.nextInt();
                scan.nextLine(); 

                if(choose >= 1 && choose <= 8){
                    switch(choose){
                        case 1:
                            IO.print("Digite o novo nome do pet "+pet.getName()+": ");
                            String newName = scan.nextLine().trim();

                            if(!Regex.isValidNameAndSubName(newName)){
                                System.out.println("O nome digitado é inválido, tente novamente.");
                            }else{
                                pet.setName(newName);
                                System.out.println("O nome do pet foi alterado para: "+newName);
                            }
                            break;
                        case 2:
                            IO.print("Digite o novo sobrenome do pet "+pet.getSubname()+": ");
                            String newSubName = scan.nextLine().trim();

                            if(!Regex.isValidNameAndSubName(newSubName)){
                                System.out.println("O sobrenome digitado é inválido, tente novamente.");
                            }else{
                                pet.setSubname(newSubName);
                                System.out.println("O sobrenome do pet foi alterado para: "+newSubName);
                            }
                            break;
                        case 3:
                            TypePet newTp = null;
                            System.out.println("\nEscolha o tipo do pet: ");
                            System.out.println("1 : Cachorro");
                            System.out.println("2 : Gato");
                            
                            String esc = scan.nextLine();
                            int cho = Integer.parseInt(esc);

                            switch(cho){
                                case 1:
                                    newTp = TypePet.DOG;
                                    break;
                                case 2:
                                    newTp = TypePet.CAT;
                                    break;
                                default:
                                    System.out.println("Opção inválida");
                                    break;
                            }
                            if(newTp != null){
                                pet.setTypePet(newTp);
                                System.out.println("O tipo do pet foi alterado para: "+newTp.getAttrName());
                            }
                            break;
                        case 4:
                            GenrePet newGp = null;
                            System.out.println("\nEscolha o genero do pet: ");
                            System.out.println("1 : Masculino");
                            System.out.println("2 : Feminino");
                            
                            String esc2 = scan.nextLine();
                            int cho2 = Integer.parseInt(esc2);

                            switch(cho2){
                                case 1:
                                    newGp = GenrePet.MALE;
                                    break;
                                case 2:
                                    newGp = GenrePet.FEMALE;
                                    break;
                                default:
                                    System.out.println("Opção inválida");
                                    break;
                            }
                            if(newGp != null){
                                pet.setGenrePet(newGp);
                                System.out.println("O genero do pet foi alterado para: "+newGp.getAttrName());
                            }
                            break;
                        case 5:
                            System.out.println("Digite o novo endereço do pet (bairro, cidade, rua): ");
                            String addInp = scan.nextLine().trim();
                            String[] add = addInp.split(",");
                            
                            if(add.length < 3){
                                System.out.println("Endereço inválido. Forneça no formato: bairro, cidade, rua");
                            }else{
                                AddressWhoFoundPet newAddress = new AddressWhoFoundPet(add[1].trim(), add[2].trim(), add[0].trim());
                                pet.setAddressWhoFoundPet(newAddress);
                                System.out.println("O endereço do pet foi alterado para: "+newAddress.getRoadOfHome()+", "+newAddress.getNumberOfHome()+", "+newAddress.getCityOfHome());
                            }
                            break;
                        
                        case 6:
                            System.out.println("Digite a nova idade do pet: ");
                            String ageStr = scan.nextLine().trim();
                            if(ageStr.contains(",")){
                                ageStr = ageStr.replace(",",".");
                            }

                            if(!Regex.isValidAgeOrSize(ageStr)){
                                System.out.println("A idade fornecida é inválida.");
                            }else{
                                Double newAge = Double.parseDouble(ageStr);
                                pet.setAge(newAge);
                                System.out.println("A idade do pet foi alterada para: "+newAge);
                            }
                            break;
                        case 7:
                            System.out.println("Digite o novo peso do pet: ");
                            String sizeStr = scan.nextLine().trim();
                            if(sizeStr.contains(",")){
                                sizeStr = sizeStr.replace(",",".");
                            }

                            if(!Regex.isValidAgeOrSize(sizeStr)){
                                System.out.println("O peso fornecido é inválido.");
                            }else{
                                Double newSize = Double.parseDouble(sizeStr);
                                pet.setSize(newSize);
                                System.out.println("O peso do pet foi alterado para: "+newSize);
                            }
                            break;
                        case 8:
                            System.out.println("Digite a nova espécie do pet: ");
                            String newSpecie = scan.nextLine().trim();

                            if(!Regex.isValidNameAndSubName(newSpecie)){
                                System.out.println("A espécie digitada é inválida.");
                            }else{
                                pet.setSpecie(newSpecie);
                                System.out.println("A espécie do pet foi alterada para: "+newSpecie);
                            }
                            break;
                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                    pw.attPet(pet, names[0].trim(), names[1].trim());
                    System.out.println("O pet foi atualizado com sucesso!");
                }else{
                    System.out.println("Opção inválida. Escolha entre 1 e 8.");
                }
            } catch (IOException e) {
                System.out.println("Erro ao tentar procurar o pet: "+e.getMessage());
            }
    }
}
