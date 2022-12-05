package com.jmmunoz.dp02_strategy_design_pattern;

public class CompressedToRar implements Strategy {

    @Override
    public void compressFile(String fileName) {
        System.out.println(fileName + " has been successfully converted to .rar file.");
    }
}
