package functionalInterface;

import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        // Supplier will not tack anything, it will return only
        // Used do task like: Make connection with db
        // No default methods

        Supplier<String> giveHelloWorld = () -> "Hello world";

        System.out.println(giveHelloWorld.get());
    }
}
