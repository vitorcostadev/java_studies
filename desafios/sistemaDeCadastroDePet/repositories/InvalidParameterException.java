package desafios.sistemaDeCadastroDePet.repositories;

public class InvalidParameterException extends RuntimeException{
    public InvalidParameterException(){
        super("O parametro informado é incorreto.");
    }

    public InvalidParameterException(String message){
        super(message);
    }
}
