package f12_playing_with_collections_and_map_in_functional_style.f03_map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

// Vamos a ver:
// - Traversing
// - Filtering
// - Sorting
// - Mapping
// - Reducing
public class MapFunctional {

    public static void main(String[] args) {
        Map<String,String> contacts = new HashMap<>();

        contacts.put("1237589020", "John");
        contacts.put("1237009020", "John");
        contacts.put("7890291111", "Neal");
        contacts.put("2647210290", "Raju");
        contacts.put("9999999999", "Peter");
        contacts.put("9081234567", "Neha");

        // Traversing
        //      Imperativo
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        System.out.println("\n-----------------\n");

        //      Programación Funcional
        contacts.forEach((k, v) -> System.out.println(k + " - " + v));

        System.out.println("\n-----------------\n");

        // Filtering
        // No hay método stream() en un map, así que se aplica sobre un entrySet()
        contacts.entrySet().stream()
                .filter(contact -> "John".equalsIgnoreCase(contact.getValue()))
                .forEach(System.out::println);

        System.out.println("\n-----------------\n");

        // Y para obtener el resultado en un map se usa un collector.
        Map<String, String> filteredContacts = contacts.entrySet().stream()
                .filter(contact -> "John".equalsIgnoreCase(contact.getValue()))
                .collect(Collectors.toMap(c -> c.getKey(), c -> c.getValue()));

        // Map
        String contactNames = contacts.entrySet().stream()
                .distinct()
                .map(c -> c.getValue())
                .collect(Collectors.joining(" , "));

        System.out.println(contactNames);

        System.out.println("\n-----------------\n");

        // Sorting
        // Collectors.toMap(keyMapper, valueMapper) devuelve un hashMap y este no preserva el orden de inserción.
        // Hay que usar Collectors.toMap(keyMapper, valueMapper, mergeFunction, mapFactory)
        // y gracias al mapFactory podemos devolver el resultado en una colección que sí respeta el orden, como
        // LinkedHashMap
        LinkedHashMap<String, String> sortedMap = contacts.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(c -> c.getKey(),
                        c -> c.getValue(),
                        (v1, v2) -> v1,
                        LinkedHashMap::new));

        sortedMap.forEach((k, v) -> System.out.println(k + " - " + v));

        System.out.println("\n-----------------\n");

        // Reducing
        Map<String,Double> marks = new HashMap<>();

        marks.put("Science", 66.00);
        marks.put("Maths", 78.00);
        marks.put("English", 90.00);

        OptionalDouble average = marks.values().stream()
                .mapToDouble(m -> m)
                .average();

        System.out.println(average.getAsDouble());
    }
}
