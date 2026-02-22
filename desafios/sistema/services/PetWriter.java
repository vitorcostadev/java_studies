package desafios.sistema.services;

import desafios.sistema.domain.Pets;

import java.io.*;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class PetWriter implements AutoCloseable{
    private final String path = Forms.DB.getPath();
    private final FileWriter fw;

    PetWriter(Writer fw) throws IOException {
        this.fw = new FileWriter(fw.toString());
    }

    private boolean createFile(String name) throws IOException{
        if(name.isEmpty()) return false;
        File file = new File(this.path+"\\"+name);

        return file.createNewFile();
    }

    public void addPetToFile(Pets pet) throws IOException, RuntimeException{
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
    }

    @Override
    public void close() throws Exception {
        this.fw.close();
    }
}

