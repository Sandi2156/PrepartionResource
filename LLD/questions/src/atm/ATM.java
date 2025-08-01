package atm;

public class ATM {
    private ATMState atmState;

    public ATM() {
        this.atmState = ATMStateFactory.getATMState(this, ATMStateEnum.READY);
    }

    public void setState(ATMState atmState) {
        this.atmState = atmState;
    }

    public boolean canWithdraw(int amount) {
        // this will also call db to validate the pin
        return true;
    }

    public void withdrawCash(int amount) {
        // this will call db repository to deduct the amount from the bank
    }




    public boolean isValid(String pin) {
        return true;
    }

    public void insertCard() {
        this.atmState.insertCard();
    }

    public void enterPin(String pin) {
        this.atmState.enterPin(pin);
    }

    public void cancelTransaction() {
        this.atmState.cancelTransaction();
    }

    public void requestCash(int amount) {
        this.atmState.requestCash(amount);
    }

}
