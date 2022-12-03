package f03_predefined_funcional_interfaces_and_practice.f06_unary_operator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class PracticeUnaryOperator {

    public static void main(String[] args) {
        List<Integer> list = List.of(10, 20, 30, 40, 50);

        // UnaryOperator es una especialización de la interface Function. Toma un argumento de un tipo y devuelve el
        // mismo tipo de argumento.
        // Su método es: T apply(T t)
        UnaryOperator<Integer> operator = i -> i * 100;

        List<Integer> newList = mapper(list, operator);

        System.out.println(newList);
    }

    private static <T> List<T> mapper(List<T> list, UnaryOperator<T> operator) {
        List<T> newList = new ArrayList<>();

        for (T t: list) {
            T ele = operator.apply(t);
            newList.add(ele);
        }

        return newList;
    }
}
