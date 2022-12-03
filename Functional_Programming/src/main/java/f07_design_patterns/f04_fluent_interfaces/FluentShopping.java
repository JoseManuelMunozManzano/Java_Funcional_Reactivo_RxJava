package f07_design_patterns.f04_fluent_interfaces;

// Fluent Interface es una forma de implementación por la que obtenemos una interface de fácil lectura y fluida, que
//    normalmente imita un lenguaje específico de dominio. Usando este patrón resulta un código que puede leerse
//    muy parecido al lenguaje humano.
//
// Se usa mucho este patrón en el API Stream de Java 8 en el que se invocan métodos en cascada.
public class FluentShopping {

    public static void main(String[] args) {
        // Secuencia de operaciones una tras otra sin implementar Fluent Interface
        Order myOrder = new Order();
        myOrder.add("Shoes");
        myOrder.add("Headphones");
        myOrder.deliverAt("Street nº 45, Madrid");

        myOrder.place();

        System.out.println(" ---------------------------------- ");

        // Usando chaining para implementar Fluent Interface
        // No hace falta ni crear el objeto porque ya lo hace el método estático place()
        OrderFluent.place(orderFluent ->
                        orderFluent.add("IPhone 14")
                                .add("Logitech Mouse")
                                .deliverAt("Street nº 20, Almería")
                );
    }
}
