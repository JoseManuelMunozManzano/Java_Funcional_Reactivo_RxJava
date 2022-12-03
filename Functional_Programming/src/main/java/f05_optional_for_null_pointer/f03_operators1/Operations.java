package f05_optional_for_null_pointer.f03_operators1;

import java.util.Optional;

public class Operations {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Value");
        Optional<String> optionalEmpty = Optional.empty();

        // map()
        // Modifica la variable y la devuelve en un Optional si tiene valor o devuelve un Optional empty si es null
        // Se puede encadenar con otros métodos de la clase Optional
        Optional<String> map = optional.map(val -> "Replaced");
        System.out.println(map.get());

        String map2 = optionalEmpty.map(val -> "Replaced").orElse("Era empty");
        System.out.println(map2);

        // filter()
        Optional<String> filter = optional.filter(val -> val.equalsIgnoreCase("Value"));
        System.out.println(filter.get());

        // flatMap()
        // Parecido a map, pero en el callback hay que pasarle un Optional porque no envuelve el valor retornado
        // en un Optional porque el valor retornado por el mapper ya es un optional.
        Optional<String> flatMap = optional.flatMap(val -> Optional.of("Replaced By FlatMap"));
        System.out.println(flatMap.get());
    }
}
