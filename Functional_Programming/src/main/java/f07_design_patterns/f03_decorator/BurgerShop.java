package f07_design_patterns.f03_decorator;

import f06_functional_programming_in_depth.f05_composition.Function;

// Clase que añade los decorators
public class BurgerShop {

    Function<Burger, Burger> decoration;

    // Decide que decoration aplicar a la baseBurger
    public BurgerShop(Function<Burger, Burger> decoration) {
        this.decoration = decoration;
    }

    public Burger use(Burger baseBurger) {
        System.out.println("Base Burger : " + baseBurger);
        return decoration.apply(baseBurger);
    }
}
