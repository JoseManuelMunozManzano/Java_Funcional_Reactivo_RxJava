package f06_functional_programming_in_depth.f06_closures;

// Una closure es una función que se refiere a variables libres (identificador usado, pero no definido por el closure)
// en su contexto léxico (convención que establece el scope de una variable para que solo pueda ser llamada
// en ese bloque en el que está definido)
//
// En nuestro código, si pasamos funciones de un sitio a otro tendremos que tratar con closures.
public class JavaClosure {

    public static void main(String[] args) {
        // Variable libre
        int val = 111;

        // Si se cambia aquí la variable val entonces de nuevo la variable no es final y no se puede usar en la
        // lambda
        //val = 112;

        Task lambda = () -> {
            // Una variable local definida en un scope cerrado debe ser final o efectivamente final.
            // Es decir, cambiar aquí la variable no es posible
            //val = 112;
            System.out.println(val);
            System.out.println("Task Completed!");
        };

        printValue(lambda);
    }

    private static void printValue(Task lambda) {
        // JRE hace un seguimiento del valor val = 111
        lambda.doTask();
    }

}
