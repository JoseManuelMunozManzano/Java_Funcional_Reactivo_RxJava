package f01_Lambda_and_functional_interface.f03_lambdas_under_hood;

public class LambdaUnderHood {
    public static void main(String[] args) {
        // Para cada clase interna anónima necesitaría una implementación diferente
        // Para ejecutar cada una de estas implementaciones tengo que invocar cada uno de los métodos.
        //
        // Esto en sí no está mal, pero si buscamos los ficheros generados veremos que hay 2, uno por cada
        // clase interna (LambdaUnderHood$1.class y LambdaUnderHood$2.class)
        // Es decir, con clases anónimas hay problemas en el envío de código y nuestro fichero jar o war será más
        // pesado.
        MyFunInterface fun1 = new MyFunInterface() {
            @Override
            public void myMethod() {
                System.out.println("Implementation 1");
            }
        };

        MyFunInterface fun2 = new MyFunInterface() {
            @Override
            public void myMethod() {
                System.out.println("Implementation 2");
            }
        };

        // Usando lambdas
        // No se genera byte code para la clase interna cuando se usa lambdas
        // Cómo se llama a una lambda a bajo nivel?
        // Si utilizamos el comando javap -c fichero.class veremos // InvokeDynamic
        // Desde Java7 la JVM utiliza InvokeDynamic. Son instrucciones bytecode que facilitan la implementación de
        // lenguajes dinámicos mediante invocación de método dinámica.
        // Entonces, la implementación de myMethod() no existe en tiempo de compilación, sino en tiempo de ejecución,
        // que la proporcionamos usando lambda. Utilizan inferencia de tipos y funcionalidad InvokeDynamic.
        // Así que además de reducir la longitud del código a programar, también ayuda a optimizar la memoria.
        MyFunInterface fun = () -> System.out.println("I am light weight");
    }
}
