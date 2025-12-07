package stream;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {
        // Collectors is the utility class
        // provide a set of methods to create common collectors

        // 1. Collecting to list
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        List<String> result = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());

        System.out.println(result);

        // 2. Collecting to set

        List<Integer> numbers = Arrays.asList(1,2, 2, 3, 4, 3, 5, 4);

        Set<Integer> set = numbers.stream().collect(Collectors.toSet());
        System.out.println(set);


        // 3. Collecting to a Specific Collection

        ArrayDeque<String> queue = names.stream().collect(Collectors.toCollection(() -> new ArrayDeque<>()));

        // 4. Joining String
        // Concatenate String into single string
        String ans = names.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println(ans);

        // 5. Summarizing Data
        // Generate Statistical summary (count, sum, avg, min, max)

        IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("Count: "+ stats.getCount());
        System.out.println("Sum: "+ stats.getSum());
        System.out.println("Avg: "+ stats.getAverage());
        System.out.println("Min: "+ stats.getMin());
        System.out.println("Max: "+ stats.getMax());

        // 6. Calculating avg
        Double average = numbers.stream().collect(Collectors.averagingDouble(x -> x));

        // 7. Calculating count
        Long count = numbers.stream().collect(Collectors.counting());

        // 8. Grouping Elements by length and store in map
        List<String> words = Arrays.asList("Hello", "World", "Java", "Streams", "Collecting");

        Map<Integer, List<String>> wordsMap = words.stream().collect(Collectors.groupingBy(x -> x.length()));
        System.out.println(wordsMap);

        Map<Integer, String> mapString = words.stream().collect(Collectors.groupingBy(x -> x.length(), Collectors.joining(", ")));
        System.out.println(mapString);

        TreeMap<Integer, Long> treeMap = words.stream().collect(Collectors.groupingBy(x -> x.length(), TreeMap::new, Collectors.counting())); // sort in order of key( length)

        System.out.println(treeMap);

        // 9. Partitioning element
        // Partitions elements into two groups (true or false) based on a predicate

        System.out.println(words.stream().collect(Collectors.partitioningBy(name -> name.length() > 5)));

        // 10. Mapping and collecting
        // Applied mapping before collecting

        List<String> stringList = words.stream().collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.toList()));
        System.out.println(stringList);


        // 11. ToMap()
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");
        Map<String, Integer> fruitLengthMap = fruits.stream().collect(Collectors.toMap(key -> key.toUpperCase(), x -> x.length()));
        System.out.println(fruitLengthMap);

        // 12. toMap() (with merge function)

        List<String> words2 = Arrays.asList("Apple", "Banana", "Apple", "Cherry", "Cherry", "Apple", "Orange");

        Map<String, Integer> fruitToLength = words2.stream().collect(Collectors.toMap(key -> key, v -> 1, (x, y) -> x + y));
        // if any duplicate key comes then, merge function will run (x = old apple count, y = new apple count)

        System.out.println(fruitToLength);


        // Examples:
        // 1. Collecting names by length
        List<String> l1 = Arrays.asList("Anna", "Bob", "Soham", "Charli", "David");

        Map<Integer, List<String>> collect = l1.stream().collect(Collectors.groupingBy(x -> x.length()));

        // Example 2: Counting word occurrence

        String sentence = "hello world hello java world";

        Map<String, Long> collect1 = Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        System.out.println(collect1);
        
        // Example 3: Partitioning by Even and Odd numbers
        List<Integer> l2 = Arrays.asList(1, 2, 3, 4, 5);
        Map<Boolean, List<Integer>> ans2 = l2.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));

        System.out.println(ans2);

        // Example 4: Summing values in map
        Map<String, Integer> items = new HashMap<>();
        items.put("Apple", 10);
        items.put("Banana", 30);
        items.put("Orange", 40);

        Long sum = items.values().stream().collect(Collectors.summingLong(value -> value));

        Optional<Integer> sum2 = items.values().stream().reduce(Integer::sum);
        System.out.println(sum);

        // Example 5: Creating a Map from Stream Elements -> length
        List<String> fruits2 = Arrays.asList("Apple", "Banana", "Cherry");
        Map<String, Integer> fruitLengthMap2 = fruits2.stream().collect(Collectors.toMap(key -> key.toUpperCase(), x -> x.length()));
        System.out.println(fruitLengthMap2);

        // Example 6: use toMap() and count frequency of words
        List<String> words3 = Arrays.asList("Apple", "Banana", "Apple", "Cherry", "Cherry", "Apple", "Orange");

        Map<String, Integer> fruitToLength3 = words2.stream().collect(Collectors.toMap(key -> key, v -> 1, (x, y) -> x + y));
        // if any duplicate key comes then, merge function will run (x = old apple count, y = new apple count)

        System.out.println(fruitToLength3);


    }
}
