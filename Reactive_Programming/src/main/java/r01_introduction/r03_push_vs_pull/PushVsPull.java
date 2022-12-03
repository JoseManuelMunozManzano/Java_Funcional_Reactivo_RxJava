package r01_introduction.r03_push_vs_pull;

import r01_introduction.r02_callback_and_callback_hell.CallbackDemo;

// RxJava está basado en el patrón de diseño Observer
// Vamos a ver que es el modelo Push y Pull
//
// El modelo petición - respuesta está basado en un modelo basado en la extracción (pull based) en el que
// un servidor envía una respuesta tras procesar una petición.
//
// Pero en RxJava to-do es basado en empuje (push based)
// También se puede conseguir un modelo push based con callbacks, pero RxJava lo consigue usando Observables.
public class PushVsPull {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thread is running");

        // Callback hell: Difícil de saber qué se está ejecutando.
        // RxJava lo soluciona trabajando con el patrón de diseño Observer
        Runnable r = new Runnable() {
            @Override
            public void run() {
                new PushVsPull().runningAsync(new CallBack() {
                    @Override
                    public void pushData(String data) {
                        System.out.println("Callback data: " + data);
                    }

                    @Override
                    public void pushComplete() {
                        System.out.println("Callback done!");
                    }

                    @Override
                    public void pushError(Exception e) {
                        System.out.println("Callback Error called, Got an Exception: " + e);
                    }
                });
            }
        };

        Thread t = new Thread(r);
        t.start();

        Thread.sleep(2000);

        System.out.println("Main Thread Completed!");
    }

    public void runningAsync(CallBack callback) {
        System.out.println("I am running on a separate thread");
        sleep(1000);
        // Esto es el push
        callback.pushData("Data1");
        callback.pushData("Data2");
        callback.pushData("Data3");

        callback.pushError(new RuntimeException("Oops!"));
        callback.pushComplete();
    }

    private void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
