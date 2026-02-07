package src.projetins.sistemaDeCadastro.domain;

import java.time.LocalDateTime;

public class Produto {
    private String name;
    private int stock;
    private double value;
    private LocalDateTime dateOfInsert = LocalDateTime.now();

    public Produto(String name, int stock, double value, LocalDateTime dateOfInsert) {
        this.name = name;
        this.stock = stock;
        this.value = value;
        this.dateOfInsert = dateOfInsert;
    }

    public Produto(String name, int stock, double value){
        this.name = name;
        this.stock = stock;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(!name.isEmpty())
            this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if(stock > 0)
            this.stock = stock;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        if(value > 0)
            this.value = value;
    }

    public LocalDateTime getDateOfInsert() {
        return dateOfInsert;
    }

    public void setDateOfInsert(LocalDateTime dateOfInsert) {
        this.dateOfInsert = dateOfInsert;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "name='" + name + '\'' +
                ", stock=" + stock +
                ", value=" + value +
                ", dateOfInsert=" + dateOfInsert +
                '}';
    }
}
