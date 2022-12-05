package com.jmmunoz.dp01_iterator_design_pattern;

import java.util.*;

// El patrón Iterator permite acceder a los elementos de un objeto colección de manera secuencial sin
// necesidad de conocer su representación interna, es decir, como se almacena la data internamente.
//
// Cuando se usa este patrón:
// - Para acceder al contenido de un objeto agregado sin exponer su representación interna.
// - Para soportar múltiples recorridos de objetos agregados.
// - Para proporcionar una interface uniforme para recorrer diferentes estructuras agregadas, es decir,
//   para soportar iteración polimórfica.
//
// En JDK se implementa este patrón en:
//  java.util.Iterator
//  java.util.Enumeration
public class IteratorDesignPattern {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Adri");
        list.add("Ferney");
        list.add("Tania");
        list.add("José");

        Iterator<String> itr = list.iterator();

        while (itr.hasNext()) {
            System.out.println("Name: " + itr.next());
        }
        System.out.println("Concrete Iterator we get is: " + itr.toString());

        System.out.println();

        Set<String> set = new HashSet<>();
        set.add("Set Adri");
        set.add("Set Ferney");
        set.add("Set Tania");
        set.add("Set José");

        Iterator<String> setItr = set.iterator();

        while (setItr.hasNext()) {
            System.out.println("Name: " + setItr.next());
        }
        System.out.println("Concrete Iterator we get is: " + setItr.toString());

    }
}
