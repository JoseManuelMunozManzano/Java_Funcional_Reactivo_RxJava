package f01_Lambda_and_functional_interface.f02_functional_interfaces;

public class F02_FunctionalInterfaceOnTheFly {
    public static void main(String[] args) {
        // Pasando comportamiento (una implementación) en el momento como un parámetro a una función.
        // Antes de Java 8 esto no era posible y había que hacerlo con clases anónimas.
        // Ahora se tratan como variables (first class citizens).
        onTheFly(() -> System.out.println("Hello"));
    }

    public static void onTheFly(MyFunInterface fun) {
        fun.myMethod();
    }
}
