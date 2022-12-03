package f03_predefined_funcional_interfaces_and_practice.f02_predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PracticePredicate {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("José");
        list.add("");
        list.add("Adriana");
        list.add("");
        list.add("AdrianaJosé");

        // Predicate chequea la condición de un valor dado y devuelve un booleano
        // Su método es: boolean test(T t)
        Predicate<String> predicate = s -> !s.isEmpty();
        List<String> newList = filterList(list, predicate);
        System.out.println(newList);

        Predicate<String> filter = s -> s.contains("Adriana");
        List<String> filteredList = filterList(list, filter);
        System.out.println(filteredList);
    }

    // Una función puede realizar muchos trabajos solo pasándole diferentes comportamientos con la misma firma.
    private static List<String> filterList(List<String> list, Predicate<String> predicate) {
        List<String> newList = new ArrayList<>();

        for (String string: list) {
            if (predicate.test(string)) {
                newList.add(string);
            }
        }

        return newList;
    }
}
