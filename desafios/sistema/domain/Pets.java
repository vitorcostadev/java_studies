package desafios.sistema.domain;

import desafios.sistema.domain.enums.Gender;
import desafios.sistema.domain.enums.Type;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Pets implements Comparable<Pets>{
    private String name;
    private Type type;
    private Gender gender;
    private Address address;
    private Integer age;
    private Double weight;
    private String specie;

    public Pets(String name, Type type, Gender gender, Address address, Integer age, Double weight, String specie) {
        this.name = name;
        this.type = type;
        this.gender = gender;
        this.address = address;
        this.age = age;
        this.weight = weight;
        this.specie = specie;
    }

    @Override
    public String toString() {
        return "Pets{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", gender=" + gender +
                ", address=" + address +
                ", age=" + age +
                ", weight=" + weight +
                ", specie='" + specie + '\'' +
                '}';
    }

    public Pets(Type type, Gender gender){
        this(null, type, gender, null, null, null, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Pets pets = (Pets) object;
        return Objects.equals(name, pets.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public int compareTo(@NotNull Pets o) {
        return o.getName().compareTo(this.name);
    }
}
