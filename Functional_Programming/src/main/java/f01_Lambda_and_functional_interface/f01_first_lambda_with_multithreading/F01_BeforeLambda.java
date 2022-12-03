package f01_Lambda_and_functional_interface.f01_first_lambda_with_multithreading;

public class F01_BeforeLambda {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        // Se le pasa a la creación del Thread el runnable.
        // Demasiado código para lo que es realmente.
        Thread t = new Thread(runnable);
        t.start();
    }
}
