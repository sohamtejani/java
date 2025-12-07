package functionalInterface;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        // Predicate is functional interface (Boolean valued function)
        // Predicate only have 1 abstract method, other methods are default method and static methods

        Predicate<Integer> isEven = x -> x % 2 == 0;
        Predicate<String> isWordStartWithA = x -> x.toLowerCase().startsWith("A");
        Predicate<String> isWordEndWithT = x -> x.toLowerCase().endsWith("T");

        Predicate<String> isStartAndEndWithA = isWordEndWithT.and(isWordStartWithA);

        System.out.println("isEven: "+ isEven.test(4));
        System.out.println("isWordStartWithA: "+ isWordStartWithA.test("Ankit"));
        System.out.println("isStartAndEndWithA: " + isStartAndEndWithA.test("Ankit"));
    }
}
