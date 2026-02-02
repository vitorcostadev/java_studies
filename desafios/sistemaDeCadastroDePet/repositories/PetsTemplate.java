package desafios.sistemaDeCadastroDePet.repositories;

import desafios.sistemaDeCadastroDePet.domain.AddressWhoFoundPet;
import desafios.sistemaDeCadastroDePet.domain.GenrePet;
import desafios.sistemaDeCadastroDePet.domain.TypePet;

public abstract class PetsTemplate {
    protected String name;
    protected String subname;
    protected TypePet typePet;
    protected GenrePet genrePet;
    protected AddressWhoFoundPet addressWhoFoundPet;
    protected Double age;
    protected Double size;
    protected String specie;
    protected String filename;

    public PetsTemplate(String name,
                        String subname,
                        TypePet typePet,
                        GenrePet genrePet,
                        AddressWhoFoundPet addressWhoFoundPet,
                        Double age,
                        Double size,
                        String specie,
                        String filename
    ) {
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

}
