package atm.processor;

import atm.ATM;

public class OneHundredProcessor extends CashWithdrawProcessor{
    public OneHundredProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        super(nextCashWithdrawProcessor);
    }

    @Override
    public boolean withdraw(ATM atm, int amount) {
        int notesCount = atm.getOneHundredNotesCount();
        int denomination = 100;

        if(notesCount * denomination < amount) return false;
        if(notesCount * denomination == amount) {
            atm.deductOneHundredNotesCount(notesCount);
            return true;
        }

        int usedNoteCount = amount / denomination;
        atm.deductOneHundredNotesCount(usedNoteCount);

        int remainingAmount = amount - (usedNoteCount * denomination);

        if(remainingAmount == 0) return true;

        boolean isSuccessful = super.withdraw(atm, remainingAmount);

        if(isSuccessful) return true;
        else {
            atm.deductOneHundredNotesCount(-usedNoteCount);
            return false;
        }
    }
}
