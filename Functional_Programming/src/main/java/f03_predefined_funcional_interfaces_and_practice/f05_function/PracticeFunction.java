package f03_predefined_funcional_interfaces_and_practice.f05_function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class PracticeFunction {

    public static void main(String[] args) {
        List<String> list = List.of("Kit", "Kat", "Shake");

        // Function toma un argumento y devuelve un resultado. Se usa para transformar un parámetro de entrada
        // en otro (del mismo u otro tipo de dato) que se devuelve a la salida.
        // Su método es: R apply(T t)
        Function<String, Integer> function =  e -> e.length();
        List<Integer> newList = map(list, function);
        System.out.println(newList);
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> newList = new ArrayList<>();

        for (T e: list) {
            newList.add(function.apply(e));
        }

        return newList;
    }
}
