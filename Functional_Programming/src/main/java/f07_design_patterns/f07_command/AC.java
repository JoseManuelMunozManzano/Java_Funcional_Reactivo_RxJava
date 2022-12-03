package f07_design_patterns.f07_command;

// En la implementación imperativa necesitaríamos clases concretas por cada una de estas posibles peticiones.
// Con lambdas se pueden sustituir todas esas clases de comandos por estos métodos de comandos.
public class AC {

    public void turnOn() {
        System.out.println("turning on AC");
    }

    public void turnOff() {
        System.out.println("turning off AC");
    }

    public void incTemp() {
        System.out.println("increasing temperature");
    }

    public void decTemp() {
        System.out.println("decreasing temperature");
    }
}
