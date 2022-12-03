package f05_optional_for_null_pointer.f04_operators2;

import java.util.Optional;

public class MoreOperations {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Value");
        Optional<String> optional2 = Optional.empty();

        // ifPresent(consumer)
        // Si hay un valor se ejecuta el Consumer. Si no lo hay no se hace nada
        optional.ifPresent(val -> System.out.println("This is a " + val));

        // ifPresentOrElse(consumer, runnable)
        // Como ifPresent, pero si la variable es null se ejecuta lo que queramos. Hay que pasarle un consumer
        // por si hay valor y un runnable por si es null
        optional2.ifPresentOrElse(System.out::println, () -> System.out.println("Value is absent"));

        // stream
        // Si hay valor se devuelve un stream con ese valor. Si no hay valor devuelve un stream vacío
        optional.stream().forEach(System.out::println);
        optional2.stream().forEach(System.out::println);

        // or(supplier)
        // Necesita un Supplier y devuelve el mismo Optional si hay valor. Si no hay valor devuelve un nuevo
        // Optional
        optional.or(() -> Optional.of("New Value")).ifPresent(System.out::println);
        optional2.or(() -> Optional.of("New Value")).ifPresent(System.out::println);

        // equals(object)
        // Comprueba si otro objeto es igual o no al Optional
        // El otro objeto se considera igual si es otro Optional, y si ambos Optionals son empty o ambos
        // contienen el mismo valor.
        System.out.println(optional.equals(Optional.of("Value")));
        System.out.println(optional2.equals(Optional.empty()));

        // hashCode
        // Devuelve el hashcode del valor
        // Si el Optional es empty devuelve 0
        System.out.println(optional.hashCode());
        System.out.println(optional2.hashCode());
    }
}
