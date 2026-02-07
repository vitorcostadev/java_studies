package src.poo.metodos.classes;

public class School {
    private String name;
    private Professor[] teachers;

    public School(String name) { this.name = name; }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeachers(Professor[] teachers) {
        this.teachers = teachers;
    }

    public String getName() {
        return name;
    }

    public Professor[] getTeachers() {
        return teachers;
    }

    public void imprimir()
    {
        System.out.println("Nome: "+this.name);
        if(this.teachers != null)
        {
            for(Professor teacher : teachers){
                System.out.println("Teacher: "+teacher.getName());
            }
        }
    }
    
}
