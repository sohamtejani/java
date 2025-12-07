package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveStreams {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(numbers);

        Integer[] numbers1 = {1, 2, 3, 4, 5};
        Stream<Integer> stream1= Arrays.stream(numbers1);

        List<Integer> list = IntStream.range(1, 5).boxed().collect(Collectors.toList());
        System.out.println(list);

        IntStream.of(1, 2, 3);

        DoubleStream doubleStream = new Random().doubles(5);
        System.out.println(doubleStream.boxed().toList());


    }
}
