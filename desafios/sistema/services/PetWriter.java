package desafios.sistema.services;

import desafios.sistema.domain.Address;
import desafios.sistema.domain.Pets;
import desafios.sistema.domain.enums.Gender;
import desafios.sistema.domain.enums.Type;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class PetWriter {
    private final String path = "C:\\Users\\yori0\\OneDrive\\Documentos\\Cjava\\desafios\\sistema\\db";
    private FileWriter fw;

    PetWriter(FileWriter fw){
        this.fw = fw;
    }

    private boolean createFile(String name) throws IOException{
        if(name.isEmpty()) return false;
        File file = new File(this.path+"\\"+name);

        return file.createNewFile();
    }

    public boolean addPetToFile(Pets pet) throws IOException, RuntimeException{
        ZonedDateTime zonedDateTime = Instant.ofEpochMilli(new Date().getTime()).atZone(ZoneId.systemDefault());
        if(pet == null) throw new RuntimeException("The parameter pet is null.");

        boolean isCreatedFile = createFile(zonedDateTime+
                "-"+
                pet.getName()+
                ".txt");

        if(isCreatedFile) {
            try (BufferedWriter bf = new BufferedWriter(this.fw)) {
                bf.write("1. "+pet.getName()+
                        "\n2. "+pet.getType().name()+
                        "\n3. "+pet.getGender().name()+
                        "\n4. ");
                bf.flush();
            }
        }
        return isCreatedFile;
    }
}

