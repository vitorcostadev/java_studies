package src.collections.domain;

import java.util.Objects;

public class Smartphone {
    private String serialNumber;
    private String marca;

    @Override
    public String  toString() {
        return "Smartphone{" +
                "serialNumber='" + serialNumber + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }

    public String getSerialNumber() {
        return serialNumber;
    }
    @Override
    public boolean equals(Object object){
        if(object == null) return false;
        if(this == object) return true;
        if(this.getClass() != object.getClass()) return false;
        Smartphone obj = (Smartphone) object;
        return serialNumber != null && serialNumber.equals(obj.getSerialNumber());
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Smartphone(String serialNumber, String marca) {
        this.serialNumber = serialNumber;
        this.marca = marca;
    }

    // se x.equals(y) == true, y.hashCode() == x.hashCode().
    // y.hashCode() == y.hashCode() não necessariamente o equals de y.equals(x) tem que ser true.
    // y.hashCode() != x.hashCode() logo, x.equals(y) deverá ser false.
    @Override
    public int hashCode() {
        return this.serialNumber != null ? this.serialNumber.hashCode() : 0;
    }
}
