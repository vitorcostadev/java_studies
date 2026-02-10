package desafios.sistemaDeCadastroDePet.domain;

import java.security.InvalidParameterException;

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
    ) throws InvalidNameException, InvalidParameterException {
        super(name, subname, typePet, genrePet, addressWhoFoundPet, age, size, specie, filename);
        
        if (name == null || name.isEmpty()) {
            throw new InvalidNameException("O nome não pode ser nulo ou vazio.");
        }
        if (subname == null || subname.isEmpty()) {
            throw new InvalidNameException("O sobrenome não pode ser nulo ou vazio.");
        }
        if (age == null || age > 20 || age < 0) {
            throw new InvalidParameterException("A idade deve estar entre 0 e 20.");
        }
        if (size == null || size > 60 || size < 0.5) {
            throw new InvalidParameterException("O tamanho deve estar entre 0.5kg e 60kg.");
        }
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
        if (size == null || size > 60 || size < 0.5) {
            throw new InvalidParameterException("O parametro 'size' não pode ser nulo e deve estar entre 0.5kg e 60kg.");
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

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return  false;
        if(this == obj) return true;
        if(this.getClass() != obj.getClass()) return false;
        Pets pets = (Pets) obj;
        return name.equals(pets.getName()) && subname.equals(pets.getSubname());
    }

    @Override
    public String toString() {
        return "Pets{" +
                "name='" + name + '\'' +
                ", subname='" + subname + '\'' +
                ", typePet=" + typePet +
                ", genrePet=" + genrePet +
                ", addressWhoFoundPet=" + addressWhoFoundPet +
                ", age=" + age +
                ", size=" + size +
                ", specie='" + specie + '\'' +
                ", filename='" + filename + '\'' +
                '}';
    }

}
