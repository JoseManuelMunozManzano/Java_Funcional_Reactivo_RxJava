package f01_Lambda_and_functional_interface.f01_first_lambda_with_multithreading;

public class F02_BeforeLambda {
    public static void main(String[] args) {
        // Antes de Java 8, para suministrar un método de implementación se usaban clases anónimas.
        // Esto es lo más parecido a un lambda que había antes, pero tampoco son lambdas.
        // No es tanto código, pero... esto es lo mejor que hay?
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Executed as anonymous function!");
            }
        });
        t.start();
    }
}
