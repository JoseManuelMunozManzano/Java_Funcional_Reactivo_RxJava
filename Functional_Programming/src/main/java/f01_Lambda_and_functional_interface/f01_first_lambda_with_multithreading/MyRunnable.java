package f01_Lambda_and_functional_interface.f01_first_lambda_with_multithreading;

// Demasiado código solo para crear un runnable
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread Executed!");
    }
}
