package atm;

public class CardInsertedState implements ATMState{
    private ATM atm;

    public CardInsertedState(ATM atm) {
        this.atm = atm;
    }

    public void insertCard() {
        System.out.println("You have already inserted a card!");
    }
    public void enterPin(String pin) {
        if(this.atm.isValid(pin)) {
            this.atm.setState(ATMStateFactory.getATMState(atm, ATMStateEnum.REQUESTED_CASH));
        } else {
            System.out.println("Please enter a valid pin!");
        }
    }
    public void requestCash(int amount) {
        System.out.println("Please enter the pin first!");
    }
    public void cancelTransaction() {
        this.atm.setState(ATMStateFactory.getATMState(atm, ATMStateEnum.READY));
    }
}
