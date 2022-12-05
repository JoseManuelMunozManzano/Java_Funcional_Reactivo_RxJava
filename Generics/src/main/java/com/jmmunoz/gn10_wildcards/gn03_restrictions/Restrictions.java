package com.jmmunoz.gn10_wildcards.gn03_restrictions;

import java.util.ArrayList;
import java.util.List;

// Las limitaciones que introducen los wildcards son las siguientes:
//  - No pueden usarse como tipo parametrizado en la declaración de una clase. Esto no es posible:
//          public class Box<?> {}
//  - A diferencia de los tipos parametrizados, los wildcards no soportan múltiples acotamientos.
//      Por ejemplo, esto falla:
//          private List<? extends Number & Runnable> a;
//  - No tenemos restricciones a la hora de realizar operaciones de lectura, pero para Unbounded Wildcards o
//      Upper Bounded Wildcards no se pueden realizar operaciones de escritura porque no sabemos que tipo puede tener.
//  - Con Lower Bound Wildcards SI se pueden realizar escrituras.
//  - Podemos crear instancias de objetos usando Wildcard. Por ejemplo, esto es posible:
//          List<?> l1 = new ArrayList<>();
//      Pero no tiene mucho sentido porque no se pueden hacer escrituras en Unbounded Wildcards ni en
//      Upper Bound Wildcards.
//      Si se pueden hacer escrituras si se declara la lista de esta forma:
//          List<? super Integer> l1 = new ArrayList<>();
//  - No se pueden usar Wildcards en la parte derecha de la instanciación. Por ejemplo, esto no es posible:
//          List<?> l1 = new ArrayList<?>();
public class Restrictions {

    // No podemos escribir en Unbounded Wildcards o Upper Bounded Wildcards
    public static void displayData(List<? extends Number> l) {
        // Error porque no sabemos que lista viene, así que no podemos escribir en ella.
        // l.add(10);
    }

    // Lower Bound Wildcard. Podemos hacer escrituras.
    public static void displayDataLowerBound(List<? super Integer> l) {
        l.add(10);
    }

    public static void main(String[] args) {
        // Esto es posible y admite escrituras
        List<? super Integer> l1 = new ArrayList<>();
        l1.add(10);
    }
}
