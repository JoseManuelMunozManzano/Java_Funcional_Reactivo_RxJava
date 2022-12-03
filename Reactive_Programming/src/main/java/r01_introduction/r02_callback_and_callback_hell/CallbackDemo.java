package r01_introduction.r02_callback_and_callback_hell;

public class CallbackDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thread is running");

        // Callback hell: Difícil de saber qué se está ejecutando.
        // RxJava lo soluciona trabajando con el patrón de diseño Observer
        Runnable r = new Runnable() {
            @Override
            public void run() {
                new CallbackDemo().runningAsync(new Callback() {
                    @Override
                    public void call() {
                        System.out.println("Callback Called!");
                    }
                });
            }
        };

        Thread t = new Thread(r);
        t.start();

        Thread.sleep(2000);

        System.out.println("Main Thread Completed!");
    }

    public void runningAsync(Callback callback) {
        System.out.println("I am running on a separate thread");
        sleep(1000);
        callback.call();
    }

    private void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
