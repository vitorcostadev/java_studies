package desafios.sistemaDeCadastroDePet.domain;

import java.security.InvalidParameterException;

import desafios.sistemaDeCadastroDePet.repositories.InvalidNameException;

public class Pets {
    private String name;
    private String subname;
    private TypePet typePet;
    private GenrePet genrePet;
    private AddressWhoFoundPet addressWhoFoundPet;
    private Double age;
    private Double size;
    private String specie;
    private String filename;

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
        this.name = name;
        this.subname = subname;
        this.typePet = typePet;
        this.genrePet = genrePet;
        this.addressWhoFoundPet = addressWhoFoundPet;
        this.age = age;
        this.size = size;
        this.specie = specie;
        this.filename = filename;
    }

    public Pets(String name,
                String subname,
                TypePet typePet,
                GenrePet genrePet,
                AddressWhoFoundPet addressWhoFoundPet,
                Double age,
                Double size,
                String specie
    ){
        this.name = name;
        this.subname = subname;
        this.typePet = typePet;
        this.genrePet = genrePet;
        this.addressWhoFoundPet = addressWhoFoundPet;
        this.age = age;
        this.size = size;
        this.specie = specie;
        
        this.filename = null;
    }

    public Pets(TypePet typePet, GenrePet genrePet){
        this(null, null, typePet, genrePet, null, null,null,null,null);
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
            size > 60 ||
            size < 0.5 ||
            size == null
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
