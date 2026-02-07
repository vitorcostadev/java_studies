package src.exercicios.logicTraining2;

public class Produto {
    private String name;
    private int stock;
    private double value;

    public Produto(String productName, int productStock, double productValue) throws InvalidProductException{
        if(productStock <= 0){
            throw new InvalidProductException("O parametro 'productStock' deve ser maior do que zero.");
        }if(productName == null | productName.isEmpty()){
            throw new InvalidProductException("O parametro 'productName' nao pode ser nulo ou vazio.");
        }if(productValue < 0){
            throw new InvalidProductException("O parametro 'productValue' nao pode ser negativo.");
        }
        this.name = productName; this.stock = productStock; this.value = productValue;
    }
    
    @Override
    public String toString() {
        return this.name + " | " + this.stock + " | " + this.value;
    }

    public void setName(String name) throws InvalidProductException{
        if(name == null || name.isEmpty()){
            throw new InvalidProductException("O parametro 'name' não pode ser nulo ou vazio.");
        }
        this.name = name;
    }

    public void setStock(int stock) throws InvalidProductException{
        if(stock <= 0){
            throw new InvalidProductException("O parametro 'stock' não pode ser negativo.");
        }
        this.stock = stock;
    }

    public void setValue(double value) throws InvalidProductException{
        if(value <= 0){
            throw new InvalidProductException("O parametro 'value' deve ser maior do que zero.");
        }
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public double getValue() {
        return value;
    }
}
