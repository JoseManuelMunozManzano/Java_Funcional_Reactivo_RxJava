package f01_Lambda_and_functional_interface.f02_functional_interfaces;

public class F01_FunctionalInterfaceDemo {
    public static void main(String[] args) {
        // Informamos el código del método myMethod, la lambda.
        // Análogo a la asignación de variables.
        // Es programación declarativa porque el programador indica que hacer en vez de como hacerlo
        MyFunInterface fun = () -> System.out.println("Hello!");

        // Ejecutamos
        fun.myMethod();
    }
}
