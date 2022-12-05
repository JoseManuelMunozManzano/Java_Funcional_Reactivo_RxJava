package com.jmmunoz.dp06_command_design_pattern;

public class DecTempCommand implements ICommandAC {

    AC ac;

    public DecTempCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        System.out.println("Decreasing the temperature");
        ac.decTemp();
    }
}
