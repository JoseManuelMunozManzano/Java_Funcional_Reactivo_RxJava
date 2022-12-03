package f07_design_patterns.f05_factory;

import java.util.function.Supplier;

// Clase Factory con un método estático factory que devuelve el objeto de cualquiera de las 3 clases que implementan
// la interface Flooring
public class FlooringFactory {

    public static Flooring getFlooring(int minTemperature, int maxTemperature) {

        Supplier<Flooring> flooring;

        if (minTemperature <= 5 && maxTemperature <= 20) {
            flooring = () -> new WoodenFlooring();
        } else if (minTemperature <= 5 && maxTemperature >= 45) {
            flooring = () -> new CorkFlooring();
        } else {
            flooring = () -> new ConcreteFlooring();
        }

        return flooring.get();
    }
}
