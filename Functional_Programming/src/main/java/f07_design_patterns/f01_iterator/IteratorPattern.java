package f07_design_patterns.f01_iterator;

// Iterator Design Pattern: consiste en acceder a elementos sin exponer su estructura interna (si es una lista, un set)
// Ejemplos serían java.util.Iterator y java.util.Enumeration
public class IteratorPattern {

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(new Object[]{1, 3, 5, 67, 8});
        list.forEach(System.out::println);
    }
}
