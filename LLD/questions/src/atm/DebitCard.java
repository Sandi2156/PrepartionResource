package atm;

public class DebitCard {
    private int amount;

    public DebitCard(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void deduct(int val) {
        if(val > amount) {
            System.out.println("You don't have enought money");
            return;
        }

        amount -= val;
    }
}
