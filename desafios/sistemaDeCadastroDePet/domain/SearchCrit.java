package desafios.sistemaDeCadastroDePet.domain;

import java.util.ArrayList;
import java.util.List;

public enum SearchCrit {
    NAME{
        @Override
        public List<Pets> findPet(List<Pets> pets, Object name){

            if(name instanceof String) {
                List<Pets> returnedPets = new ArrayList<>();
                for (Pets pet : pets) {
                    String namePet = pet.getName().toLowerCase()+" "+pet.getSubname().toLowerCase();
                    if (namePet.contains(((String) name).toLowerCase())) {
                        returnedPets.add(pet);
                    }
                }
                return !returnedPets.isEmpty() ? returnedPets : null;
            }
            return null;
        }
        
        @Override
        public List<Pets> findPets(List<Pets> pets, Object name, Object extra) {

            if (!(name instanceof String)) return new ArrayList<>();

            List<Pets> result = new ArrayList<>();

            for (Pets pet : pets) {
                String namePet = pet.getName().toLowerCase()+" "+pet.getSubname().toLowerCase();
                if (
                        namePet.contains(name.toString().toLowerCase()) &&
                                (extra == null || matchExtra(pet, extra))
                ) {
                    result.add(pet);
                }
            }
            return result;
        }
    },
    ADDRESS{
        @Override
        public List<Pets> findPet(List<Pets> pets, Object address){

            if(address instanceof AddressWhoFoundPet) {
                List<Pets> returnedPets = new ArrayList<>();
                for (Pets pet : pets) {
                    AddressWhoFoundPet petAddress = pet.getAddressWhoFoundPet();

                    if(
                            petAddress.getCityOfHome().equals(((AddressWhoFoundPet) address).getCityOfHome()) &&
                                    petAddress.getNumberOfHome().equals(((AddressWhoFoundPet) address).getNumberOfHome()) &&
                                    petAddress.getRoadOfHome().equals(((AddressWhoFoundPet) address).getRoadOfHome())
                    ){
                        returnedPets.add(pet);
                    }
                }
                return !returnedPets.isEmpty() ? returnedPets : null;
            }
            return null;
        }

        @Override
        public List<Pets> findPets(List<Pets> pets, Object name, Object extra) {

            if (!(name instanceof AddressWhoFoundPet)) return new ArrayList<>();

            List<Pets> result = new ArrayList<>();

            for (Pets pet : pets) {
                if (
                        pet.getAddressWhoFoundPet().equals(name) &&
                                (extra == null || matchExtra(pet, extra))
                ) {
                    result.add(pet);
                }
            }
            return result;
        }
    },
    SEX{
        @Override
        public List<Pets> findPet(List<Pets> pets, Object genre){

            if(genre instanceof GenrePet) {
                List<Pets> returnedPets = new ArrayList<>();
                for (Pets pet : pets) {
                    if (pet.getGenrePet().equals(genre)) {
                        returnedPets.add(pet);
                    }
                }
                return !returnedPets.isEmpty() ? returnedPets : null;
            }
            return null;
        }

        @Override
        public List<Pets> findPets(List<Pets> pets, Object name, Object extra) {

            if (!(name instanceof GenrePet)) return new ArrayList<>();

            List<Pets> result = new ArrayList<>();

            for (Pets pet : pets) {
                if (
                        pet.getGenrePet().equals(name) &&
                                (extra == null || matchExtra(pet, extra))
                ) {
                    result.add(pet);
                }
            }
            return result;
        }
    },
    AGE{
        @Override
        public List<Pets> findPet(List<Pets> pets, Object age){

            if(age instanceof Double) {
                List<Pets> returnedPets = new ArrayList<>();
                for (Pets pet : pets) {
                    if (pet.getAge().equals(age)) {
                        returnedPets.add(pet);
                    }
                }
                return !returnedPets.isEmpty() ? returnedPets : null;
            }
            return null;
        }

        @Override
        public List<Pets> findPets(List<Pets> pets, Object name, Object extra) {

            if (!(name instanceof Double)) return new ArrayList<>();

            List<Pets> result = new ArrayList<>();

            for (Pets pet : pets) {
                if (
                        pet.getAge().equals(name) &&
                                (extra == null || matchExtra(pet, extra))
                ) {
                    result.add(pet);
                }
            }
            return result;
        }
    },
    SIZE{
        @Override
        public List<Pets> findPet(List<Pets> pets, Object value){

            if(value instanceof Double) {
                List<Pets> returnedPets = new ArrayList<>();

                for (Pets pet : pets) {
                    if (pet.getSize().equals(value)) {
                        returnedPets.add(pet);
                    }
                }
                return !returnedPets.isEmpty() ? returnedPets : null;
            }
            return null;
        }

        @Override
        public List<Pets> findPets(List<Pets> pets, Object name, Object extra) {

            if (!(name instanceof Double)) return new ArrayList<>();

            List<Pets> result = new ArrayList<>();

            for (Pets pet : pets) {
                if (
                        pet.getSize().equals(name) &&
                                (extra == null || matchExtra(pet, extra))
                ) {
                    result.add(pet);
                }
            }
            return result;
        }
    },
    SPECIE{
        @Override
        public List<Pets> findPet(List<Pets> pets, Object specie){

            if(specie instanceof String) {
                List<Pets> returnedPets = new ArrayList<>();
                for (Pets pet : pets) {
                    if (pet.getSpecie().equals(specie)) {
                        returnedPets.add(pet);
                    }
                }
                return !returnedPets.isEmpty() ? returnedPets : null;
            }
            return null;
        }

        @Override
        public List<Pets> findPets(List<Pets> pets, Object name, Object extra) {

            if (!(name instanceof String)) return new ArrayList<>();

            List<Pets> result = new ArrayList<>();

            for (Pets pet : pets) {
                if (
                        pet.getSpecie().equals(name) &&
                                (extra == null || matchExtra(pet, extra))
                ) {
                    result.add(pet);
                }
            }
            return result;
        }
    };

    public abstract List<Pets> findPet(List<Pets> pets, Object value);
    public abstract List<Pets> findPets(List<Pets> pets, Object value, Object critOne);
    private static boolean matchExtra(Pets pet, Object crit) {

        if (crit instanceof GenrePet) {
            return pet.getGenrePet().equals(crit);
        }

        if (crit instanceof AddressWhoFoundPet) {
            AddressWhoFoundPet a = (AddressWhoFoundPet) crit;
            AddressWhoFoundPet p = pet.getAddressWhoFoundPet();

            return p.getCityOfHome().equals(a.getCityOfHome()) &&
                    p.getNumberOfHome().equals(a.getNumberOfHome()) &&
                    p.getRoadOfHome().equals(a.getRoadOfHome());
        }

        if (crit instanceof TypePet) {
            return pet.getTypePet().equals(crit);
        }

        if (crit instanceof String) {
            String s = (String) crit;
            return pet.getName().equals(s) ||
                    pet.getSubname().equals(s) ||
                    pet.getSpecie().equals(s);
        }

        if (crit instanceof Double) {
            Double d = (Double) crit;
            return pet.getAge().equals(d) ||
                    pet.getSize().equals(d);
        }

        return false;
    }
}
