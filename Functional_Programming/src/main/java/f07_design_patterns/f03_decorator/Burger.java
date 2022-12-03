package f07_design_patterns.f03_decorator;

public class Burger {

    private String burgerType;

    public Burger() {
        this.burgerType = "";
    }

    private Burger(String type) {
        this.burgerType = type;
    }

    // Dos ejemplos de Decorator en FP
    // En FP no creamos clases para cada funcionalidad individual, sino que se añaden todos los métodos en una clase.
    // Se devuelve una nueva instancia de Burger porque en FP NO se modifica el estado del objeto.
    // Esta nueva instancia hace parecer que hemos modificado el objeto.
    public Burger addVeggies() {
        System.out.println("Adding veggies to the burger");
        return new Burger(this.burgerType += " Veggie");
    }

    public Burger addCheese() {
        System.out.println("Adding cheese to the burger");
        return new Burger(this.burgerType += " Cheese");
    }

    @Override
    public String toString() {
        return String.format("%s", burgerType + " burger");
    }
}
