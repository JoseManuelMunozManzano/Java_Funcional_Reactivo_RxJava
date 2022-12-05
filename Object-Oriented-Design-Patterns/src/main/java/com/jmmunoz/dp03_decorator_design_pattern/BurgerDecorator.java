package com.jmmunoz.dp03_decorator_design_pattern;

abstract class BurgerDecorator extends PlainBurger {

    protected Burger burger;

    public BurgerDecorator(Burger burger) {
        this.burger = burger;
    }

    public void makeBurger() {
        burger.makeBurger();
    }
}
