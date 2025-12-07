package generic.wildcard;

import java.util.ArrayList;
import java.util.List;

public class Box {

    public <T> T getFirst(ArrayList<T> list){
        return list.getFirst();
    }

    public <T> void getFirst(ArrayList<T> source, ArrayList<T> destination) {
        for(T item: source){
            destination.add(item);
        }
    }

    // Wildcard '?' is used to denote unknown type.
    // we use '?' if we are doing readonly operation and we are not returning.

    // Upper bound is Number.
    // b/c All subclass of Number will be accepted
    public static double sum(List<? extends Number> numbers){
        double sum = 0;
        for(Number n : numbers){
            sum += n.doubleValue();
        }
        return sum;
    }

    // Lower bound is Number.
    // b/c All super class of Integer will be accepted
    public static void printNumbers(List<? super Integer> list){
        for(Object o : list){
            System.out.println(o);
        }
    }

}
