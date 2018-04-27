import java.util.ArrayList;
import java.util.Date;
// basic Loan class
// contains data fields to describe the loan
// toString method for printing
public class Loan {

    protected String loanName;
    protected int loanID;
    protected double loanAmount;
    protected Date loanDateCreated;


    public Loan() {
        loanDateCreated = new Date();
    }

    public Loan(int id, double amount) {
        this();
        loanID = id;
        loanAmount = amount;
    }

    public Loan(String name, int id, double amount) {
        this(id, amount);
        loanName = name;

    }

    public int getId() {
        return loanID;
    }

    public void setId(int id) {
        loanID = id;
    }

    public double getAmount() {
        return loanAmount;
    }

    public void setAmount(double amount) {
        loanAmount = amount;
    }

     public Date getDateCreated() {
        return loanDateCreated;
    }

    @Override
    public String toString() {
        return "Loan name: " + loanName + "\n" + "Date created: " + loanDateCreated + "\n" + "Amount Owed: " + loanAmount;
    }



}