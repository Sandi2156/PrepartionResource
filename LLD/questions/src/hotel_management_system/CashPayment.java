package hotel_management_system;

public class CashPayment implements PaymentStrategy {
    public void makePayment(double amount) {
        System.out.println("Cash payment done!");
    }
}
