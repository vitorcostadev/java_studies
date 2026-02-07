package src.exercicios.logicTraining2;

public class InvalidProductException extends RuntimeException{
    public InvalidProductException(){
        super("Invalid product.");
    }

    public InvalidProductException(String message){
        super(message);
    }
}
