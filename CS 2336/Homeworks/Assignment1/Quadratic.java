import java.util.*;

//Alex Lundin
//06-18-2017
//Assignment 1



public class Quadratic {

	public static void main(double a, double b, double c) {

		double returnedDiscriminant = getDiscriminant(a , b , c);
		
      //determine which calculator to call based on discriminant result
		if	(returnedDiscriminant == 0){
			double returnRoot1 = getRoot1(a , b , c);
			System.out.println("The equation has one real root. " + returnRoot1);
		}
		if	(returnedDiscriminant > 0){
			double returnRoot1 = getRoot1(a , b , c);
			double returnRoot2 = getRoot2(a , b , c);
			System.out.println("The equation has two real roots." + " Root 1 is " + returnRoot1 + " and root 2 is " + returnRoot2 + ".");
		}
		if	(returnedDiscriminant < 0){
			System.out.println("The equation has no real roots.");
			
		}		
		
		
	}
	
   
   //calculate discriminant
	public static double getDiscriminant(double argA, double argB, double argC) {

		double bSquared = Math.pow(argB, 2.0);
		double discriminant = bSquared - (4 * argA * argC );
		return discriminant;
	}
	
   //calculatre first root
	public static double getRoot1(double argA, double argB, double argC) {

		double bSquared = Math.pow(argB, 2.0);
		double discriminant = bSquared - (4 * argA * argC );
		
		double root1 = (-1 * argB + Math.pow(discriminant , 0.5)) / (2 * argA);
		return root1;
	}	
	
   //calculate second root
	public static double getRoot2(double argA, double argB, double argC) {

		double bSquared = Math.pow(argB, 2.0);
		double discriminant = bSquared - (4 * argA * argC );
		
		double root2 = (-1 * argB - Math.pow(discriminant , 0.5)) / (2 * argA);
		return root2;
	}	
	
}
