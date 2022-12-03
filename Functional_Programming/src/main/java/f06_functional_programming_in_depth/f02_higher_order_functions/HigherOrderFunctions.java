package f06_functional_programming_in_depth.f02_higher_order_functions;

// Higher Order Functions son funciones que o toman funciones como argumentos o las devuelven en la salida o
// ambas cosas.
// Podemos intercambiar lambda y función
public class HigherOrderFunctions {

    public static void main(String[] args) {
        IFactory<Integer> createFactory = createFactory(() -> Math.random() * 100, r -> r.intValue());
        Integer product = createFactory.create();
        System.out.println(product);
    }

    public static <T, R> IFactory<R> createFactory(IProducer<T> producer, IConfigurator<T, R> configurator) {
        return () -> {
            T product = producer.produce();
            return configurator.configure(product);
        };
    }
}
