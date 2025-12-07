package mathodReference;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        // Method reference -> Use method without invoking & in place of lambda expression
        List<String> students = Arrays.asList("Ram", "Shyam", "Ghanshyam");

        students.forEach(x -> System.out.println(x)); // it is lambda function
        students.forEach(System.out::println); // It is method reference only (using method without invoking)

        // Instead of lambda expression we can use method reference (without invoking)

        // Constructor reference
        List<String> names = Arrays.asList("A", "B", "C");

        List <MobilePhone> phones = names.stream().map(x -> new MobilePhone(x)).toList();
        List<MobilePhone> phone2 = names.stream().map(MobilePhone::new).toList(); // Constructor reference


    }
}

class MobilePhone {
    String name;

    public MobilePhone(String name){
        this.name = name;
    }
}