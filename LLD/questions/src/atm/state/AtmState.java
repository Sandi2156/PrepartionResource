package atm.state;

import atm.ATM;

public abstract class AtmState {
    protected ATM atm;

    public AtmState(ATM atm) {
        this.atm = atm;
    }

    public void insertCard() {
        System.out.println("This Operation doesn't exist in this state");
    }

    public void enterPin(int pin) {
        System.out.println("This Operation doesn't exist in this state");
    }

    public void selectOperation(int operationNo) {
        System.out.println("This Operation doesn't exist in this state");
    }

    public void checkAmount() {
        System.out.println("This Operation doesn't exist in this state");
    }

    public void withdrawCash(int amount) {
        System.out.println("This Operation doesn't exist in this state");
    }

    public void exit() {
        System.out.println("This Operation doesn't exist in this state");
    }
}
