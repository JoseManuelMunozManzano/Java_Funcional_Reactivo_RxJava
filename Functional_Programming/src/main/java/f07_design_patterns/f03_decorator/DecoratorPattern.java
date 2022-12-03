package f07_design_patterns.f03_decorator;

// Decorator Design Pattern se usa para modificar la funcionalidad de un objeto en tiempo de ejecución sin afectar
//      otras instancias de la misma clase.
// Es decir, tenemos una especie de wrappers funcionales y envolvemos ese objeto en esos wrappers en función
// de las funcionalidades que queremos.
// Para cada nueva funcionalidad es necesaria una nueva clase.
//
// Para qué queremos este patrón? Con herencia y composición podemos modificar el comportamiento de un objeto, pero
// el problema de este enfoque es que se hace en tiempo de compilación. Con ellas no se puede añadir ni eliminar
// funcionalidades en tiempo de ejecución. Para eso se usa el patrón Decorator.
public class DecoratorPattern {

    public static void main(String[] args) {
        Burger myOrder = new BurgerShop(burger -> burger.addCheese())
                .use(new BurgerShop(burger -> burger.addVeggies()).use(new Burger()));
        System.out.println("I get" + myOrder);
    }
}
