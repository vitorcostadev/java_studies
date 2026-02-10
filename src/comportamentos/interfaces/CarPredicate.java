package src.comportamentos.interfaces;

import src.comportamentos.domain.Car;

@FunctionalInterface // Só pode ter um metodo
// anonimas, functions, conciso
public interface CarPredicate {
    boolean test(Car car); // functional descriptor
    //(parametro) -> <exp>
}
