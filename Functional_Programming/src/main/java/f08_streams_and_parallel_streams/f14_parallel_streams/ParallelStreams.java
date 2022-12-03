package f08_streams_and_parallel_streams.f14_parallel_streams;

import java.util.ArrayList;
import java.util.List;

public class ParallelStreams {

    // Con Streams paralelos se puede ejecutar el código más rápido sin ningún esfuerzo, aprovechando la ventaja
    // del procesamiento multi-nucleo
    public static void main(String[] args) {
        long startTime;
        long endTime;

        // Hay dos formas de procesar con streams:
        // 1. Secuencial (por defecto) Son los stream que hemos visto hasta ahora stream()
        // 2. En paralelo. Se usa el método parallelStream() o stream.parallel()

        List<Employee> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(new Employee("John", 20000));
            list.add(new Employee("Rohn", 3000));
            list.add(new Employee("Tom", 15000));
            list.add(new Employee("Bheem", 8000));
            list.add(new Employee("Shiva", 200));
            list.add(new Employee("Krishna", 50000));
        }

        // Stream secuencial
        startTime = System.currentTimeMillis();
        System.out.println("Performing Sequentially: " + list.stream()
                .filter(e -> e.getSalary() > 1000)
                .count());
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with Sequential: " + (endTime - startTime));

        // Stream paralelo
        startTime = System.currentTimeMillis();
        System.out.println("Performing Parallely: " + list.parallelStream()
                .filter(e -> e.getSalary() > 1000)
                .count());
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with Parallel: " + (endTime - startTime));

        // Decidir cuando se usa paralelismo no es fácil porque el paralelismo también es tiene implicaciones
        // como que la salida tras el procesamiento debe ser el mismo que con el procesamiento secuencial.
        // Para que esto no sea un problema y se pueda aplicar paralelismo con garantías, el stream debe ser:
        // 1. Sin estado.
        // 2. Sin interferencias, es decir, la data no debe ser afectada durante la operación.
        // 3. Asociativo, es decir, al resultado de una operación no debe afectarle el orden de la data a procesar.

        // Los streams paralelos están construidos sobre un framework multihilo (ForkJoinPool), así que no deberíamos
        // tener ningún problema de sincronización ni de visibilidad. Esto se evita fácilmente si no se cambia el
        // estado del objeto en el pipeline.

        // La ejecución en paralelo no siempre es más rápida que la ejecución secuencial. Es mucho más compleja.
        // Por tanto, hay que identificar cuando la ejecución secuencial tarda mucho en ejecutarse y medir si
        // el paralelismo realmente puede ayudar.
    }
}
