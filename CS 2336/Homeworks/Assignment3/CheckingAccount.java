public class CheckingAccount extends Account {

    protected double OVERDRAFT_LIMIT = -100;

    public CheckingAccount(int id, double balance) {
        super(id, balance);
    }

    // override super withdraw method
    // if current balance minus amount is greater than overdraft limit
    // then continue operator
    // else print error
    @Override
    public void withdraw(double amount) {
        if (mBalance - amount >= OVERDRAFT_LIMIT) {
            super.withdraw(amount);
        }
        else 
        System.out.println ("The withdraw is not possible, account will become overdrawn." );
    }

    @Override
    public String toString() {
        return "CheckingAccount{"+
                "mBalance=" + mBalance +
                '}';
    }
}