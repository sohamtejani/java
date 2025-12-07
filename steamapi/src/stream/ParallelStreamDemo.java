 package stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class ParallelStreamDemo {
    public static void main(String[] args) {

        // A type of stream that enables parallel processing of elements
        // Allowing multiple threads to process parts of the stream simultaneously
        // This can significantly improve performance for large data sets

        // sequential stream

        List<Integer> list = Stream.iterate(1, (x -> x + 1)).limit(20).toList();
        long startTime = System.currentTimeMillis();
        List<Long> factorialList = list.stream().map(ParallelStreamDemo::factorial).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with sequential streams: "+ (endTime - startTime) + " ms");

        // parallel stream

        startTime = System.currentTimeMillis();
        List<Long> factorialList2 = list.parallelStream().map(ParallelStreamDemo::factorial).toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with parallel streams: "+ (endTime - startTime) + " ms");

        // Parallel stream are most effective for CPU-intensive or large dataset where task are INDEPENDENT.
        // They may add overload for simple tasks or small datasets


        // Cumulative Sum
        // [1, 2, 3, 4, 5] --> [1, 3, 6, 10, 15] (current sum is dependent on prev sum)
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        // int sum = 0; non-final variable can not use inside the streams (b/c it should be thread safe)
        AtomicInteger sum = new AtomicInteger(0);

        List<Integer>cumulativeSum = nums.parallelStream().map(x -> sum.getAndAdd(x)).toList();

        System.out.println("Actual cumulative sum with parallel stream: "+ cumulativeSum);
        System.out.println("Expected cumulative sum: [1, 3, 6, 10, 15]");

        // After doing parallel operation, if we want sequential operation then:
        Stream<Long> factorialList3 = list.parallelStream().map(ParallelStreamDemo::factorial).sequential();

        AtomicLong sum2 = new AtomicLong(0);
        List<Long> cumulativeSum2 = factorialList3.map(x -> sum2.getAndAdd(x)).toList();
        System.out.println(cumulativeSum2);


        // Pick - intermediate operator (We can use another terminal operator after forEach)
        // forEach - terminal operator (We can not use another terminal operator after forEach)

        Long size = Stream.iterate(1, (x -> x + 1)).skip(10).limit(100).peek(System.out::println).count();



    }

    private static long factorial(int n){
        long result = 1;
        for(int i = 2; i <= n; i++){
            result *= i;
        }
        return result;
    }
}
