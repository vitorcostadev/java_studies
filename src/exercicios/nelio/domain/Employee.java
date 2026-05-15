package src.exercicios.nelio.domain;

public class Employee {
    private String name;
    private double grossSalary;
    private double tax;

    public Employee(String name, double grossSalary, double tax) {
        this.name = name;
        this.grossSalary = grossSalary;
        this.tax = tax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", grossSalary=" + grossSalary +
                ", tax=" + tax +
                '}';
    }

    public double netSalary(){
        return this.grossSalary - (this.grossSalary * (this.tax/100));
    }

    public void increaseSalary(double percentage){
        setGrossSalary(this.grossSalary + (this.grossSalary * (percentage/100)));
        System.out.println("New gross salary R$ " + this.grossSalary);
    }
}
