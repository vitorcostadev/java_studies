package src.poo.metodos.tests;

import src.poo.metodos.classes.Professor;
import src.poo.metodos.classes.School;

public class SchoolTest {
    public static void main(String[] args) {
        Professor teacher = new Professor("Jiraiya");
        School school = new School("Aldeia da Folha");

        System.out.println(teacher.getName());
        school.imprimir();

        
    }
    
}
