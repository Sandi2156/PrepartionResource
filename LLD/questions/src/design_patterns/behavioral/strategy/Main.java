package design_patterns.behavioral.strategy;

// Strategy Interface
interface PaymentStrategy {
    public void pay(double amount);
}

// concrete classes
class Paypal implements PaymentStrategy {
    private String accountId;

    public Paypal(String accountId) {
        this.accountId = accountId;
    }

    public void pay(double amount) {
        System.out.println("Paypal: Payment is done of amount " + amount + ", from account id: " + accountId + ".");
    }
}

class Gpay implements PaymentStrategy {
    private String phoneNo;

    public Gpay(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void pay(double amount) {
        System.out.println("Google Pay: Payment is done of amount " + amount + ", from phone no: " + phoneNo + ".");
    }
}

// payment context
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment(double amount) {
        if(paymentStrategy == null) return;
        paymentStrategy.pay(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        paymentContext.setPaymentStrategy(new Paypal("alsjfl808sdf"));
        paymentContext.makePayment(908);

        paymentContext.setPaymentStrategy(new Gpay("+917477763024"));
        paymentContext.makePayment(9834);
    }
}
