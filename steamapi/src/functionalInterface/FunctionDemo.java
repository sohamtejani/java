package functionalInterface;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {

        // predicate hold the condition only

        // Function takes 1 param & return 1 param

        Function<Integer, Integer> doubleIt = x -> 2 * x;
        Function<Integer, Integer> tripleIt = x -> 3 * x;

        System.out.println(doubleIt.apply(100));
        System.out.println(tripleIt.apply(100));

        Function<Integer, Integer> doubleThenTriple = doubleIt.andThen(tripleIt);
        Function<Integer, Integer> tripleThenDouble = doubleIt.compose(tripleIt);

        System.out.println(doubleThenTriple.apply(20));
        System.out.println(tripleThenDouble.apply(20));

        Function<Integer, Integer> identity = Function.identity();

        Integer res = identity.apply(5);
        System.out.println(res);

    }
}
