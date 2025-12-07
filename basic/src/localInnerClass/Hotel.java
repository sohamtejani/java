package localInnerClass;

public class Hotel {
    private String name;
    private int totalRooms;
    private int reservedRooms;

    public Hotel(String name, int totalRooms, int reservedRooms){
        this.name = name;
        this.reservedRooms = reservedRooms;
        this.totalRooms = totalRooms;
    }

    public void reserveRoom(String guestName, int numOfRooms){
        // Since validation is tightly coupled with this class,
        // and to encapsulate validation logic, we have used local inner class
        class ReservationValidator{
            boolean validate(){
                if(guestName == null || guestName.isBlank()){
                    System.out.println("Guest name can not be empty");
                    return false;
                }
                if(numOfRooms < 0){
                    System.out.println("Num of rooms should be positive");
                    return false;
                }
                if(reservedRooms + numOfRooms > totalRooms){
                    System.out.println("Not enough rooms available");
                    return false;
                }
                return true;
            }
        }

        ReservationValidator validator = new ReservationValidator();
        if(validator.validate()){
            reservedRooms += numOfRooms;
            System.out.println("Reservation confirmed for "+ guestName + " for " + numOfRooms + " rooms");
        }else{
            System.out.println("Reservation failed");
        }
    }
}
