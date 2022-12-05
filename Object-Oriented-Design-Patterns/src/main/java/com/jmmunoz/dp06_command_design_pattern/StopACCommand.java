package com.jmmunoz.dp06_command_design_pattern;

public class StopACCommand implements ICommandAC {

    AC ac;

    public StopACCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        System.out.println("Turning off the AC");
        ac.turnOff();
    }
}
