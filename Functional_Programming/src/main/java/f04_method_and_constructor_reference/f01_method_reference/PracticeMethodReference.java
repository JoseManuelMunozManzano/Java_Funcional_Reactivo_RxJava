package f04_method_and_constructor_reference.f01_method_reference;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class PracticeMethodReference {

    public static void main(String[] args) {
        // Hay cuatro tipos de method reference
        //   1   object :: instanceMethod
        //   2   Class :: staticMethod
        //   3   Class :: instanceMethod
        //   4   Class :: new

        // 1
        // Method Reference
        // En vez de escribir una lambda podemos, directamente, referirnos al método.
        // Consumer<Integer> consumer = e -> System.out.println(e);
        // Antes de los dos puntos se indica el objeto y tras los dos puntos indicamos el nombre del método
        // sin los paréntesis ni los argumentos.
        Consumer<Integer> consumer = System.out::println;
        consumer.accept(56);

        // 2
        // En vez de la lambda
        // Supplier<Double> randomNumber = () -> Math.random();
        // Podemos escribir el siguiente method reference
        Supplier<Double> randomNumber = Math::random;
        System.out.println(randomNumber.get());

        // Otro ejemplo con parámetros
        // En vez de la lambda
        // BiFunction<String, String, String> biFunction = (a, b) -> a + " y " + b;
        // Podemos escribir el siguiente method reference
        BiFunction<String, String, String> biFunction = A_Class :: staticMethod;
        System.out.println(biFunction.apply("José Manuel", "Adriana"));

        // 3
        // En vez de la labmda
        // Function<String, Integer> function = e -> e.length();
        // Podemos escribir el siguiente method reference
        Function<String, Integer> function = String::length;
        System.out.println(function.apply("Adriana"));

    }

    class A_Class {
        static String staticMethod(String a, String b) {
            return a + " y " + b;
        }
    }

}
