package com.jmmunoz.gn10_wildcards.gn02_lower_bound_wildcard;

import java.util.ArrayList;
import java.util.List;

// Lower Bounded Wildcard se especifica>
// ? super B
// Donde B es el lower bound, cualquier clase o interface o tipo de dato.
public class Demo {

    // Solo puedo invocar este método para listas que contengan elementos que sean Integer o cualquiera de sus
    // supertipos.
    public static void displayData(List<? super Integer> l) {
        for (Object t : l) {
            System.out.println(t);
        }
    }

    // OJO, ahora solo puede ser una lista de Number o cualquiera de sus supertipos. No admite Integer porque
    // Integer es un subtipo de Number, no supertipo.
    public static void displayDataNumber(List<? super Number> l) {
        for (Object t : l) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(34);
        list.add(57);
        displayData(list);

        System.out.println();

        // Posible porque Number es un supertipo de Integer
        List<Number> list2 = new ArrayList<>();
        list2.add(34);
        list2.add(57);
        displayData(list2);

        System.out.println();

        // NO ADMITE INTEGER
        //displayDataNumber(list);

    }
}
