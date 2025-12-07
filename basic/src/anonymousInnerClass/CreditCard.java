package anonymousInnerClass;

public class CreditCard implements Payment{

    private String creditCardNumber;

    public CreditCard(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid: "+ amount +" using credit card");
    }
}
