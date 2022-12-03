package f01_Lambda_and_functional_interface.f01_first_lambda_with_multithreading;

public class F03_Lambda {
    public static void main(String[] args) {
        // Apenas hay código y se hace lo mismo que en los ejemplos sin lambdas.
        // Indicar que solo se pueden convertir a lambdas interfaces que tiene UN SOLO METODO ABSTRACTO.
        // Así no hay ambigüedad sobre cuál es el nombre de la función.
        Thread t = new Thread(() -> System.out.println("Thread Executed using lambdas!"));
        t.start();
    }
}
