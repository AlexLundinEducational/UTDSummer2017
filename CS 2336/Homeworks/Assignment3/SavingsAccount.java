public class SavingsAccount extends Account {

    protected double OVERDRAFT_LIMIT = 0;

    public SavingsAccount(int id, double balance) {
        super(id, balance);
    }
    
    // withdraw method
    // overdraft error handling
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
        return "SavingsAccount{" +
                "mBalance=" + mBalance +
                '}';
    }
}