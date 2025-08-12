interface State {
    public void insertMoney();
    public void selectItem();
    public void dispenseItem();
}

class IdleState implements State {
    public void insertMoney() {
        System.out.println("Inserting Money..");
    }

    public void selectItem() {
        System.out.println("Please insert money first..");
    }

    public void dispenseItem() {
        System.out.println("Please insert money first..");
    }
}

class InsertedMoneyState implements State {
    public void insertMoney() {
        System.out.println("You have already inserted money..");
    }

    public void selectItem() {
        System.out.println("Selecting the item..");
    }

    public void dispenseItem() {
        System.out.println("Select the item first..");
    }
}

class DispenseState implements State {
    public void insertMoney() {
        System.out.println("Collect the item first..");
    }

    public void selectItem() {
        System.out.println("You have already selected an item..");
    }

    public void dispenseItem() {
        System.out.println("Dispensing the item..");
    }
}

class VendingMachine {
    private State state;

    public VendingMachine() {
        this.state = new IdleState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void insertMoney() {
        this.state.insertMoney();
    }

    public void selectItem() {
        this.state.selectItem();
    }

    public void dispenseItem() {
        this.state.dispenseItem();
    }
}



public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.insertMoney();

        vendingMachine.setState(new InsertedMoneyState());
        vendingMachine.selectItem();

        vendingMachine.setState(new DispenseState());
        vendingMachine.dispenseItem();
    }
}
