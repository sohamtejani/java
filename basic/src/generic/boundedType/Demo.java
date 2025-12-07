package generic.boundedType;

public class Demo {
    public static void main(String[] args) {
        BoundedGenericBox<Float> floatBoundedGenericBox = new BoundedGenericBox<>();
        floatBoundedGenericBox.setValue(12.56f);
        System.out.println(floatBoundedGenericBox.getValue());


        // BoundedGenericBox<String> stringBoundedGenericBox = new BoundedGenericBox<>(); // wrong (Compile time error)



    }
}
