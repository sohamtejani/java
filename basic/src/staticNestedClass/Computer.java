package staticNestedClass;

public class Computer {
    private String brand;

    private String model;

    private OperatingSystem os;

    public Computer(String osName, String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.os = new OperatingSystem(osName);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public OperatingSystem getOs() {
        return os;
    }

    public void setOs(OperatingSystem os) {
        this.os = os;
    }

    // Since USB type will be constant TYPE-C, the USB can be shared between all computers.
    // Memory will be saved for USB
    static class USB{
        private String type;

        public USB(String type) {
            this.type = type;
        }
        public void displayInfo(){
            System.out.println("USB type: "+ type);
        }
    }
    class OperatingSystem{
        private String osName;

        public OperatingSystem(String osName) {
            this.osName = osName;
        }

        public String getOsName() {
            return osName;
        }

        public void setOsName(String osName) {
            this.osName = osName;
        }
        public void displayInfo(){
            System.out.println("Computer model: "+ model + " ,os: "+ osName);
        }
    }
}
