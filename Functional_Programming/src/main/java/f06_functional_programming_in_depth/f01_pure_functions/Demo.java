package f06_functional_programming_in_depth.f01_pure_functions;

public class Demo {
    public static void main(String[] args) {
        int result = add(multiply(2, 3), multiply(3, 4));
        System.out.println(result);

        System.out.println();
        // El modelo de sustitución dice que se puede reemplazar cualquier llamada a función con su resultado.
        // Pero en este caso no se llama al método log.
        result = add(6, 12);
        System.out.println(result);

        // Por tanto, el método multiply no es una función pura.
        // El método log tampoco es una función pura porque no devuelve resultado. Además, está escribiendo en la
        // consola, lo que se considera un efecto colateral.

        // Sobre las interfaces funcionales, tenemos la interface Consumer, que toma algo pero no devuelve nada.
        // Esto indica que siempre va a contener efectos colaterales.
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int multiply(int a, int b) {
        log(String.format("Returning %s as the result of %s * %s", a * b, a, b));
        return a * b;
    }

    private static void log(String m) {
        System.out.println(m);
    }
}
