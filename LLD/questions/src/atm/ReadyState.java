package atm;

public class ReadyState implements ATMState{
    private ATM atm;

    public ReadyState(ATM atm) {
        this.atm = atm;
    }

    public void insertCard() {
        System.out.println("Card is Inserted!");
        this.atm.setState(ATMStateFactory.getATMState(atm, ATMStateEnum.CARD_INSERTED));
    }
    public void enterPin(String pin) {
        System.out.println("Please insert a card first!");
    }
    public void requestCash(int amount) {
        System.out.println("Please insert a card first!");
    }
    public void cancelTransaction() {
        System.out.println("Please insert a card first!");
    }
}
