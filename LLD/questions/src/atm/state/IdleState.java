package atm.state;

import atm.ATM;

public class IdleState extends AtmState{

    public IdleState(ATM atm) {
        super(atm);
    }

    @Override
    public void insertCard() {
        System.out.println("Card inserted in the atm");

        super.atm.setAtmState(super.atm.getCardInsertedState());
    }
}
