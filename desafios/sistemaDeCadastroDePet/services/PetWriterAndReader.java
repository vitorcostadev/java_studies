package desafios.sistemaDeCadastroDePet.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import desafios.sistemaDeCadastroDePet.domain.AddressWhoFoundPet;
import desafios.sistemaDeCadastroDePet.domain.GenrePet;
import desafios.sistemaDeCadastroDePet.domain.Pets;
import desafios.sistemaDeCadastroDePet.domain.TypePet;
import desafios.sistemaDeCadastroDePet.repositories.InvalidParameterException;
import desafios.sistemaDeCadastroDePet.repositories.PetsTemplate;

public class PetWriterAndReader {
    public String pathname;

    static{
        Path path = Paths.get("desafios/sistemaDeCadastroDePet/db");
        if(Files.notExists(path)){
            try {
                Files.createDirectories(path); 
            } catch (IOException e) {
                System.out.println("Um erro ocorreu na tentativa de criar a pasta: "+path.getFileName());
            }
        }
    }

    public PetWriterAndReader(String pathname){
        this.pathname = pathname;
    }

    public List<Pets> getAllPets(){
        File directory = new File(this.pathname);
        String[] fileNames = directory.list();
        List<Pets> pets = new ArrayList<>();

        if(fileNames == null){
            return pets;
        }

        for(String fileName : fileNames){
            File petFile = new File(directory, fileName);
            
            if(petFile.isDirectory()){
                continue;
            }

            try(FileReader fr = new FileReader(petFile);
                BufferedReader br = new BufferedReader(fr)){
                    List<String> listString = new ArrayList<>();
                    String linha;
                    
                    while((linha = br.readLine()) != null){
                        listString.add(linha.replace(" - ", ","));
                    }

                    if(listString.size() >= 7){
                        String petName;
                        StringBuilder petSubName= new StringBuilder();
                        String specie;
                        TypePet tp;
                        GenrePet gp;
                        AddressWhoFoundPet address;
                        double age, size;
                        
                        String[] nameParts = listString.get(0).split(",")[1].trim().split(" ");
                        petName = nameParts[0];
                        if(nameParts.length > 1){
                            for(int i = 1; i < nameParts.length; i++){
                                petSubName.append(nameParts[i].trim());
                                if(i < nameParts.length - 1) {
                                    petSubName.append(" ");
                                }
                            }
                        }
                        
                        tp = listString.get(1).split(",")[1].trim().equals("Gato") 
                            ? TypePet.CAT : TypePet.DOG;
                        
                        gp = listString.get(2).split(",")[1].trim().equals("Masculino") 
                            ? GenrePet.MALE : GenrePet.FEMALE;
                        
                        String[] addressParts = listString.get(3).split(",");
                        address = new AddressWhoFoundPet(
                            addressParts.length > 2 ? addressParts[2].trim() : "",
                            addressParts.length > 3 ? addressParts[3].trim() : "",
                            addressParts.length > 1 ? addressParts[1].trim() : ""
                        );
                        
                        String ageStr = listString.get(4).split(",")[1].trim().split(" ")[0];
                        age = Double.parseDouble(ageStr);
                        
                        String sizeStr = listString.get(5).split(",")[1].trim().replaceAll("[a-zA-Z]+", "");
                        size = Double.parseDouble(sizeStr);
                        
                        specie = listString.get(6).split(",")[1].trim();

                        Pets pet = new Pets(petName,
                                petSubName.toString(),
                            tp, gp,
                            address, age, size,
                            specie, petFile.getAbsolutePath());
                        
                        pets.add(pet);
                    }

                }catch (IOException e){
                    System.err.println("Erro ao ler arquivo: " + fileName);
                }
            }
        return pets;
    }

    public void addNewPet(Pets pet) throws IOException{
        ZonedDateTime dateTime = Instant.ofEpochMilli(new Date().getTime()).atZone(ZoneId.systemDefault());
        File file = new File(
            this.pathname+"/"+
            dateTime.getYear()+
            dateTime.getMonthValue()+
            dateTime.getDayOfMonth()+
            "T"+
            dateTime.getHour()+
            dateTime.getMinute()+
            " - "+
            pet.getName().toUpperCase()+
            " "+ 
            pet.getSubname().toUpperCase()+
            ".txt"
        );

        if(pet.getFilename() == null){
            pet.setFilename(
                this.pathname+"/"+
                dateTime.getYear()+
                dateTime.getMonthValue()+
                dateTime.getDayOfMonth()+
                "T"+
                dateTime.getHour()+
                dateTime.getMinute()+
                " - "+
                pet.getName().toUpperCase()+
                " "+ 
                pet.getSubname().toUpperCase()+
                ".txt"
            );
        }
        if(!file.exists()){
            try{
                boolean isCreated = file.createNewFile();
                if(!isCreated){
                    System.out.println("Não foi possivel criar o arquivo.");
                }
            }catch(IOException e){
                System.out.println("Erro ao criar o arquivo: "+file.getName());
                return;
            }
        }

        try(FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw)){
                bw.write("1 - "+pet.getName()+" "+pet.getSubname()); bw.newLine();
                bw.write("2 - "+pet.getTypePet().getAttrName()); bw.newLine();
                bw.write("3 - "+pet.getGenrePet().getAttrName()); bw.newLine();
                bw.write(
                    "4 - "+pet.getAddressWhoFoundPet().getRoadOfHome()+", "
                    +pet.getAddressWhoFoundPet().getNumberOfHome()+
                    ", "+
                    pet.getAddressWhoFoundPet().getCityOfHome()
                ); bw.newLine();
                bw.write("5 - "+pet.getAge()+(pet.getAge() > 1 ? " anos" : " meses")); bw.newLine();
                bw.write("6 - "+pet.getSize()+"kg"); bw.newLine();
                bw.write("7 - "+pet.getSpecie());

                bw.flush();
                System.out.println("O arquivo "+file.getName()+" foi criado com sucesso!");
            }catch (IOException e){
                System.out.println("Erro ao escrever no arquivo: "+file.getName());
            }
            
    }

    public List<Pets> find(Predicate<Pets> petsPredicate, List<Pets> pets){
        List<Pets> returnedPets = new ArrayList<>();

        for (Pets pet : pets) {
            if(petsPredicate.test(pet)){
                returnedPets.add(pet);
            }
        }
        return returnedPets;
    }

    public Pets find(Predicate<Pets> petsPredicate){
        List<Pets> pets = getAllPets();

        for (Pets pet : pets) {
            if(petsPredicate.test(pet)){
                return pet;
            }
        }
        return null;
    }

    public void deletePet(String name, String subname) throws IOException{
        Pets pet = find(p -> p.getName().equalsIgnoreCase(name) && p.getSubname().equalsIgnoreCase(subname));
        
        if(pet == null){
            System.out.println("Pet não encontrado: " + name + " " + subname);
            return;
        }
        Path deleteFileFounded = Paths.get(pet.getFilename());
        Files.delete(deleteFileFounded);
        System.out.println("O pet foi deletado com sucesso.");
    }

    public void updatePet(Pets newPet, String name, String subName) throws InvalidParameterException{

        try{
            Pets pet = find(p -> p.getName().equalsIgnoreCase(name) && p.getSubname().equalsIgnoreCase(subName));
            if(pet != null){
                deletePet(name, subName);
                addNewPet(newPet);
            }else{
                throw new InvalidParameterException("O pet com nome '"+name+" "+subName+"' não existe.");
            }
        }catch(IOException e){
            System.out.println("Erro ao atualizar o pet: "+e.getMessage());
        }
    }

}
