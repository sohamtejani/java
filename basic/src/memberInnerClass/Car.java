package memberInnerClass;

public class Car {
    private String model;
    private double price;
    private boolean isEngineStart;

    public Car(String model, double price){
        this.model = model;
        this.price = price;
        this.isEngineStart = false;
    }

    // There is HAS-A relation between Car and Engine.
    // Engine can not exist independently without Car. (Composition)

    // Engine inner class can access all private members of the Car.
    class Engine{
        void start(){
            if(!isEngineStart){
                isEngineStart = true;
                System.out.println(model + " engine started.");
            }else{
                System.out.println(model + " engine is already on.");
            }
        }
        void stop(){
            if(isEngineStart){
                isEngineStart = false;
                System.out.println(model + " engine stopped.");
            }else{
                System.out.println(model + " engine is already off.");
            }
        }
    }
}

// We can also do below
// But have to pass Car instance in Engine
//
// class Car {
//     private String model;
//     private double price;
//     private boolean isEngineStart;
//
//     public Car(String model, double price) {
//         this.model = model;
//         this.price = price;
//         this.isEngineStart = false;
//     }
//
//     public double getPrice() {
//         return price;
//     }
//
//     public void setPrice(double price) {
//         this.price = price;
//     }
//
//     public boolean isEngineStart() {
//         return isEngineStart;
//     }
//
//     public void setEngineStart(boolean engineStart) {
//         isEngineStart = engineStart;
//     }
//
//     public String getModel() {
//         return model;
//     }
//
//     public void setModel(String model) {
//         this.model = model;
//     }
// }
//
// class Engine{
//     private Car car;
//
//     Engine(Car car){
//         this.car = car;
//     }
//
//     void start(){
//            if(!car.isEngineStart()){
//                 car.setEngineStart(true);
//                System.out.println(car.getModel() + " engine started.");
//            }else{
//                System.out.println(car.getModel() + " engine is already on.");
//            }
//        }
//        void stop(){
//            if(car.isEngineStart()){
//                car.setEngineStart(false);
//                System.out.println(car.getModel() + " engine stopped.");
//            }else{
//                System.out.println(car.getModel() + " engine is already off.");
//            }
//        }
// }