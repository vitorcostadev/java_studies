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

import desafios.sistemaDeCadastroDePet.domain.AddressWhoFoundPet;
import desafios.sistemaDeCadastroDePet.domain.GenrePet;
import desafios.sistemaDeCadastroDePet.domain.Pets;
import desafios.sistemaDeCadastroDePet.domain.TypePet;
import desafios.sistemaDeCadastroDePet.repositories.InvalidParameterException;

public class PetWriter {
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
    public PetWriter(String pathname){
        this.pathname = pathname;
    }

    public String getPathname() {
        return pathname;
    }

    public void addNewPet(Pets pet){
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
                pet.getSubname().toUpperCase()+
                ".txt"
            );
        }
        if(!file.exists()){
            try{
                boolean isCreated = file.createNewFile();
                System.out.println(file.getName()+" foi criado: "+isCreated);
            }catch(IOException e){
                e.printStackTrace();
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
            }catch(IOException e){
                e.printStackTrace();
            }

            System.out.println("O arquivo "+file.getName()+" foi criado com sucesso!");
    }

    private Pets findPetByName(String name, String subname) throws IOException{
        File file = new File(this.pathname);
        String[] files = file.list();

        for(int i = 0; i<files.length; i++){
            files[i] = files[i].replace(" - ", ",");
        }

        for(String k : files){
            String nameInDb = k.split("[\\.,]")[1];

            if((name+subname).toUpperCase().trim().equals(nameInDb)){
                List<String> listString = new ArrayList<>();

                try(FileReader fr = new FileReader(this.pathname+"/"+k.replace(","," - "));
                    BufferedReader br = new BufferedReader(fr)){
                        String linha;
                        while((linha = br.readLine()) != null){
                            listString.add(linha.replace(" - ", ","));
                        }
                };

                if(listString.size() >= 7){
                    String petName = null, petSubName = null, specie = null;
                    TypePet tp = null;
                    GenrePet gp = null;
                    AddressWhoFoundPet address = null;
                    Double age = null, size = null;
                    
                    String[] nameParts = listString.get(0).split(",")[1].trim().split(" ");
                    petName = nameParts[0];
                    petSubName = nameParts.length > 1 ? nameParts[1] : "";
                    
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
                    
                    Pets foundPet = new Pets(petName,
                        petSubName,
                        tp, gp, 
                        address, age, size, 
                        specie, this.pathname+"/"+k.replace(","," - "));

                    return foundPet;
                }

            }
        }
        return null;
    }

    public void deletePet(String name, String subname) throws IOException{
        Pets pet = findPetByName(name, subname);
        Path deleteFileFounded = Paths.get(pet.getFilename());

        Files.delete(deleteFileFounded);
    }

    public void attPet(Pets newPet, String name, String subName) throws IOException, InvalidParameterException{
        Pets pet = findPetByName(name, subName);
        if(pet != null){
            deletePet(name, subName);
            addNewPet(newPet);
        }else{
            throw new InvalidParameterException("O pet com nome '"+name+" "+subName+"' não existe.");
        }
    }
}
