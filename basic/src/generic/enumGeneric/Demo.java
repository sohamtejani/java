package generic.enumGeneric;

enum Day{
    SUNDAY, MONDAY, TUESEDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURRDAY
}
enum Operation{
    ADD, SUBTRACT, MULTIPLY, DIVIDE;

    public <T extends Number> double apply(T a, T b){
        switch (this){
            case ADD:
                return a.doubleValue() + b.doubleValue();
            case SUBTRACT:
                return a.doubleValue() - b.doubleValue();
            case MULTIPLY:
                return a.doubleValue() * b.doubleValue();
            case DIVIDE:
                return a.doubleValue() / b.doubleValue();
            default:
                throw new AssertionError("Unknown operation: "+ this);
        }
    }
}

public class Demo {
    public static void main(String[] args) {
        Day day = Day.MONDAY;
//        Day day1 = "MONDAY"; already type safe

        System.out.println(Operation.ADD.apply(10, 20));
        System.out.println(Operation.MULTIPLY.apply(10, 20));
    }
}
