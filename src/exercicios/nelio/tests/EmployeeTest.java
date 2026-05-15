package src.exercicios.nelio.tests;

import src.exercicios.nelio.domain.Employee;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee emp = new Employee("Vitor", 14500, 10);
        System.out.println(emp.netSalary());
        emp.increaseSalary(50);
        System.out.println(emp.netSalary());
    }
}
