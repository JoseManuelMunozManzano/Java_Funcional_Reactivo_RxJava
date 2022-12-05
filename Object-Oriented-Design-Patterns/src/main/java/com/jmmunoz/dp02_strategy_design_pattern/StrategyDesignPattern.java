package com.jmmunoz.dp02_strategy_design_pattern;

// El patrón Strategy es un patrón de comportamiento.
// Se usa cuando tenemos muchos algoritmos o implementaciones para solucionar una tarea específica y en tiempo
// de ejecución, dinámicamente, el cliente decide cuál de las implementaciones usará.
//
// Este patrón sugiere que cada una de las implementaciones esté en una clase separada, y es a cada clase separada
// a lo que se le llama Strategy Object.
// Y al objeto que acaba utilizando los distintos strategies se le llama Context Object.
//
// Cuando usar este patrón:
// - Muchas clases relacionadas difieren solo en su comportamiento. Las estrategias proveen una forma de
//      configurar una clase con uno o muchos comportamientos.
// - Se necesitan diferentes variantes de un algoritmo. Por ejemplo, se podrían definir algoritmos que reflejen
//      diferentes concesiones espacio/tiempo.
// - Las estrategias pueden usarse cuando estas variantes están implementadas como una jerarquía de clase de
//      algoritmos.
// - Un algoritmo usa data sobre la que los clientes no deben conocer nada. Usar el patrón Strategy para evitar
//      exponer estructuras de datos complejas de un algoritmo.
// - Una clase define muchos comportamientos, y estos aparecen como muchas sentencias condicionales en sus
//      operaciones. En vez de tantos condicionales, moverlos a su propia clase Strategy.
//
// JDK implementa el patrón Strategy en:
//  java.util.Comparator#compare()
//  javax.servlet.http.HttpServlet
//  javax.servlet.Filter#doFilter()
public class StrategyDesignPattern {

    public static void main(String[] args) {

        Context con = new Context();
        con.setCompressionStrategy(new CompressedToRar());
        con.generateFile("Abc.text");

    }
}
