package atm.state;

import atm.ATM;

public class CardInsertedState extends AtmState{

    private boolean pinEntered = false;

    public CardInsertedState(ATM atm) {
        super(atm);
    }

    @Override
    public void enterPin(int pin) {
        System.out.println("Pin entered");
        pinEntered = true;

        // validate pin
    }

    @Override
    public void selectOperation(int operationNo) {
        if(!pinEntered) {
            System.out.println("Please enter your pin first");
            return;
        }

        switch(operationNo) {
            case 1:
                System.out.println("Check Amount - operation is selected");
                super.atm.setAtmState(super.atm.getAmountCheckState());
                return;
            case 2:
                System.out.println("Cash Withdrawal - operation is selected");
                super.atm.setAtmState(super.atm.getCashWithDrawalState());
                return;
            default:
                System.out.println("Wrong Operation selected");
        }
    }

    @Override
    public void exit() {
        super.atm.setAtmState(super.atm.getIdleState());
    }
}
