package f01_Lambda_and_functional_interface.f04_imperative_vs_declarative;

import java.util.stream.IntStream;

public class ImperativeVsDeclarative {
    public static void main(String[] args) {

        // Programación Imperativa
        // La de toda la vida.
        int sumOfEvens = 0;

        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                sumOfEvens += i;
            }
        }

        System.out.println(sumOfEvens);

        // Programación Declarativa o Funcional
        // La programación funcional es un subset de la programación declarativa.
        // Como SQL se indican expresiones en vez de sentencias y se indica qué hacer en vez de como hacerlo.
        // Es, por tanto, más concisa y fácil de leer que la programación imperativa,
        // Además, no se muta ninguna variable por lo que es Thread Safe y
        // este código trabaja muy bien con entornos multi hilo donde hay muchos procesos.
        sumOfEvens = IntStream.rangeClosed(0, 100)
                .filter(i -> i % 2 == 0)
                .reduce((x, y) -> x + y)
                .getAsInt();

        System.out.println(sumOfEvens);

    }
}
