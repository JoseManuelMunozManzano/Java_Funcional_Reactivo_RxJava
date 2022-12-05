package com.jmmunoz.gn11_behaviors_in_generic_and_non_generics_area;

import java.util.ArrayList;

// El comportamiento de un objeto depende del sitio en el que está presente ese objeto.
// Si está presente en un área Generic, solo se podrán añadir elementos que sean de un tipo parametrizado.
// Si está presente en un área No Generic, se podrán añadir elementos de cualquier tipo.
public class Behavior {

    public static void main(String[] args) {

        // Area genérica solo tipo String
        ArrayList<String> l = new ArrayList<>();
        l.add("Hola");
        l.add("Adri");

        method(l);

        System.out.println(l);

        System.out.println();

        // Area no genérica. Puede informarse cualquier cosa.
        ArrayList l2 = new ArrayList();
        l2.add(10);
        l2.add("Adiós");
        l2.add(true);

        methodGeneric(l2);

        System.out.println(l2);
    }

    // Area no genérica.
    public static void method(ArrayList l) {
        // l es un Raw Type, así que podemos añadir cualquier cosa
        l.add(10);
        l.add("Adiós");
        l.add(true);
    }

    // Area genérica tipo Integer.
    public static void methodGeneric(ArrayList<Integer> l) {
        l.add(891);
    }
}
