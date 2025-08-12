package hotel_management_system;

public class UPIPayment implements PaymentStrategy{
    public void makePayment(double amount) {
        System.out.println("UPI Payment done!");
    }
}
