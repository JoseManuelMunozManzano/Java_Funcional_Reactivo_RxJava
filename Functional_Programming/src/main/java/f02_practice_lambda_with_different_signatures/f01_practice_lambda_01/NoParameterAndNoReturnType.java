package f02_practice_lambda_with_different_signatures.f01_practice_lambda_01;

public class NoParameterAndNoReturnType {
    public static void main(String[] args) {
        Name name = () -> System.out.println("José Manuel");
        name.myName();
    }
}
