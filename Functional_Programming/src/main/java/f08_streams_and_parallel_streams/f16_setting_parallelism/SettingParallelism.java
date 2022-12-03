package f08_streams_and_parallel_streams.f16_setting_parallelism;

import f08_streams_and_parallel_streams.f14_parallel_streams.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class SettingParallelism {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Fork Join Pool es un pool de hilos especial que es usado por todas las operaciones en stream paralelos.
        // Toman todos los procesadores disponibles por defecto.

        // Podemos saber la cantidad de procesadores disponibles en el sistema con el siguiente objeto Runtime
        System.out.println(Runtime.getRuntime().availableProcessors());

        // Estableciendo una propiedad podemos indicar la cantidad de procesadores que puede usar Fork Join Pool.
        // Podemos indicar una cantidad de procesadores mayor a la que tenemos realmente, pero esto puede dar lugar
        // a problemas de rendimiento.
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");
        System.out.println(ForkJoinPool.getCommonPoolParallelism());

        // Indicar que un procesador se usa para ejecutar el hilo principal, el hilo main()

        // Podemos crear nuestro propio ForkJoinPool para ejecutar tareas
        // En este caso tomamos 2 hilos
        ForkJoinPool pool = new ForkJoinPool(2);

        List<Employee> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(new Employee("John", 20000));
            list.add(new Employee("Rohn", 3000));
            list.add(new Employee("Tom", 15000));
            list.add(new Employee("Bheem", 8000));
            list.add(new Employee("Shiva", 200));
            list.add(new Employee("Krishna", 50000));
        }

        // Usamos el método submit() para someter las tareas. Toma un callable, que es un Functional Interface como
        // el Runnable, con la diferencia que Runnable no devuelve nada y callable puede devolver algo.
        // Un callable tiene el método call que no toma nada y devuelve algo.
        Long count = pool.submit(() ->
                list.parallelStream()
                        .filter(e -> e.getSalary() > 1000)
                        .count()).get();

        System.out.println(count);

        // Cómo sabemos que número de hilos que poner?
        // Si el trabajo es computacionalmente intensivo el número de hilos debe ser menor o igual que el número de
        // cores
        // Si el trabajo es IO intensivo, es decir, operaciones sobre ficheros, sobre BBDD, llamadas HTTP, el número
        // de hilos puede ser mayor que el número de cores.
    }
}
