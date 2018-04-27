import java.util.*;

//Alex Lundin
//06-18-2017
//Assignment 1


public class Payroll {

	public static void main(String name, double hours, double payRate, double federalTaxRate, double stateTaxRate) {

	   // use functions to calculate values from arguments sent in from stubs and any return value from a previous function call
	   double returnGrossPay = getGrossPay(hours,payRate);
      double returnFederalDeduction = getFederalDeduction(returnGrossPay, federalTaxRate);
      double returnStateDeduction = getStateDeduction(returnGrossPay,stateTaxRate);
      printer (name, hours,payRate, federalTaxRate,stateTaxRate,returnGrossPay, returnFederalDeduction, returnStateDeduction);  
		
	}
   
   
   
   // 3 standard calculation functions, simply reading arguments, doing arithmetic and returning a double
	public static double getGrossPay(double argHours, double payRate) {
		double GrossPay = argHours * payRate;
		return GrossPay;
	}
   
	public static double getFederalDeduction(double argGrossPay, double federalTaxRate) {
      double FederalDeduction = argGrossPay * federalTaxRate;
		return FederalDeduction;
	}
      	
	public static double getStateDeduction(double argGrossPay, double stateTaxRate) {
		double StateDeduction = argGrossPay * stateTaxRate;
		return StateDeduction;
	}
	
   
   // finally a printer function for the results
	public static void printer(String arg2name, double arg2hours, double arg2payRate, double arg2federalTaxRate, double arg2stateTaxRate, double arg2returnGrossPay, double arg2returnFederalDeduction, double arg2returnStateDeduction) {
      System.out.println ("Employee Name: " + arg2name); 
      System.out.println ("Hours Worked: " + arg2hours);
      System.out.println ("Pay Rate: $" + arg2payRate);
      System.out.println ("Gross Pay: $" + arg2returnGrossPay);
      System.out.println ("Deductions: ");
      System.out.println ("\tFederal Withholding (" + (arg2federalTaxRate*100) + "%): $" + Math.floor(arg2returnFederalDeduction * 100) / 100);
      System.out.println ("\tState Withholding (" +(arg2stateTaxRate*100)+ "%): $" + Math.floor(arg2returnStateDeduction * 100) / 100);
      System.out.println ("\tTotal Deduction: $" + Math.floor((arg2returnFederalDeduction + arg2returnStateDeduction)* 100) / 100);
      System.out.println ("Net Pay: $" +Math.floor((arg2returnGrossPay - arg2returnFederalDeduction - arg2returnStateDeduction)* 100) / 100);
      System.out.println ("Exiting Payroll.java file.");
	}
	
}
