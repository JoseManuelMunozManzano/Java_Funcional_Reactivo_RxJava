package com.jmmunoz.dp03_decorator_design_pattern;

public class CheeseBurgerDecorator extends BurgerDecorator {

    public CheeseBurgerDecorator(Burger burger) {
        super(burger);
    }

    @Override
    public void makeBurger() {
        burger.makeBurger();
        System.out.println(", cheese added.");
    }
}
