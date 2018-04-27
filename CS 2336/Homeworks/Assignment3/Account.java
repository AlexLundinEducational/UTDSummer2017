import java.util.ArrayList;
import java.util.Date;
// basic Account Class
// default contructor and two value constructors
public class Account {

    protected String mName;
    protected int mId;
    protected double mBalance;
    protected double mAnnualInterestRate; // AnnualInterestRate is percentage.
    protected Date mDateCreated;



    public Account() {
        mDateCreated = new Date();
    }

    public Account(int id, double balance) {
        this();
        mId = id;
        mBalance = balance;
    }

    public Account(String name, int id, double balance) {
        this(id, balance);
        mName = name;

    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public double getBalance() {
        return mBalance;
    }

    public void setBalance(double balance) {
        mBalance = balance;
    }

    public double getAnnualInterestRate() {
        return mAnnualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        mAnnualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return mDateCreated;
    }

    public double getMonthlyInterestRate() {
        return mBalance * (mAnnualInterestRate / 12) / 100;
    }

    public void withdraw(double amount) {
        mBalance -= amount;
    }

    public void deposit(double amount) {
        mBalance += amount;
    }

    @Override
    public String toString() {
        return "Account name: " + mName + "\n" + "Interest rate: " + mAnnualInterestRate + "\n";
    }



}