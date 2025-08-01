package atm;

public class ATMStateFactory {
    public static ATMState getATMState(ATM atm, ATMStateEnum state) {
        switch(state) {
            case READY:
                return new ReadyState(atm);
            case CARD_INSERTED:
                return new CardInsertedState(atm);
            case REQUESTED_CASH:
                return new RequestedCashState(atm);
            default:
                System.out.println("This state is not valid!");
                return null;
        }
    }
}
