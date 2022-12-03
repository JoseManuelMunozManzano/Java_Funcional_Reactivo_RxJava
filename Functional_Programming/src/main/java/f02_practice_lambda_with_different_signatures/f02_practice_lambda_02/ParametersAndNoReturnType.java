package f02_practice_lambda_with_different_signatures.f02_practice_lambda_02;

public class ParametersAndNoReturnType {
    public static void main(String[] args) {
        // Los tipos de los argumentos no hace falta informarlos porque el compilador los obtiene por inferencia
        MathOperation add = (a, b) -> System.out.println(a + b);
        add.operation(10, 20);

        // Se puede usar la misma MathOperation para distintas operaciones
        MathOperation multipy = (a, b) -> System.out.println(a * b);
        multipy.operation(10, 20);
    }
}
