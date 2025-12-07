package memberInnerClass;

public class InnerClassDemo {
    public static void main(String[] args) {
        Car car = new Car("Creta", 1200000);

        Car.Engine engine = car.new Engine();

        engine.start();
        engine.stop();
    }
}
