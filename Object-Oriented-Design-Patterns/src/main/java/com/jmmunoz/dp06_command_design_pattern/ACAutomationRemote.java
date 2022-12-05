package com.jmmunoz.dp06_command_design_pattern;

// Invoker
public class ACAutomationRemote {
    ICommandAC command;

    public void setCommand(ICommandAC command) {
        this.command = command;
    }

    public void buttonPressed() {
        command.execute();
    }
}
