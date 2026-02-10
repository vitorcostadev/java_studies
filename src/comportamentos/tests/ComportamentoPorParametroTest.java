package src.comportamentos.tests;

import src.comportamentos.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest {
    private static List<Car> cars = List.of(new Car("green", 2011), new Car("black", 1998), new Car("red", 2019));

    public static void main(String[] args) {
        filterCarByColor(cars, "red").forEach(System.out::println);
        filterCarByColor(cars, "green").forEach(System.out::println);
        filterCarByAge(cars, 2010).forEach(System.out::println);
    }

    private static List<Car> filterCarByColor(List<Car> cars, String color){
        List<Car> filteredCars = new ArrayList<>();
        cars.forEach(car -> {
            if(car.getColor().equalsIgnoreCase(color)){
                filteredCars.add(car);
            }
        });

        return filteredCars;
    }

    private static List<Car> filterCarByAge(List<Car> cars, int year){
        List<Car> filteredCars = new ArrayList<>();
        cars.forEach(car -> {
            if(car.getYear() < year){
                filteredCars.add(car);
            }
        });

        return filteredCars;
    }

}
