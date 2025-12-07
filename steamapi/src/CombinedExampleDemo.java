import java.util.function.*;

public class CombinedExampleDemo {
    public static void main(String[] args) {
        Predicate<Integer> predicate = x -> x % 2 == 0;
        Function<Integer, Integer> function = x -> x * x;

        Consumer<Integer> consumer = System.out::println;

        Supplier<Integer> supplier = () -> 100;

        if(predicate.test(supplier.get())){
            consumer.accept(function.apply(supplier.get()));
        }

        // BiFUnction, BiConsumer, BiPredicate: takes 2 args

        BiPredicate<Integer, Integer> isSumEven = (a, b) -> (a + b) % 2 == 0;
        BiConsumer<Integer, String> biConsumer = (x, y) -> {
            System.out.println(x);
            System.out.println(y);
        };

        BiFunction<String, String, Integer> biFunction = (x, y) -> x.length() + y.length();

        consumer.accept(biFunction.apply("Soham", "Tejani"));

        // Instead of writing Function<Integer, Integer> a = x -> x * 2;
        UnaryOperator<Integer> a = x -> x * 2;

        BinaryOperator<Integer> b = (x, y) -> x + y; // short form of biFunction

    }
}
