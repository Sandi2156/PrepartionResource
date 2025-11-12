package atm.processor;

import atm.ATM;

public class FiveHundredProcessor extends CashWithdrawProcessor{
    public FiveHundredProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        super(nextCashWithdrawProcessor);
    }

    @Override
    public boolean withdraw(ATM atm, int amount) {
        int notesCount = atm.getFiveHundredNotesCount();
        int denomination = 500;

        if(notesCount * denomination < amount) return false;
        if(notesCount * denomination == amount) {
            atm.deductFiveHundredNotesCount(notesCount);
            return true;
        }

        int usedNoteCount = amount / denomination;
        atm.deductFiveHundredNotesCount(usedNoteCount);

        int remainingAmount = amount - (usedNoteCount * denomination);

        if(remainingAmount == 0) return true;

        boolean isSuccessful = super.withdraw(atm, remainingAmount);

        if(isSuccessful) return true;
        else {
            atm.deductFiveHundredNotesCount(-usedNoteCount);
            return false;
        }
    }
}
