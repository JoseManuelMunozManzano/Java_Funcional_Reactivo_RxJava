package com.jmmunoz.dp06_command_design_pattern;

public class StartACCommand implements ICommandAC {

    AC ac;

    public StartACCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        System.out.println("Turning on the AC");
        ac.turnOn();
    }
}
