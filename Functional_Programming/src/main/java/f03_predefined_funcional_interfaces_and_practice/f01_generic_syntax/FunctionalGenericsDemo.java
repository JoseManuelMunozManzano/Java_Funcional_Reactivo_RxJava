package f03_predefined_funcional_interfaces_and_practice.f01_generic_syntax;

public class FunctionalGenericsDemo {

    public static void main(String[] args) {
        // Dando una idea básica sobre como usar generics en la programación funcional
        FunctionalGenerics<String, String> fun = s -> s.substring(1, 5);
        System.out.println(fun.execute("Llueve muy poco"));

        FunctionalGenerics<String, Integer> fun1 = s -> s.length();
        System.out.println(fun1.execute("Llueve mucho"));
    }
}
