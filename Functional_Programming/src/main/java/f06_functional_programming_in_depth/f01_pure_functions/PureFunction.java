package f06_functional_programming_in_depth.f01_pure_functions;

// Pure Function
//  1. La salida de una función pura depende solo de sus parámetros de entrada y de su algoritmo interno.
//  Es decir, dada un entrada SIEMPRE produce la misma salida.
//
//  2. Una función pura NO tiene efectos colaterales, es decir, no lee nada ni escribe nada de fuera.
//  Un efecto colateral es cualquier cosa que no sea computar y devolver un valor.
//
// La Programación Funcional prefiere trabajar con funciones puras porque permite:
// - Claridad
// - Fácil de comprenderlas
// - Nunca modifican el estado o variables que se pasan como argumento. Se pueden usar sin problemas en programas
//   multihilo.
public class PureFunction {

    public int sum(int a, int b) {
        return a + b;
    }
}
