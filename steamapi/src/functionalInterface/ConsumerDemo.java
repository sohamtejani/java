package functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {

        // Consumer only accepts something, do not return anything
        Consumer<String> printString = x -> {
            System.out.println("String: "+ x);
        };

        Consumer<Integer> printInteger = System.out::println;

        printString.accept("Soham");
        printInteger.accept(10);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        Consumer<List<Integer>> printList = x -> x.forEach(System.out::println);

        Consumer<List<Integer>> printList2 = l -> l.forEach(ele -> {
            System.out.println(ele);
        });

        Consumer<List<Integer>> printList3 = l -> l.forEach(printInteger);

        printList.accept(list);
        printList2.accept(list);
        printList3.accept(list);

    }
}
