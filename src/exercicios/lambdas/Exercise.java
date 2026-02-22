package src.exercicios.lambdas;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class Exercise {
    /*
    Crie um método que receba uma List<Integer>,
    um Predicate<Integer> e uma BiFunction<Integer, Integer, Integer>.
    O método deve usar streams para filtrar a lista pelo predicado e, em seguida, usar o método reduce()
    da API de Streams passando a BiFunction para consolidar o resultado em um único valor inteiro.
     */
    public static void main(String[] args) {
        List<Integer> list = List.of(255,233,444,222,333,555);
        Optional<Integer> optionalI = consolide(list, (n -> n > 0), (Integer::sum));

        System.out.println(optionalI.orElseThrow(IllegalArgumentException::new));
    }
    public static Optional<Integer> consolide(List<Integer> integers,
                                              Predicate<Integer> predicate,
                                              BinaryOperator<Integer> accumulator){
        return integers.stream()
                .filter(predicate)
                .reduce(accumulator);
    }
}
