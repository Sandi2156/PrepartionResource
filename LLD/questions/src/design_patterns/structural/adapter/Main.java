package design_patterns.structural.adapter;

// Adaptees
class Stripe {
    public void makeTransaction(double amount) {
        System.out.println("Stripe: Made a payment of " + amount);
    }
}

class Paypal {
    public void processPayment(double amount) {
        System.out.println("Paypal: Made a payment of " + amount);
    }
}

// Target interface
interface IPayment {
    public void makePayment(double amount);
}

// Adapters
class StripePaymentAdapter implements IPayment {
    private final Stripe stripe = new Stripe();

    public void makePayment(double amount) {
        stripe.makeTransaction(amount);
    }
}

class PaypalPaymentAdapter implements IPayment {
    private final Paypal paypal = new Paypal();

    public void makePayment(double amount) {
        paypal.processPayment(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        IPayment stripe = new StripePaymentAdapter();
        IPayment paypal = new PaypalPaymentAdapter();

        stripe.makePayment(900);
        paypal.makePayment(900);
    }
}
