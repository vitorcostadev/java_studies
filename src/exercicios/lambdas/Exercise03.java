package src.exercicios.lambdas;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise03 {
    public static void main(String[] args) {
        /*
        Implemente duas Function<String, String>.
        A primeira deve remover todos os espaços em branco de uma String.
        A segunda deve converter a String para letras minúsculas.
        Utilize o método andThen presente na interface Function para compor as duas lógicas.
        Em seguida, aplique a função resultante usando o map em um Stream<String> que processa textos
        brutos de arquivos de log, armazenando em um Set<String>.
         */
        String name = "                           Fl am e n go                          ";
        Function<String, String> removeBlankCharacters = s -> s.replace(" ", "").trim();
        Function<String, String> turnIntoUpper = String::toUpperCase;
        Function<String, String> stringAndThen = removeBlankCharacters.andThen(turnIntoUpper);

        Stream<String> stream = Stream.of(stringAndThen.apply(name));
        Set<String> collect = stream.filter(i -> !i.isEmpty())
                .collect(Collectors.toSet());

        System.out.println(collect);
    }
}
