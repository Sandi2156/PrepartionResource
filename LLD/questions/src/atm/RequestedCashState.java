package atm;

public class RequestedCashState implements ATMState{
    private ATM atm;

    public RequestedCashState(ATM atm) {
        this.atm = atm;
    }

    public void insertCard() {
        System.out.println("You have already inserted the card!");
    }

    public void enterPin(String pin) {
        System.out.println("You have already entered the pin!");
    }

    public void requestCash(int amount) {
        if(!this.atm.canWithdraw(amount)) {
            System.out.println("This much amount can not be withdrawn. Please enter a valid amount!");
            return;
        }

        this.atm.withdrawCash(amount);
        System.out.println("Dispensing the amount");
    }

    public void cancelTransaction() {
        this.atm.setState(ATMStateFactory.getATMState(atm, ATMStateEnum.READY));
    }
}
