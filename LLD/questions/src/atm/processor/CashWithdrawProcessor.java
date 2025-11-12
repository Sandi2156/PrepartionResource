package atm.processor;

import atm.ATM;

public abstract class CashWithdrawProcessor {
    private CashWithdrawProcessor nextWithdrawProcessor;

    public CashWithdrawProcessor(CashWithdrawProcessor nextWithdrawProcessor) {
        this.nextWithdrawProcessor = nextWithdrawProcessor;
    }

    public boolean withdraw(ATM atm, int amount) {
        if(nextWithdrawProcessor == null) {
            return false;
        }

        return nextWithdrawProcessor.withdraw(atm, amount);
    }
}
