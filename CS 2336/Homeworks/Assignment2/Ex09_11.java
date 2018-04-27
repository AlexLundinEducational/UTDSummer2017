import java.util.*;
import java.lang.*;

//Alex Lundin
//06-25-2017
//Assignment 2

public class Ex09_11 {
  public static void main (String[] args) {
  
    Scanner input = new Scanner(System.in);
    double[] list1 = new double[6]; 
    
    System.out.print("Enter a, b , c , d , e , f: ");   
    for (int i = 0; i < list1.length; i++) 
      list1[i] = input.nextDouble();
      
    LinearEquation linearEquation = new LinearEquation (list1);                              // create new linearequation object
     
    boolean isSolutionAvaiable = linearEquation.isSolveable();                               // call instance method to determine solveability
    
    if (isSolutionAvaiable)                                                                  //if solveable, get solutions
    {
       double returnedX = linearEquation.getX();
       double returnedY = linearEquation.getY();
       System.out.println();
       System.out.println("x is " + returnedX);
       System.out.print("and y is " + returnedY); 
    }
    else                                                                                     // else print no solution
    {
       System.out.println();
       System.out.println("The equation has no solution.");
    }
    
      
  }
}



class LinearEquation
{
   // instance variables
	private double a;
	private double b;
	private double c;
	private double d;
	private double e;
	private double f;

	// default constructor
	LinearEquation() {
	   System.out.println("Default constructor"); 
	}

   // value constructor
	LinearEquation(double [] inputs) {
   	System.out.println("Value contructor"); 
   	this.a = inputs[0];
   	this.b = inputs[1];
   	this.c = inputs[2];
   	this.d = inputs[3];
   	this.e = inputs[4];
   	this.f = inputs[5];
	}   

   // determine if equation is solveable
	public boolean isSolveable(){
   	double denominator = (this.a * this.d) - (this.b * this.c);
   
   	boolean isSolveable = (denominator != 0);
   	return isSolveable;
	}

   // getters for solutions x and y
	public double getX(){
   	double X = 0;
   	double denominator = (this.a * this.d) - (this.b * this.c);
   	double numerator = (this.e * this.d) - (this.b * this.f);
   
   	X = numerator / denominator;
   	return X;
	}

	public double getY(){
   	double Y = 0;
   	double denominator = (this.a * this.d) - (this.b * this.c);
   	double numerator = (this.a * this.f) - (this.e * this.c);
   	Y = numerator / denominator;
   	return Y;
	} 

   // getters for a through e
	public double getA(){
	   return this.a;
	}
	public double getB(){
	   return this.b;
	}   
	public double getC(){
	   return this.c;
	}
	public double getD(){
	   return this.d;
	}
	public double getE(){
	   return this.e;
	}      
}
   