package f07_design_patterns.f04_fluent_interfaces;

import f06_functional_programming_in_depth.f05_composition.Function;

import java.util.ArrayList;
import java.util.List;

public class OrderFluent {

    private List<String> cart = new ArrayList<>();
    private String address = "";

    public OrderFluent() {
    }

    public OrderFluent(List<String> cart, String address) {
        this.cart = cart;
        this.address = address;
    }

    public OrderFluent add(String items) {
        cart.add(items);
        System.out.println(items + " added to the cart");
        // Recordar que con FP SIEMPRE se devuelve un nuevo objeto
        return new OrderFluent(this.cart, this.address);
    }

    public OrderFluent deliverAt(String location) {
        this.address = location;
        System.out.println("The delivery address set by you is '" + location + "'");
        return new OrderFluent(this.cart, this.address);
    }

    // Creando OrderFluent en este método
    public static void place(Function<OrderFluent, OrderFluent> function) {
        OrderFluent orderFluent = new OrderFluent();
        orderFluent = function.apply(orderFluent);
        System.out.println("Order placed!");
        System.out.println(orderFluent.cart.size() + " items ordered by you will be delivered at " +
                orderFluent.address + " by tomorrow");
    }
}
