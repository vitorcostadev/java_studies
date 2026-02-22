package desafios.sistema.services;

import desafios.sistema.domain.Address;
import desafios.sistema.domain.Pets;
import desafios.sistema.domain.enums.Gender;
import desafios.sistema.domain.enums.Type;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

enum Forms{
    ANSWERS(Forms.rootPath+"\\forms\\menu_answers.txt"),
    FORM(Forms.rootPath+"\\forms\\answer.txt"),
    DB(Forms.rootPath+"\\db");

    private final String path;
    private static final String rootPath = "C:\\dev\\Cjava\\desafios\\sistema";

    Forms(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

public class MenuService {
    private Scanner scan;
    
    public MenuService(Scanner scan) {
        if(scan == null){
            throw new IllegalArgumentException("O argumento 'scan' não pode ser nulo.");
        }
        this.scan = scan;
    }

    private static List<String> readFileLines(Reader fileReader){
        List<String> fileLines = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(fileReader)){
            String line;
            while((line = bf.readLine()) != null){
                fileLines.add(line);
            }
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        return fileLines;
    }
    
    public void start() throws FileNotFoundException {
        Function<FileReader, List<String>> readFileLines = MenuService::readFileLines;
        int option;

        do{
            readFileLines.apply(new FileReader(Forms.ANSWERS.getPath())).forEach(System.out::println);
            System.out.print("Faça sua escolha: ");
            option=this.scan.nextInt();
            scan.nextLine();
            switch (option){
                case 1:
                    Object obj = getDataFromConsole(option);

                    if(obj instanceof Pets){
                        try(FileWriter fw = new FileWriter(Forms.DB.getPath())){
                            PetWriter pw = new PetWriter(fw);
                            pw.addPetToFile((Pets) obj);
                        }catch(IOException e) {
                            System.out.println("Ocorreu um erro na tentativa de salvar o pet: ");
                            System.out.println(e.getMessage());
                            break;
                        }
                    }
                    break;
                case 2:
                    break;
                default:
                    break;
            }
        }while(option != 6);
        
    }

    public <T> T validate(
            String msg,
            Predicate<T> predicate,
            Function<String, T> parser) {

        T value;

        while (true) {
            System.out.print(msg);

            try {
                value = parser.apply(this.scan.nextLine());

                if (predicate.test(value)) {
                    return value;
                } else {
                    System.out.println("Invalid parameter provided");
                }

            } catch (Exception e) {
                System.out.println("Invalid input format");
            }
        }
    }

    public Object getDataFromConsole(int option) throws IllegalStateException {
        switch (option){
            case 1:
                // Name
                String name = validate("Digite o nome do pet: ",
                        StringParser::isString,
                        s -> s);
                // Type
                Type typePet = validate("Digite o tipo do pet: ",
                        s -> StringParser.isString(s.name())
                        ,s->s.equals("Gato") ? Type.CAT : Type.DOG);
                // Gender
                Gender gender = validate("Digite o genero do pet: ",
                        t -> StringParser.isString(t.name()),
                        s -> s.equalsIgnoreCase("Masculino") ? Gender.MALE : Gender.FEMALE);

                // Address
                String city, road, number;
                System.out.println("-- Endereço onde o pet foi encontrado (fonerça): ");
                do{
                    System.out.print("Digite o nome da rua: ");
                    city=this.scan.nextLine().trim();
                    System.out.print("Digite o nome da cidade: ");
                    road=this.scan.nextLine().trim();
                    System.out.print("Digite o número da casa: ");
                    number=this.scan.nextLine().trim();
                }while(
                        (city.isEmpty() || road.isEmpty() || number.isEmpty()) ||
                        !(StringParser.isString(city) ||
                                StringParser.isString(road) ||
                                StringParser.isNumber(number))
                );

                Address address = new Address(Integer.parseInt(number), city, road);
                Integer age = validate("Digite a idade do pet: ",
                        t -> StringParser.isNumber(String.valueOf(t))
                        , Integer::parseInt);
                Double weight = validate("Digite o peso do pet: ",
                        t -> StringParser.isNumber(String.valueOf(t)),
                        Double::parseDouble);
                String specie = validate("Digite o nome da espécie do pet: ",
                        StringParser::isString,
                        s -> s);

                return new Pets(name, typePet, gender, address, age, weight, specie);

            case 2:
                break;
            default:
                throw new IllegalStateException();
        }
        return null;
    }
}
