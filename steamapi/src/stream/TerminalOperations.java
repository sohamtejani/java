package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TerminalOperations {
    public static void main(String[] args) {
        // Terminal operations
        // Streams can not be reused after terminal operation is called

        // 1. collect
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        list.stream().skip(1).collect(Collectors.toList());
        list.stream().skip(1).toList();

        // 2. forEach
        list.forEach(x -> System.out.println(x));

        // 3. reduce: Combines elements to produce single result (BinaryOperator = short form of BiFunction)

        Optional<Integer> optionalInt = list.stream().reduce((x, y) -> x + y);
        Optional<Integer> optionalIntSum = list.stream().reduce(Integer::sum);

        System.out.println(optionalInt.get());
        System.out.println(optionalIntSum.get());

        // 4. count

        // 5. anyMatch, allMatch, nonMatch (short circuit operations -> as soon as criteria match, they stop operating further)
        boolean b = list.stream().anyMatch(x -> x % 2 == 0);
        System.out.println(b);

        boolean b2 = list.stream().allMatch(x -> x > 0);
        System.out.println(b2);

        boolean b3 = list.stream().noneMatch(x -> x < 0);
        System.out.println(b3);

        // 6. findFirst, findAny (short circuit operations)
        System.out.println(list.stream().findFirst().get());
        System.out.println(list.stream().findAny().get());


        // 7. toArray()

        Object[] array = Stream.of(1, 2, 3).toArray(); // Convert Stream to Array


        // 8. min, max
        System.out.println("max: "+ Stream.of(1, 3, 6, 2, 5).max(Comparator.naturalOrder()).get());
        System.out.println("min: "+ Stream.of(1, 3, 6, 2, 5).min(Comparator.naturalOrder()).get());

        System.out.println("min: "+ Stream.of(1, 3, 6, 2, 5).min((o1, o2) -> o1 - o2).get());


        // 9. forEachOrdered
        // If we use forEach for parallel stream then o/p will not be in ordered.
        // To maintain order, use forEachOrder while using parallel streams.


        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Using forEach with parallel stream:");
        nums.parallelStream().forEach(System.out::println);

        System.out.println("Using forEachOrdered with parallel stream:");
        nums.parallelStream().forEachOrdered(System.out::println);


        // Examples
        // find names whose length > 3

        List<String> names = Arrays.asList("Soham", "Veer", "Bob", "Varad");

        System.out.println(names.stream().filter(name -> name.length() > 3).toList());

        // Squaring then sorting
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 6);

        System.out.println(numbers.stream().map((num) -> num * num).sorted().toList());

        // Sum of all
        Optional<Integer> ans = numbers.stream().reduce((x, y) -> x + y);
        System.out.println(ans.get());

        // Count occurrence of a character in string
        String str = "Hello World";

        IntStream charStream =str.chars(); // stream of ascii int
        System.out.println(charStream.filter(ch -> ch == 'l').count());

        // stateful & stateless operations

        // map, filters are stateless operations
        // sort, distinct are stateful operations (need to have idea of other elements while processing)

    }
}
