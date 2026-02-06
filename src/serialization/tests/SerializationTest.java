package src.serialization.tests;

import src.serialization.domain.Aluno;
import src.serialization.domain.Turma;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializationTest {
    public static void main(String[] args) {
        Aluno aluno = new Aluno(
                21L,
                "Vitor",
                "op2123"
        );
        Turma turma = new Turma("Cat");
        aluno.setTurma(turma);
        serializar(aluno);
        deserializar();
    }

    private static void serializar(Aluno aluno){
        Path path = Paths.get("files/file.ser");
        try(ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path))){
            out.writeObject(aluno);
        }catch(IOException e){
            System.out.println("An error ocurred: "+e.getMessage());
        }
    }

    private static void deserializar(){
        Path path = Paths.get("files/file.ser");
        try(ObjectInputStream out = new ObjectInputStream(Files.newInputStream(path))){
            Aluno aluno = (Aluno) out.readObject();
            System.out.println(aluno);
        }catch(IOException | ClassNotFoundException e){
            System.out.println("An error ocurred: "+e.getMessage());
        }
    }
}
