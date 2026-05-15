package src.exercicios.nelio.domain;

import java.util.function.BiFunction;

public class Rectangle {
    private double base, altura;

    public Rectangle(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        if(base < 0D) throw new IllegalArgumentException("The parameter base must be positive.");
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if(altura < 0D) throw new IllegalArgumentException("The parameter altura must be positive.");

        this.altura = altura;
    }

    private double transform(BiFunction<Double, Double, Double> biFunction){
        return biFunction.apply(base, altura);
    }

    public double area(){
        return transform((b,a) -> b * a);
    }

    public double perimeter(){
        return transform((b, a) -> 2 * (b + a));
    }

    public double diagonal(){
        return transform((b,a) -> Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2)));
    }
}
