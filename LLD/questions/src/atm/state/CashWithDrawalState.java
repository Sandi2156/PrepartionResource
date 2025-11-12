package atm.state;

import atm.ATM;
import atm.processor.CashWithdrawProcessor;
import atm.processor.FiveHundredProcessor;
import atm.processor.OneHundredProcessor;
import atm.processor.TwoThousandProcessor;

public class CashWithDrawalState extends AtmState{
    public CashWithDrawalState(ATM atm) {
        super(atm);
    }

    @Override
    public void withdrawCash(int amount) {
        // TODO: implement chain of responsibility
        CashWithdrawProcessor cashWithdrawProcessor = new TwoThousandProcessor(new FiveHundredProcessor(new OneHundredProcessor(null)));

        if(amount > super.atm.getAtmBalance()) {
            System.out.println("ATM doesn't have enough cash");
            super.atm.setAtmState(super.atm.getCardInsertedState());
            return;
        }

        if(amount > super.atm.getCardBalance()) {
            System.out.println("You don't have enough balance");
            super.atm.setAtmState(super.atm.getCardInsertedState());
            return;
        }

        if(!cashWithdrawProcessor.withdraw(super.atm, amount)) {
            System.out.println("We don't have enough cash count for your amount");
            super.atm.setAtmState(super.atm.getCardInsertedState());
            return;
        }

        super.atm.setAtmState(super.atm.getCardInsertedState());
    }

    @Override
    public void exit() {
        super.atm.setAtmState(super.atm.getIdleState());
    }
}
