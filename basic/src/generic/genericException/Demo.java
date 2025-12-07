package generic.genericException;

public class Demo {
    public static void main(String[] args) {

        try{
            throw new MyException(123);
        }catch (MyException exception){
            System.out.println(exception.toString());
            System.out.println();
            exception.printStackTrace();
        }

        try{
            throw new MyException("Something went wrong");
        }catch (MyException exception){
            System.out.println(exception.toString());
            System.out.println();
            exception.printStackTrace();
        }


    }
}

class MyException extends Exception{
    public <T> MyException(T value){
        super("Exception related to value: "+ value.toString() +
                " of type: "+ value.getClass().getName());
    }
}
// we can not define Generic <T> at class level due to erasion.
// but we can definitely define at constructor level