package f03_predefined_funcional_interfaces_and_practice.f02_predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PracticePredicateWithGenerics {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("José");
        list.add("");
        list.add("Adriana");
        list.add("");
        list.add("AdrianaJosé");

        Predicate<String> predicate = s -> !s.isEmpty();
        List<String> newList = filterList(list, predicate);
        System.out.println(newList);

        Predicate<String> filter = s -> s.contains("Adriana");
        List<String> filteredList = filterList(list, filter);
        System.out.println(filteredList);

        // Gracias al uso de genéricos ahora puedo usar una lista de, por ejemplo, enteros
        List<Integer> intList = List.of(1, 4, 6, 7, 8);
        Predicate<Integer> integerFilter = e -> e % 2 == 0;
        List<Integer> evens = filterList(intList, integerFilter);
        System.out.println(evens);
    }

    // Una función puede realizar muchos trabajos solo pasándole diferentes comportamientos con la misma firma.
    // Aquí usando generics
    private static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        List<T> newList = new ArrayList<>();

        for (T t: list) {
            if (predicate.test(t)) {
                newList.add(t);
            }
        }

        return newList;
    }
}
