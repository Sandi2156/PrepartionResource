package atm;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM(10000, 100, 50, 50);

        DebitCard card = new DebitCard(100000);

        atm.insertCard(card);
        atm.enterPin(123);

        atm.selectOperation(1);
        atm.checkAmount();

//        atm.enterPin(123);
        atm.selectOperation(2);
        atm.withdrawCash(5001);

//        atm.enterPin(123);
        atm.selectOperation(1);
        atm.checkAmount();

        atm.checkATM();
    }
}
