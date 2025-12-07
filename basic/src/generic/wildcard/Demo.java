package generic.wildcard;

import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Box box = new Box();

        List<? extends Number> list = Arrays.asList(1, 2.3, 4, 6);

        System.out.println(Box.sum(list));
    }
}
