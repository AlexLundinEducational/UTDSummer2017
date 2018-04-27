//Alex Lundin
//07-09-2017
//Assignment 3


public class Exercise11_03 {

   public static void main(String[] args) {
      System.out.println ("" );
      System.out.println ("" );
      System.out.println ("" );
      System.out.println ("Welcome to Exercise11_03. " );
      System.out.println ("This program creates a superclass Account, and then two subclasses." );
      System.out.println ("Checking and savings account." );
      System.out.println ("Finally the results are printed." );
      System.out.println ("" );
      System.out.println ("" );
      System.out.println ("" );      
      Account account = new Account("Main Account", 1050, 300);
      CheckingAccount checkingAccount = new CheckingAccount(1051, 750);
      SavingsAccount savingsAccount = new SavingsAccount(1052, 100);
      
      System.out.println(account);
      System.out.println(checkingAccount);
      System.out.println(savingsAccount);
   }

}