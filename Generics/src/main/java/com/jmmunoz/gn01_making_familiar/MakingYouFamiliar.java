package com.jmmunoz.gn01_making_familiar;

// Generics son un chequeo de tipos en tiempo de compilación
// Por qué usarlos? Para que los posibles errores que surjan, lo hagan en tiempo de compilación y no de ejecución.
//  Ademås, con generics podemos reutilizar el código
public class MakingYouFamiliar {

    public static void main(String[] args) {
        // Solo puede ser String
        Data d1 = new Data("This is d1");
        System.out.println(d1);



        // Este permite Objects en general.
        // Sigue sin ser generics y puede dar lugar a errores de ejecución.
        DataObject d2 = new DataObject("This is d2");
        System.out.println(d2);

        DataObject d3 = new DataObject(10);
        // Si ahora me equivoco y pongo por error d2 falla en tiempo de ejecución, pero en tiempo de compilación
        // no me aparece ningún error.
        // int data = (int) (d2.getData());



        // Usando Generics
        // Creamos tipos parametrizados para referenciar tipos de datos genéricos.
        // Estos tipos parametrizados proveen información al compilador de qué tipo es, así que el compilador
        // puede comprobar los tipos
        DataGenerics<String> d4 = new DataGenerics<>("This is d4");
        System.out.println(d4);

        DataGenerics<Integer> d5 = new DataGenerics<>(10);
        // Ahora, si me equivoco al codificar, obtengo un error en tiempo de compilación, puesto que
        // el compilador sabe que d4 es de tipo String y la operación que quiero realizar no es posible.
        //int data2 = (int) (d4.getData());
    }
}
