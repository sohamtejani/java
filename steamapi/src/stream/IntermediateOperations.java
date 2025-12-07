package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperations {
    public static void main(String[] args) {
        // Intermediate operation transforms a stream into another stream
        // They are lazy, mean they don't execute until a terminal operation is invoked.


        //1. Filter

        List<String> list = Arrays.asList("Soham", "Ram", "Shyam", "Ghanshyam", "Soham", "Shyam");

        Stream<String> filteredStream = list.stream().filter(name -> name.startsWith("S")); // It will not filter at this point
        // This will not be executed until terminal operation is not applied!

        long res = filteredStream.count();
        System.out.println(res);

        //2. Map
        Stream<String> stringStream = list.stream().map(name -> name.toUpperCase());
        Stream<String> stringStream2 = list.stream().map(String::toUpperCase);

        stringStream2.limit(2).forEach(System.out::print);

        // 3. sorted
        Stream<String> sortedStream = list.stream().sorted();
        Stream<String> sortedStreamUsingComparator = list.stream().sorted((a, b) -> a.length() - b.length());

        sortedStreamUsingComparator.forEach(name -> System.out.print(name + " "));

        // 4. distinct
        System.out.println();

        list.stream().filter(x -> x.startsWith("S")).distinct().forEach(System.out::println);
        System.out.println(list.stream().filter(x -> x.startsWith("S")).distinct().count());

        // 7. skip
        Stream.iterate(1, x -> x + 1).skip(10).limit(20).forEach(System.out::println);
        System.out.println(Stream.iterate(1, x -> x + 1).skip(10).limit(20).count());

        // 9. flatMap
        // Handles Streams of collections, lists or arrays where each element is itself a collection
        // Flatten nested structures (e.g lists within lists)
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "kiwi"),
                Arrays.asList("pear", "grape")

        );

        System.out.println(listOfLists.stream().flatMap(x -> x.stream()).map(String::toUpperCase).toList());

        List<String> sentences = Arrays.asList(
                "Hello world",
                "Java streams are powerful",
                "flatMap is useful"
        );
        System.out.println(sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" "))).map(String::toUpperCase).toList());

    }
}
