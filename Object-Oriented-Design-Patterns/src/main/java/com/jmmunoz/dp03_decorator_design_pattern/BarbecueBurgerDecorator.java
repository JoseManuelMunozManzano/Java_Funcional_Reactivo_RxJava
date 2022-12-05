package com.jmmunoz.dp03_decorator_design_pattern;

public class BarbecueBurgerDecorator extends BurgerDecorator {

    public BarbecueBurgerDecorator(Burger burger) {
        super(burger);
    }

    @Override
    public void makeBurger() {
        burger.makeBurger();
        System.out.println(", vegetables and cheese added.");
    }
}
