package atm.state;

import atm.ATM;

public class AmountCheckState extends AtmState{
    public AmountCheckState(ATM atm) {
        super(atm);
    }

    @Override
    public void checkAmount() {
        System.out.println("You have " + super.atm.getCardBalance() + " left in your bank.");

        super.atm.setAtmState(super.atm.getCardInsertedState());
    }

    @Override
    public void exit() {
        super.atm.setAtmState(super.atm.getIdleState());
    }
}
