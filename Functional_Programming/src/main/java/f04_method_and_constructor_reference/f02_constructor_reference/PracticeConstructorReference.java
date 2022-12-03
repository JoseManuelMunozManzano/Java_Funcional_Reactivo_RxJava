package f04_method_and_constructor_reference.f02_constructor_reference;

import java.util.function.Function;

public class PracticeConstructorReference {

    public static void main(String[] args) {
        // Hay cuatro tipos de method reference
        //   1   object :: instanceMethod
        //   2   Class :: staticMethod
        //   3   Class :: instanceMethod
        //   4   Class :: new

        // 4
        // También llamado constructor reference
        // Devuelve un nuevo objeto.
        // Se usa para evitar tener que repetir la implementación en distintas partes del programa.

        // Ejemplo en el que queremos ejecutar tareas paralelamente. Para ello necesitamos Threads.
        // Vamos a generar funciones dados unos Runnables nos generen Threads

        // El lambda sería
        // Function<Runnable, Thread> threadGenerator =  r -> new Thread(r);
        // Y podemos sustituirlo por el siguiente constructor reference
        Function<Runnable, Thread> threadGenerator =  Thread::new;

        // Runnable es también un @FunctionalInterface con el método abstracto: void run();
        // Esta lambda es un ejemplo que no puede convertirse a method reference.
        Runnable task1 = () -> System.out.println("Task 1 executed");
        Runnable task2 = () -> System.out.println("Task 2 executed");

        // Creando los threads
        Thread thread1 = threadGenerator.apply(task1);
        Thread thread2 = threadGenerator.apply(task2);

        // Invocando el método run()
        thread1.start();
        thread2.start();

        // El código de arriba puede escribirse de forma más compacta, quedando más tipo programación funcional
        threadGenerator
                .apply(() -> System.out.println("Task 3 executed"))
                .start();
    }
}
