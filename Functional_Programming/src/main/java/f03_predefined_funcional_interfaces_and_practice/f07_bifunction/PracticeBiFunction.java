package f03_predefined_funcional_interfaces_and_practice.f07_bifunction;

import java.util.function.BiFunction;

public class PracticeBiFunction {

    public static void main(String[] args) {
        // BiFunction es una especialización de la interface Function. Toma dos argumentos de un mismo tipo o distinto
        // y devuelve un tipo de dato que puede ser igual a uno de los tipos de argumentos de entrada o distinto.
        // Su método es: R apply(T t, U u)
        BiFunction<String, String, String> biFunction = (a, b) -> a + " y " + b;
        System.out.println(biFunction.apply("José Manuel", "Adriana"));

        // Otro ejemplo con un tipo de retorno distinto al tipo de los parámetros de entrada
        BiFunction<String, String, Integer> biFunctionLength = (a, b) -> (a + " y " + b).length();
        System.out.println(biFunctionLength.apply("José Manuel", "Adriana"));
    }
}
