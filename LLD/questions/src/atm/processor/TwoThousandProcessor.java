package atm.processor;

import atm.ATM;

public class TwoThousandProcessor extends CashWithdrawProcessor{
    public TwoThousandProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        super(nextCashWithdrawProcessor);
    }

    @Override
    public boolean withdraw(ATM atm, int amount) {
        int notesCount = atm.getTwoThousandNotesCount();
        int denomination = 2000;

        if(notesCount * denomination < amount) return false;
        if(notesCount * denomination == amount) {
            atm.deductTwoThousandNotesCount(notesCount);
            return true;
        }

        int usedNoteCount = amount / denomination;
        atm.deductTwoThousandNotesCount(usedNoteCount);

        int remainingAmount = amount - (usedNoteCount * denomination);

        if(remainingAmount == 0) return true;

        boolean isSuccessful = super.withdraw(atm, remainingAmount);

        if(isSuccessful) return true;
        else {
            atm.deductTwoThousandNotesCount(-usedNoteCount);
            return false;
        }
    }
}
