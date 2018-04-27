import java.util.*;
import java.lang.*;
public class Assignment1 {
	
//Alex Lundin
//06-18-2017
//Assignment 1
	
   
   // main driver
	public static void main(String[] args) {

		Scanner input = new Scanner (System.in);
		int choice = 0;
		do{
         System.out.println ("" );
         System.out.println ("" );
         System.out.println ("" );
         System.out.println ("Welcome to the main driver for Assignment 1. " );
         System.out.println ("Choose a class file to call by typing one of the options below:: " );
			System.out.println ("0 - Quit " );
			System.out.println ("1 - Quadratic" );
         System.out.println ("2 - Financial" );
			System.out.println ("3 - Calendar" );
			
			
			choice = input.nextInt();
			
			if (choice == 1){
				Q3_1();
			}
			else if (choice == 2){
				Q4_23();
			}	
         else if (choice == 3){
				Q5_29();
			}
		}while (choice != 0);
	}


   //stub for inputs
	public static void  Q3_1(){
   
   	double number1,number2,number3;
		System.out.println("This stub accepts user input for the quadratic function.");
		System.out.println("Enter a, b and c for the Quadractic.java file.");
		
		Scanner input = new Scanner(System.in);
		number1 = input.nextDouble();
		number2 = input.nextDouble();
		number3 = input.nextDouble();
   
   
		System.out.println ("Nowing entering Quadratic.java file." );
      Quadratic.main(number1,number2,number3);
	}
   
   
   
   //stub for inputs
	public static void  Q4_23(){
      
      String string1;
      double number1,number2,number3,number4;
		System.out.println("This stub accepts user input for calculating payroll information.");
		System.out.println("Enter the following information for Payroll.java file.");
      
      Scanner input = new Scanner(System.in);
      System.out.println("Enter employee's name:");
      string1 = input.next();
		System.out.println("Enter number of hours worked in a week:");
		number1 = input.nextDouble();
      System.out.println("Enter hourly pay rate:");
		number2 = input.nextDouble();
      System.out.println("Enter federal tax rate as decimal percent:");
		number3 = input.nextDouble();
      System.out.println("Enter state tax rate as decimal percent:");
      number4 = input.nextDouble();
		System.out.println ("Nowing entering Payroll.java file." );   
      
      Payroll.main(string1,number1,number2,number3,number4);
      
	}
   
   
   
   //stub for inputs
	public static void  Q5_29(){
		System.out.println("This stub accepts user input for printing a calendar for the year.");
		System.out.println("Enter the following information for Calendar.java file.");
      int number5,number6 = -1;
      String string2;
      
      
      Scanner input = new Scanner(System.in);
      System.out.println("Enter the year as a integer:");
      number5 = input.nextInt();
           
      System.out.println("Enter the day as a integer:");
      System.out.println("0 - Sunday");
      System.out.println("1 - Monday");
      System.out.println("2 - Tuesday");
      System.out.println("Ect...");
      number6 = input.nextInt();
      System.out.println ("Nowing entering Calendar.java file." );
      
      Calendar.main(number5,number6);
           
	}
}
