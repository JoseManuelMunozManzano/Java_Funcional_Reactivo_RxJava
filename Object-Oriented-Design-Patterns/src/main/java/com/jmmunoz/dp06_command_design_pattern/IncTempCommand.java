package com.jmmunoz.dp06_command_design_pattern;

public class IncTempCommand implements ICommandAC {

    AC ac;

    public IncTempCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        System.out.println("Increasing the temperature");
        ac.incTemp();
    }
}
