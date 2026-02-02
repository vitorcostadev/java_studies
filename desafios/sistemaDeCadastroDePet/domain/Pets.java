package desafios.sistemaDeCadastroDePet.domain;

import java.lang.reflect.Field;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import desafios.sistemaDeCadastroDePet.repositories.InvalidNameException;
import desafios.sistemaDeCadastroDePet.repositories.PetsTemplate;

public class Pets extends PetsTemplate {
    public Pets(String name,
                String subname,
                TypePet typePet,
                GenrePet genrePet,
                AddressWhoFoundPet addressWhoFoundPet,
                Double age,
                Double size,
                String specie,
                String filename
    ){
        super(name,subname,typePet,genrePet,addressWhoFoundPet,age,size,specie,filename);
    }

    public Object hasFieldOfSameType(Object obj) {
        if (obj == null) return null;
        Class<?> tipoObjeto = obj.getClass();
        List<Object> classes = new ArrayList<>();

        for (Field field : getClass().getSuperclass().getDeclaredFields()) {
            if (field.getType().equals(tipoObjeto)) {
                return obj;
            }
        }
        return null;
    }

    public void setName(String name) throws InvalidNameException{
        if(
            name == null || name.isEmpty()
        ){
            throw new InvalidNameException("O nome não pode ser nulo ou vazio.");
        }
        this.name = name;
    }

    public void setSubname(String subname) throws InvalidNameException{
        if(
            subname == null || subname.isEmpty()
        ){
            throw new InvalidNameException("O sobrenome não pode ser nulo ou vazio.");
        }
        this.subname = subname;
    }

    public void setTypePet(TypePet typePet){
        if(typePet != null){
            this.typePet = typePet;
        }
    }

    public void setGenrePet(GenrePet genrePet){
        if(genrePet != null){
            this.genrePet = genrePet;
        }
        
    }

    public void setAddressWhoFoundPet(AddressWhoFoundPet addressWhoFoundPet) {
        if(addressWhoFoundPet != null){
            this.addressWhoFoundPet = addressWhoFoundPet;
        }
    }

    public void setAge(Double age) throws InvalidParameterException{
        if(age == null || age > 20){
            throw new InvalidParameterException("A idade não pode ser nula ou maior do que 20.");
        }
        this.age = age;
    }

    public void setSize(Double size) {
        if(
                size > 60 || size < 0.5
        ){
            throw new InvalidParameterException("O parametro 'size' não pode ser nulo e deve estar entre 60kg < size > 0.5kg.");
        }
        this.size = size;
    }

    public void setSpecie(String specie) {
        if(specie != null)
            this.specie = specie;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    public String getName() {
        return name;
    }

    public String getSubname() {
        return subname;
    }

    public TypePet getTypePet() {
        return typePet;
    }

    public GenrePet getGenrePet() {
        return genrePet;
    }

    public AddressWhoFoundPet getAddressWhoFoundPet() {
        return addressWhoFoundPet;
    }

    public Double getAge() {
        return age;
    }

    public Double getSize() {
        return size;
    }

    public String getSpecie() {
        return specie;
    }

    public String getFilename() {
        return filename;
    }
}
