package com.jmmunoz.dp03_decorator_design_pattern;

// Es un patrón estructural
// Nos permite añadir nuevas características a un objeto existente sin cambiar su estructura.
// Esto se consigue utilizando clases abstractas o interfaces, usando Composition para implementar el
// envoltorio (Decorator)
//
// Se usa para modificar la funcionalidad de un objeto en tiempo de ejecución.
// A la vez, otros objetos de esa clase pueden no estar afectados por esta nueva funcionalidad.
// Es decir, afecta a objetos individuales.
//
// Cuando usar el patrón Decorator:
//  - Para añadir responsabilidades a objetos individuales dinámica y transparentemente, es decir, sin afectar
//      a otros objetos
//  - Para responsabilidades que no se pueden retirar.
//  - Cuando extender la sub-clase no es práctico. A veces es posible una cantidad muy grande de extensiones
//      independientes que produciría una explosión de subclases para soportar cada combinación. O una definición
//      de clase puede estar oculta o no disponible para hacer la sub-clase.
//
// JDK implementa el patrón Decorator en:
//  java.io.BufferedInputStream(InputStream)
//  java.ioDataInputStream(InputStream)
//  java.io.BufferedOutputStream(OutputStream)
//  java.util.zip.ZipOutputStream(OutputStream
//  java.util.Collections#checked[List|Map|Set|SortedSet|SortedMap]()
public class Main {

    public static void main(String[] args) {

        Burger burger = new PlainBurger();
        burger.makeBurger();

        new CheeseBurgerDecorator(burger).makeBurger();

        new BarbecueBurgerDecorator(burger).makeBurger();
    }
}
