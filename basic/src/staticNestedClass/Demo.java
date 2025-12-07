package staticNestedClass;

public class Demo {
    public static void main(String[] args) {
        Computer computer = new Computer("ABC", "Hp", "Zbook");

        computer.getOs().displayInfo();

        Computer.USB usb = new Computer.USB("TYPE-C");
    }
}
