package f06_functional_programming_in_depth.f08_tail_call_optimization;

// Tail Call Recursion o Tail Call Optimization (TCO)
public class TailCallOptimization {

    public static void main(String[] args) {

    }

    // Código recursivo normal
    // Se queda en la pila porque hay operaciones a realizarse.
    public static long reFact(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * reFact(n - 1);
    }

    // Código Tail Recursion
    // La variable accumulator empieza en 1 y la condición base, en vez de devolver el primer valor con el que
    // empieza a ejecutarse la recursión, devuelve el valor ya calculado, el acumulado.
    // No se guarda nada en la pila.
    // El compilador puede, por tanto, transformar Tail Recursion en una iteración pura.
    // Por desgracia, algunos compiladores no soportan Tail Call Optimization, entre ellos el compilador de Java, y
    // no puede convertir llamadas recursivas en iteraciones.
    // Por tanto, a nivel de compilador no obtenemos este beneficio.
    public static long tailReFact(int n, int accumulator) {
        if (n <= 1) {
            return accumulator;
        }

        return tailReFact(n - 1, n * accumulator);
    }
}
