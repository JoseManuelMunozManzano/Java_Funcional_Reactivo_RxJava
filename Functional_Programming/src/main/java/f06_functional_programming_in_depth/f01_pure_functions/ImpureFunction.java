package f06_functional_programming_in_depth.f01_pure_functions;

public class ImpureFunction {

    private int value = 0;

    // Es impura porque tiene el efecto colateral de cambiar value, que esta fuera de la función.
    public int add(int nextValue) {
        this.value += nextValue;
        return this.value;
    }
}
