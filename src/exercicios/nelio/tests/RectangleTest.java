package src.exercicios.nelio.tests;

import src.exercicios.nelio.domain.Rectangle;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rec = new Rectangle(3, 4);
        System.out.println("Area: " + rec.area());
        System.out.println("Perimeter: " + rec.perimeter());
        System.out.println("Diagonal: " + rec.diagonal());
    }
}
