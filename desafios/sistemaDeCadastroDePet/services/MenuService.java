package desafios.sistemaDeCadastroDePet.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

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

    private static List<Pets> menuSwitchForPet(int option, Scanner scan, PetWriterAndReader pw){
        switch (option){
            case 1: {
                System.out.print("Digite o nome ou sobrenome do pet: ");
                String name = scan.nextLine().trim().toLowerCase();

                if(Regex.isValidNameAndSubName(name)){
                   return pw.find(pet -> pet.getName()
                           .equalsIgnoreCase(name) || pet
                           .getSubname()
                           .equalsIgnoreCase(name),
                           pw.getAllPets());
                }
                break;
            }
            case 2: {
                System.out.print("Digite a idade do pet: ");
                String age = scan.nextLine().trim();

                if(Regex.isValidAgeOrSize(age)){
                    return pw.find(a -> a
                                    .getAge()
                                    .equals(Double.parseDouble(age)),
                            pw.getAllPets());
                }
                break;
            }
            case 3: {
                System.out.print("Digite o gênero do pet: ");
                String gender = scan.nextLine().trim();

                if(Regex.isValidGender(gender)){
                    return pw.find(g -> g
                                    .getGenrePet()
                                    .getAttrName()
                                    .equalsIgnoreCase(gender),
                            pw.getAllPets());
                }
                break;
            }
            case 4: {
                System.out.print("Digite o peso do pet: ");
                String size = scan.nextLine().trim();

                if(Regex.isValidAgeOrSize(size)){
                    return pw.find(s -> s
                                    .getSize()
                                    .equals(Double.parseDouble(size)),
                            pw.getAllPets());
                    
                }
                break;
            }
            case 5: {
                System.out.println("Digite a espécie do pet:");
                String specie = scan.nextLine().trim();
                return pw.find(s -> s
                                .getSpecie()
                                .equalsIgnoreCase(specie),
                        pw.getAllPets());
                
            }
            case 6: {
                System.out.println("Digite o endereço do pet (bairro, cidade, rua): ");
                String[] address = scan.nextLine().trim().split(",");

                if(address.length < 3){
                    System.out.println("Formato de endereço inválido. Forneça no formato: bairro, cidade, rua");
                }else{
                    AddressWhoFoundPet addressWhoFoundPet = new AddressWhoFoundPet(address[1].trim(), address[2].trim(), address[0].trim());
                    return pw.find(a -> a
                                    .getAddressWhoFoundPet()
                                    .equals(addressWhoFoundPet),
                            pw.getAllPets());
                    
                }
                break;
            }
            default:
                return null;
        }
        return null;
    }

    private static void petInfo(List<Pets> pets){
        int i = 0;
        for(Pets pet : pets){
            System.out.println((i+1) +
                    ". "+
                    pet.getName()+
                    " "+
                    pet.getSubname()+
                    " - "+
                    pet.getGenrePet().getAttrName()+
                    " - "+
                    pet.getAddressWhoFoundPet().getRoadOfHome()+
                    ", "+
                    pet.getAddressWhoFoundPet().getNumberOfHome()+
                    " - "+
                    pet.getAddressWhoFoundPet().getCityOfHome()+
                    " - "+
                    pet.getAge()+
                            (pet.getAge()>1 ? "anos" : "ano")+
                    " - "+
                    pet.getSize()+"kg"+
                    " - "+
                    pet.getSpecie()
                    );
            i++;
        }
    }

    private static Object coletarValorCriterio(int criterio, Scanner scan){
        switch(criterio){
            case 1: {
                System.out.print("Digite o nome ou sobrenome do pet: ");
                String name = scan.nextLine().trim().toLowerCase();
                return Regex.isValidNameAndSubName(name) ? name : null;
            }
            case 2: {
                System.out.print("Digite a idade do pet: ");
                String age = scan.nextLine().trim().replace(",", ".");
                return Regex.isValidAgeOrSize(age) ? Double.parseDouble(age) : null;
            }
            case 3: {
                System.out.print("Digite o gênero do pet (masculino/feminino): ");
                String gender = scan.nextLine().trim().toLowerCase();
                if(gender.equals("masculino") || gender.equals("m")){
                    return GenrePet.MALE;
                }else if(gender.equals("feminino") || gender.equals("f")){
                    return GenrePet.FEMALE;
                }
                return null;
            }
            case 4: {
                System.out.print("Digite o peso do pet: ");
                String size = scan.nextLine().trim().replace(",", ".");
                return Regex.isValidAgeOrSize(size) ? Double.parseDouble(size) : null;
            }
            case 5: {
                System.out.print("Digite a espécie do pet: ");
                return scan.nextLine().trim();
            }
            case 6: {
                System.out.print("Digite o endereço (bairro, cidade, rua): ");
                String[] address = scan.nextLine().trim().split(",");
                if(address.length >= 3){
                    return new AddressWhoFoundPet(address[1].trim(), address[2].trim(), address[0].trim());
                }
                System.out.println("Formato de endereço inválido.");
                return null;
            }
            default:
                return null;
        }
    }

    private Predicate<Pets> predicatePorCriterio(Object valorCriterio) {
        return pets -> {
            if (valorCriterio instanceof String) {
                return pets.getName().equalsIgnoreCase((String) valorCriterio)
                        || pets.getSubname().equalsIgnoreCase((String) valorCriterio)
                        || pets.getSpecie().equalsIgnoreCase((String) valorCriterio);

            } else if (valorCriterio instanceof TypePet) {
                return pets.getGenrePet().getAttrName()
                        .equalsIgnoreCase(((TypePet) valorCriterio).getAttrName());

            } else if (valorCriterio instanceof GenrePet) {
                return pets.getGenrePet().getAttrName()
                        .equalsIgnoreCase(((GenrePet)valorCriterio).getAttrName());

            } else if (valorCriterio instanceof AddressWhoFoundPet) {
                return pets.getAddressWhoFoundPet().equals(valorCriterio);
            }else if(valorCriterio instanceof Double){
                return pets.getAge().equals(valorCriterio) || pets
                        .getSize().equals(valorCriterio);
            }

            return false;
        };
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
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("-------------------------------------------------------------------");
            for(String option : options){
                System.out.println(option);
            }
            System.out.println("-------------------------------------------------------------------");
            System.out.print("Faça sua escolha: ");
            
            if(scan.hasNextInt()){
                choose = scan.nextInt();
                scan.nextLine(); 
            } else {
                System.out.println("Entrada inválida. Digite um número.");
                scan.nextLine(); 
                continue;
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();
            switch(choose){
                case 1:
                    System.out.println("-------------------------------------------------------------------");
                    addNewPetFromCLI(scan);
                    System.out.println("-------------------------------------------------------------------");
                    break;
                case 2:
                    System.out.println("-------------------------------------------------------------------");
                    attAInsertedPet(scan);
                    System.out.println("-------------------------------------------------------------------");
                    break;
                case 3:
                    System.out.println("-------------------------------------------------------------------");
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
                    System.out.println("-------------------------------------------------------------------");
                    break;
                case 4:
                    System.out.println("Todos os pets cadastrados: ");
                    System.out.println("-------------------------------------------------------------------");
                    List<Pets> pets = pw.getAllPets();

                    for(Pets pet : pets){
                        System.out.println(pet.getName()+" "+pet.getSubname());
                    }
                    System.out.println("-------------------------------------------------------------------");
                    break;
                case 5:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Digite quais critérios deseja usar, segue a lista dos possiveis: ");
                    System.out.println("[1] : Nome ou sobrenome");
                    System.out.println("[2] : Idade");
                    System.out.println("[3] : Genêro");
                    System.out.println("[4] : Peso");
                    System.out.println("[5] : Raça");
                    System.out.println("[6] : Endereço");
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Digite o número do critério separando-os por vírgula (max. 2 por busca) : ");
                    String[] userOption = scan.nextLine().trim().split(",");
                    
                    if(userOption.length == 0 || userOption.length > 2){
                        System.out.println("Escolha os critérios novamente, você digitou errado.");
                    }else{
                        if(userOption.length == 1 && Regex.isValidAgeOrSize(userOption[0])){
                            int option = Integer.parseInt(userOption[0]);
                            List<Pets> retrievedPets = menuSwitchForPet(option, scan, pw);
                            if(retrievedPets != null){
                                petInfo(retrievedPets);
                            }else{
                                System.out.println("Nenhum pet encontrado com esse critério.");
                            }
                        }else{
                            int optionOne = Integer.parseInt(userOption[0].trim());
                            int optionTwo = Integer.parseInt(userOption[1].trim());

                            if(optionOne != optionTwo && optionOne >= 1 && optionOne <= 6 && optionTwo >= 1 && optionTwo <= 6){
                                Object valorCriterio1 = coletarValorCriterio(optionOne, scan);
                                if(valorCriterio1 == null){
                                    System.out.println("Valor inválido para o primeiro critério.");
                                    break;
                                }

                                Object valorCriterio2 = coletarValorCriterio(optionTwo, scan);
                                if(valorCriterio2 == null){
                                    System.out.println("Valor inválido para o segundo critério.");
                                    break;
                                }
                                List<Pets> primeiraFiltragem = pw.find(predicatePorCriterio(valorCriterio1), pw.getAllPets());
                                List<Pets> resultadoFinal = pw.find(predicatePorCriterio(valorCriterio2),primeiraFiltragem);

                                if(resultadoFinal != null && !resultadoFinal.isEmpty()){
                                    System.out.println("-------------------------------------------------------------------");
                                    petInfo(resultadoFinal);
                                    System.out.println("-------------------------------------------------------------------");
                                }else{
                                    System.out.println("Nenhum pet encontrado com ambos os critérios.");
                                }
                            }else{
                                System.out.println("Opções inválidas ou iguais. Escolha dois critérios diferentes entre 1 e 6.");
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
            scan.nextLine();
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
            System.out.print(getAnswerFromFluxogram(i+1));
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
            String petFirstName = names[0].trim();
            StringBuilder petLastName = new StringBuilder();

            for(int i = 1; i<names.length; i++){
                petLastName.append(names[i].trim()).append(" ");
            }
            Pets pet = pw.find(p -> p.getName().equalsIgnoreCase(petFirstName) && p.getSubname().equalsIgnoreCase(petLastName.toString().trim()));
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
            System.out.println("Escolha o que deseja atualizar: ");
            System.out.println("-------------------------------------------------------------------");
            for (int i = 0; i < petAttrs.length; i++) {
                System.out.println((i+1)+" : "+petAttrs[i]);
            }
            System.out.println("-------------------------------------------------------------------");
            System.out.print("Faça sua escolha: ");
            int choose = scan.nextInt();
            scan.nextLine();

            if(choose >= 1 && choose <= 8){
                switch(choose){
                    case 1:
                        System.out.print("Digite o novo nome do pet "+pet.getName()+": ");
                        String newName = scan.nextLine().trim();

                        if(!Regex.isValidNameAndSubName(newName)){
                            System.out.println("O nome digitado é inválido, tente novamente.");
                        }else{
                            pet.setName(newName);
                            System.out.println("O nome do pet foi alterado para: "+newName);
                        }
                        break;
                    case 2:
                        System.out.print("Digite o novo sobrenome do pet "+pet.getSubname()+": ");
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
                            break;
                        }else{
                            pet.setSpecie(newSpecie);
                            System.out.println("A espécie do pet foi alterada para: "+newSpecie);
                        }
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
                pw.updatePet(pet, names[0].trim(), names[1].trim());
                System.out.println("O pet foi atualizado com sucesso!");
            }else{
                System.out.println("Opção inválida. Escolha entre 1 e 8.");
            }
    }
}
