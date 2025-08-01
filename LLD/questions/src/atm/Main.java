package atm;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();

        atm.requestCash(10);
        atm.enterPin("8907");

        atm.insertCard();
        atm.enterPin("8976");
        atm.requestCash(908);
    }
}
