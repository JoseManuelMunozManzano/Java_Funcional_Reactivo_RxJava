package com.jmmunoz.gn04_collections_with_generics;

import java.util.ArrayList;

// Hemos visto hasta ahora los beneficios de generics:
// - Comprobación de tipado más fuerte
// - Seguridad de tipado
// - Eliminación de casts
// - Reusabilidad del código
//
// Vamos a ver otro beneficio muy importante.
// - Los programadores pueden implementar algoritmos genéricos que funcionan en colecciones de distintos tipos.
//   El paquete Java Collections fue rehecho en la versión 5 de Java para trabajar con generics, haciéndolo
//   Type Safety.
public class CollectionsWithGenerics {

    public static void main(String[] args) {

        // Sin genéricos
        // Se supone que solo queríamos String, pero se nos ha colado un Integer.
        ArrayList list = new ArrayList();
        list.add("Adri");
        // Esto dará un error de cast en tiempo de ejecución que el compilador no ha sido capaz de identificar.
        list.add(1);

        for (Object ob : list) {
            String str = (String) ob;
            System.out.println(str);
        }


        System.out.println();


        // Con genéricos.
        // El compilador evita que cometamos errores con los tipos.
        // Además evitamos el uso de cast
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Adri");
        // Esta sentencia da ahora error en tiempo de compilación
        //list2.add(1);

        // Ya no hace falta usar Object ni cast
        // Como hemos indicado el tipo parametrizado String, podemos hacer la iteración pasando a String directamente.
        for (String ob : list2) {
            String str = ob;
            System.out.println(str);
        }

    }
}
