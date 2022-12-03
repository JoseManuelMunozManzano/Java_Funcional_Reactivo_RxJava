package f03_predefined_funcional_interfaces_and_practice.f04_supplier;

import java.util.function.Supplier;

public class PracticeSupplier {

    public static void main(String[] args) {
        // Supplier se usa para producir resultados sin recibir ningún parámetro.
        // Su método es: T get()
        Supplier<String> stringSupplier = () -> new String("A String");
        System.out.println(stringSupplier.get());

        // Un buen caso de uso es para devolver números aleatorios
        Supplier<Double> randomNumber = () -> Math.random();
        System.out.println(randomNumber.get());
    }
}
