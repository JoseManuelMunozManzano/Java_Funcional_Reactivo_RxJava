package f03_predefined_funcional_interfaces_and_practice.f08_binary_operator;

import java.util.function.BinaryOperator;

public class PracticeBinaryOperator {

    public static void main(String[] args) {
        // BinaryOperator es una especialización de la interface BiFunction. Toma dos argumentos de un mismo tipo
        // y devuelve el mismo tipo de dato.
        // Su método es: T apply(T t1, T t2)
        BinaryOperator<String> operator = (a, b) -> a + " y " + b;
        System.out.println(operator.apply("José Manuel", "Adriana"));
    }
}
