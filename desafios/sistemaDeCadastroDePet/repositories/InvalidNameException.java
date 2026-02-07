package desafios.sistemaDeCadastroDePet.repositories;

public class InvalidNameException extends RuntimeException{
    public InvalidNameException(){
        super("O nome informado é incorreto.");
    }

    public InvalidNameException(String message){
        super(message);
    }
}
