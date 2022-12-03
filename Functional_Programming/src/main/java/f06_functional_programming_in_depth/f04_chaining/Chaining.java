package f06_functional_programming_in_depth.f04_chaining;

import java.util.function.Function;

// Chaining: La primera función se ejecuta primero y la segunda función se ejecuta usando el resultado devuelto por
//   la primera función. Esto puede seguir extendiéndose a más funciones.
public class Chaining {

    public static void main(String[] args) {
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = System.out::println;

        // Normal, no hay chaining
        c1.accept("Hello");
        c2.accept("Hello");

        System.out.println();

        // Tampoco hay chaining
        Consumer<String> c3 = s -> {
            c1.accept(s);
            c2.accept(s);
        };

        c3.accept("Hello");

        System.out.println();

        // Esto sería chaining
        Consumer<String> c4 = c1.thenAccept(c2);
        c4.accept("Adriana");

        // Se ha añadido en thenAccept() la sentencia que evita que next sea null
//        Consumer<String> c5 = c1.thenAccept(null);

        // Ya existen funciones tipo thenAccept() en Java, por ejemplo en la clase Function existe
        // el método default andThen() que acepta la salida devuelta por la primera Function y la pasa para
        // operar con ella.
        Function<Integer, Integer> f1 = s -> s + 2;
        Function<Integer, Integer> f2 = s -> s * 2;

        Function<Integer, Integer> f3 = f1.andThen(f2);
        System.out.println(f3.apply(10));
    }
}
