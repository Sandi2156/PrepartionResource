package atm;

import atm.state.*;

public class ATM {
    private AtmState atmState = new IdleState(this);
    private DebitCard card;
    private int atmBalance;
    private AtmState idleState, cardInsertedState, amountCheckState, cashWithDrawalState;

    private int oneHundredNotesCount = 0;
    private int fiveHundredNotesCount = 0;
    private int twoThousandNotesCount = 0;

    public ATM(int atmBalance, int oneHundredNotesCount, int fiveHundredNotesCount, int twoThousandNotesCount) {
        this.atmBalance = atmBalance;

        this.idleState = new IdleState(this);
        this.cardInsertedState = new CardInsertedState(this);
        this.amountCheckState = new AmountCheckState(this);
        this.cashWithDrawalState = new CashWithDrawalState(this);

        this.oneHundredNotesCount = oneHundredNotesCount;
        this.fiveHundredNotesCount = fiveHundredNotesCount;
        this.twoThousandNotesCount = twoThousandNotesCount;
    }

    public int getFiveHundredNotesCount() {
        return fiveHundredNotesCount;
    }

    public void deductFiveHundredNotesCount(int count) {
        this.fiveHundredNotesCount -= count;
    }

    public int getTwoThousandNotesCount() {
        return twoThousandNotesCount;
    }

    public void deductTwoThousandNotesCount(int count) {
        this.twoThousandNotesCount -= count;
    }

    public int getOneHundredNotesCount() {
        return oneHundredNotesCount;
    }

    public void deductOneHundredNotesCount(int count) {
        this.oneHundredNotesCount -= count;
    }

    public void setAtmState(AtmState atmState) {
        this.atmState = atmState;
    }

    public int getCardBalance() {
        return card.getAmount();
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void deductMoneyFromCard(int amount) {
        card.deduct(amount);
    }

    public void deductMoneyFromAtm(int amount) {
        if(atmBalance < amount) {
            System.out.println("ATM doesn't have enough money");
            return;
        }

        atmBalance -= amount;
    }

    public void insertCard(DebitCard card) {
        this.card = card;
        atmState.insertCard();
    }

    public void enterPin(int pin) {
        atmState.enterPin(pin);
    }

    public void selectOperation(int operationNo) {
        atmState.selectOperation(operationNo);
    }

    public void checkAmount() {
        atmState.checkAmount();
    }

    public void withdrawCash(int amount) {
        atmState.withdrawCash(amount);
    }

    public void exit() {
        atmState.exit();

        this.card = null;
        this.idleState = new IdleState(this);
        this.cardInsertedState = new CardInsertedState(this);
        this.amountCheckState = new AmountCheckState(this);
        this.cashWithDrawalState = new CashWithDrawalState(this);
    }

    public AtmState getIdleState() {
        return idleState;
    }

    public AtmState getCardInsertedState() {
        return cardInsertedState;
    }

    public AtmState getAmountCheckState() {
        return amountCheckState;
    }

    public AtmState getCashWithDrawalState() {
        return cashWithDrawalState;
    }

    public void checkATM() {
        System.out.println("ATM has " + this.atmBalance + " amount left.");
        System.out.println(
                "2000 notes - " + this.twoThousandNotesCount + "\n"
                + "500 notes - " + this.fiveHundredNotesCount + "\n"
                + "100 notes - " + this.oneHundredNotesCount
        );
    }
}
