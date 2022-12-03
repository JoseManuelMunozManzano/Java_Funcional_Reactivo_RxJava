package f02_practice_lambda_with_different_signatures.f03_practice_lambda_03;

public class ParametersAndReturnType {

    public static void main(String[] args) {
        // El compilador también puede adivinar la palabra clave return y se puede obviar.
        LengthOfString len = (str) -> str.length();

        int length = len.length("Hoy hace buen día");
        System.out.println(length);
    }
}
