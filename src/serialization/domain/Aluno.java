package src.serialization.domain;

import java.io.*;

public class Aluno implements Serializable {
    private static final long serialVersionUID = -460787371392459263L;
    private Long id;
    private String name;
    private transient String password;
    private static final String NAMEOFTHESCHOOL = "DevDojo";

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", turma=" + turma +
                '}';
    }

    private transient Turma turma;

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Aluno(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private void writeObject(ObjectOutputStream oos){
        try{
            oos.defaultWriteObject();
            oos.writeUTF(turma.getName());

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream ois){
        try{
            ois.defaultReadObject();
            String nameTurma = ois.readUTF();
            turma = new Turma(nameTurma);
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
