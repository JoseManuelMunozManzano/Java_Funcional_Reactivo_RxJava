package com.jmmunoz.gn12_type_erasure;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Type Erasure (Borrado de tipo)
// Generics está implementado por el compilador Java como una conversión front-end llamada erasure.
// Durante el proceso de borrado de tipo, el compilador Java borra todos los tipos parametrizados y los reemplaza
// con su primer límite si el tipo parametrizado es acotado u Object si el tipo parametrizado no está acotado.
// El compilador genera extra cast donde sea necesario y en tiempo de ejecución la información de tipo adicional
// ha sido borrada por completo por el compilador.
public class TypeErasure {

    public static void main(String[] args) {

        // Esto falla en tiempo de ejecución por la explicación dada en method1()
        // Type Safety y Type Casting se realizan en tiempo de compilación.

        //System.out.println(method1(10));



        // Supongamos ahora que asignamos un objeto Generic a una referencia no Generic.
        // En tiempo de compilación el compilador Java usará Type Erasure para eliminar la sintaxis Generic.
        // Es equivalente a: ArrayList l1 = new ArrayList();
        // Por eso, aunque se supone que queremos String, hemos podido añadir un Integer y un Boolean.
        // De hecho, en la parte derecha, indicar el tipo parametrizado es opcional.
        // Y no falla al imprimirlo en pantalla.
        ArrayList l1 = new ArrayList<String>();
        l1.add(12);
        l1.add(true);

        System.out.println(l1);
    }

    public static String method1(Integer x) {
        // Lo que ha ocurrido es que durante la etapa de Type Erasure la línea se convierte en:
        // List a = new LinkedList;
        // Donde el compilador elimina la información generic
        List<String> a = new LinkedList<>();

        List b = a;

        b.add(x);

        // Y esta línea se convierte en:
        // return (String) a.iterator().next();
        return a.iterator().next();
    }

    // Supongamos que tenemos este método
    public static void method2(ArrayList<String> l) {}

    // Y hacemos sobrecarga cambiando el tipo de ArrayList
    // Vemos que se produce un error.
    // Esto es porque el Type Erasure deja los dos ArrayList sin tipo de parámetro, esto es, completamente iguales.
    //public static void method2(ArrayList<Integer> l) {}

}
