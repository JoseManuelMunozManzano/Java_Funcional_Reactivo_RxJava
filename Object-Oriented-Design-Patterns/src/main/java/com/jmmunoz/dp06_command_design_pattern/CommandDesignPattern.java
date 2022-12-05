package com.jmmunoz.dp06_command_design_pattern;

// Es un patrón de comportamiento
// En el patrón Command un objeto se usa para encapsular toda la información, como el nombre del método, objeto
// que posee el método y valores para los parámetros del método necesarios para ejecutar una acción.
//
// En el patrón Command hay los siguientes términos básicos:
//  Command Interface
//  Concrete command classes
//  Invoker
//  Receiver
//
// Cuando usar el patrón Command:
//  - Cuando queremos poder parametrizar objetos por su acción a realizar.
//  - Cuando necesitamos especificar, encolar y ejecutar peticiones en momentos diferentes.
//  - Cuando una configuración de cambios en la data necesitan ser encapsulados como una acción única, por
//      ejemplo, una transacción.
//
// JDK usa el patrón Command en:
//  java.lang.Runnable
//  javax.swing.Action
public class CommandDesignPattern {

    public static void main(String[] args) {

        AC acRoomOne = new AC();
        AC acRoomTwo = new AC();

        ACAutomationRemote remote = new ACAutomationRemote();

        remote.setCommand(new StartACCommand(acRoomOne));
        remote.buttonPressed();

        remote.setCommand(new StartACCommand(acRoomTwo));
        remote.buttonPressed();

        remote.setCommand(new IncTempCommand(acRoomTwo));
        remote.buttonPressed();
    }
}
