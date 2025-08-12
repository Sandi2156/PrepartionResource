/*
 * It allows objects with incompatible interfaces to work together by converting one interface into another
 * that the client expects.
 * 
 * 
 * Components
 * Target - The interface your app expects
 * Adaptee - The existing class with different inerface
 * Adapter - Translates Adaptee into Target
 * Client - Code using the Target interface
 * 
 */

// Target
interface PaymentProcessor {
    public void makePayment(double amount);
}

// Adaptee
class RazorpayGateway {
    public void sendPayment(double amount) {
        System.out.println("Sending payment through razorpay gateway - " + amount);
    }
}

class PaypalGateway {
    public void initializePayment(double amount) {
        System.out.println("Sending payment through paypal gateway - " + amount);
    }
}

// Adapter
class RazorpayAdapter implements PaymentProcessor {
    private RazorpayGateway razorpay = new RazorpayGateway();

    @Override
    public void makePayment(double amount) {
        razorpay.sendPayment(amount);
    }
}

class PaypalAdapter implements PaymentProcessor {
    private PaypalGateway paypal = new PaypalGateway();

    @Override
    public void makePayment(double amount) {
        paypal.initializePayment(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentProcessor razorpay = new RazorpayAdapter();
        razorpay.makePayment(12.40);

        PaymentProcessor paypal = new PaypalAdapter();
        paypal.makePayment(90.00);
    }
}
