package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        // Stream
        // process collections of data in functional and declarative manner
        // Simplifying Data Processing
        // Readability and Maintainability
        // Enable Easy Parallelism


        // Streams: Through stream, Collection can be converted into stream and we can use Functional & declarative programming.
        // How to use Streams?
        // Source, intermediate operations & terminal operation


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int count = 0;
        for(int i: numbers){
            if(i % 2 == 0){
                count++;
            }
        }
        System.out.println(count);

        Stream<Integer> steam = numbers.stream();
        long evenNoCount = numbers.stream().filter(x -> x % 2 == 0).count();
        System.out.println(evenNoCount);

        // Creating Streams
        // 1. From Collections
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();

        // 2. From Array
        String[] arrays = {"a", "b", "c"};
        Stream<String> stream2 = Arrays.stream(arrays);

        // 3. Using Stream.of()
        Stream<String> stream3 = Stream.of("a", "b");

        // 4. Infinite Stream
        // Stream<Integer> generate = Stream.generate(() -> 1); // infinite stream
        Stream<Integer> generate2 = Stream.generate(() -> 1).limit(100); // 100 size steam

        // 5.
        Stream.iterate(0, x -> x + 1).limit(100).forEach(x -> System.out.print(x + " ")); // start from 0, next no will be 0 + 1 => 1, so on... [0, 1, 2, 3, 4, ...]


    }
}
