package generic.genericMethod;

public class Box {
    public <T> void printArray(T[] parameter){
        for (T element: parameter){
            System.out.println("element: "+ element);
        }
        System.out.println();
    }

    // Method overloading
    public <T> void display(T element){
        System.out.println("Generic display: "+ element);
    }
    public void display(Integer element){
        System.out.println("Integer display: "+ element);
    }
    public void display(String element){
        System.out.println("String display: "+ element);
    }
}
