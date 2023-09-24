interface MyInterface {
    void doSomething();

    default int add(int a, int b) {
        return a + b;
    }
}

public class Main2 {
    public static void main(String[] args) {
        MyInterface myLambda = () -> {
            System.out.println("Doing something...");
            int result=10;
            System.out.println("Result: " + result);
        };

        myLambda.doSomething();
    }
}