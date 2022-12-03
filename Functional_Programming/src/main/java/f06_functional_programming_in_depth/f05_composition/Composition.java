package f06_functional_programming_in_depth.f05_composition;

// Composition: sigue una dirección inversa a chaining. La segunda función se ejecuta primero y luego la primera
//  función se aplica al resultado devuelto por la segunda.
public class Composition {

    public static void main(String[] args) {

        Function<Square, Integer> fun1 = s -> s.getArea();      // return area
        Function<Integer, Double> fun2 = area -> Math.sqrt(area);       //return length of one side

        Function<Square, Double> getSide = fun2.compose(fun1);

        Square s = new Square();
        s.setArea(100);

        Double side = getSide.apply(s);
        System.out.println(side);
    }
}
