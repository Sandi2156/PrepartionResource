package atm;

public interface ATMState {
    public void insertCard();
    public void enterPin(String pin);
    public void requestCash(int amount);
    public void cancelTransaction();
}
