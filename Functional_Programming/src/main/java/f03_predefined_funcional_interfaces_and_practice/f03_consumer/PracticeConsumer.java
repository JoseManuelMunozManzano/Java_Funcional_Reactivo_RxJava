package f03_predefined_funcional_interfaces_and_practice.f03_consumer;

import java.util.List;
import java.util.function.Consumer;

public class PracticeConsumer {

    public static void main(String[] args) {
        List<Integer> list = List.of(34, 67, 8, 23, 67, 89, 90);

        // Consumer consume un objeto de tipo generic T, hace algo con él y no devuelve nada.
        // Su método es: void accept(T t)
        Consumer<Integer> consumer = e -> System.out.println(e);

        // Ejecutando el consumer sobre un valor concreto
        consumer.accept(56);

        // Ejecutando el consumer sobre la lista
        printElements(list, consumer);
    }

    private static <T> void printElements(List<T> list, Consumer<T> consumer) {
        for (T t: list) {
            consumer.accept(t);
        }
    }
}
