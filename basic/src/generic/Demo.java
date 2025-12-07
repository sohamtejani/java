package generic;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Soham");
        list.add(12);

        String str = (String)list.get(0);
//        String str2 = (String)list.get(1); // Runtime exception (Integer can't be cast to String)


        Box box = new Box();
        box.setValue("str");

        // Integer i = (Integer) box.getValue(); // Runtime exception while casting

        // To solve:
        // Type safety
        // Manual casting
        // Compile time checking

        // GENETIC IS INTRODUCED in Java 5

        ArrayList<String> list2 = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        String s = list2.get(0);
        String s1 = list2.get(1);


        GenericBox<Integer> genericBox = new GenericBox<>();

        genericBox.setValue(1);
        // genericBox.setValue("str"); Compile time error

        int t = genericBox.getValue();
        System.out.println(t);


    }
}
