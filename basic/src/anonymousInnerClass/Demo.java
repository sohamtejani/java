package anonymousInnerClass;

public class Demo {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart(150);

        CreditCard creditCard = new CreditCard( "14324535");
        shoppingCart.processPayment(creditCard);

        ShoppingCart shoppingCart2 = new ShoppingCart(200);

        shoppingCart2.processPayment(new Payment() {
            @Override
            public void pay(double amount) {
                System.out.println("Paid: "+ amount +" using credit card");
            }
        });

        // When we wanted to create interface without creating it's separate implementation
        // then we use anonymous inner class.
    }
}
