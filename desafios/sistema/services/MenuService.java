package desafios.sistema.services;

import desafios.sistema.domain.Pets;
import desafios.sistema.domain.enums.Gender;
import desafios.sistema.domain.enums.Type;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

enum Forms{
    ANSWERS("C:\\Users\\yori0\\OneDrive\\Documentos\\Cjava\\desafios\\sistema\\forms\\menu_answers.txt"),
    FORM("C:\\Users\\yori0\\OneDrive\\Documentos\\Cjava\\desafios\\sistema\\forms\\answer.txt");

    private final String path;

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

    private static List<String> readFileLines(FileReader fileReader){
        List<String> fileLines = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(fileReader)){
            String line;
            while((line = bf.readLine()) != null){
                fileLines.add(line.trim());
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
        }while(option != 6);
        
    }

    private void ExecuteSwtichByOption(int option){
        // TODO
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
                return new Pets(typePet, gender);
            case 2:
                break;
            default:
                throw new IllegalStateException();
        }
        return null;
    }
}
