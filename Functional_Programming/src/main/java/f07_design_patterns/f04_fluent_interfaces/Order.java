package f07_design_patterns.f04_fluent_interfaces;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<String> cart = new ArrayList<>();
    private String address = "";

    public void add(String items) {
        cart.add(items);
        System.out.println(items + " added to the cart");
    }

    public void deliverAt(String location) {
        this.address = location;
        System.out.println("The delivery address set by you is '" + location + "'");
    }

    public void place() {
        System.out.println("Order placed!");
        System.out.println(this.cart.size() + " items ordered by you will be delivered at " + this.address + " by tomorrow");
    }
}
