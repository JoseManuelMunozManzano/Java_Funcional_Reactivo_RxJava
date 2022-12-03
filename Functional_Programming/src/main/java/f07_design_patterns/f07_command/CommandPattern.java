package f07_design_patterns.f07_command;

// Command Design Pattern es un patrón de comportamiento que consiste en encapsular una petición como un objeto.
// Así que en este patrón escribimos código que secuencia y ejecuta métodos basados en decisiones en tiempo de
// ejecución (o comandos)
//
// Como ejemplo tenemos la implementación de la interface Runnable, ya que cada implementación que pasamos al runnable
// es un comando diferente en el que los métodos de runnable se ejecutan.
//
// Podemos decir que este patrón es una forma de encapsular una petición como un objeto, parametrizar clientes con
// diferentes peticiones y realizar las correspondientes operaciones.
public class CommandPattern {

    public static void main(String[] args) {
        AC ac1 = new AC();
        AC ac2 = new AC();

        ACAutomationRemote remote = new ACAutomationRemote();
        remote.setCommand(() -> ac2.turnOn());
        remote.buttonPressed();
    }
}
