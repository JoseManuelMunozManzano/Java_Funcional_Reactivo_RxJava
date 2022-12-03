package f02_practice_lambda_with_different_signatures.f04_practice_lambda_04;

public class MultipleStatements {

    public static void main(String[] args) {
        // Si hay más de una línea no se pueden obviar las llaves ni el return
        LengthOfString len = str -> {
            int l = str.length();
            System.out.println("The length of the given String is " + l);
            return l;
        };

        int length = len.length("Ayer fue viernes");
        System.out.println(length);
    }
}
