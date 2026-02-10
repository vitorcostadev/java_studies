package src.comportamentos.tests;

import src.comportamentos.domain.Car;
import src.comportamentos.interfaces.CarPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ComportamentoPorParametroTest02 {
    private static final List<Car> cars = List.of(new Car("green", 2011), new Car("black", 1998), new Car("red", 2019));

    public static void main(String[] args) {
        System.out.println(filter(cars, car -> car.getYear() < 2010));

        List<Integer> nums = List.of(1,2,3,4,5,6,7,8,9,10);
        System.out.println(filter(nums, num -> num < 6));
    }

    private static <T> List<T> filter(List<T> cars, Predicate<T> carPredicate){
        List<T> filteredCars = new ArrayList<>();
        cars.forEach(car -> {
            if(carPredicate.test(car)){
                filteredCars.add(car);
            }
        });
        return filteredCars;
    }

}
