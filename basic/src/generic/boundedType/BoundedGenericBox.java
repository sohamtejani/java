package generic.boundedType;

public class BoundedGenericBox<T extends Number> {
    private T value;

    public T getValue(){
        return this.value;
    }
    public void setValue(T value){
        this.value = value;
    }
}
