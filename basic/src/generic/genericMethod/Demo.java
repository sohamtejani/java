package generic.genericMethod;

public class Demo {
    public static void main(String[] args) {

        Box box = new Box();
        Integer[] intArr = {1, 2, 3, 4, 5} ;
        String[] strArr = {"Soham", "Veer"} ;

        box.printArray(intArr);
        box.printArray(strArr);

        box.display("Sitaram");
        box.display(10);
        box.display(10L);
        box.display(10.0);
    }
}
