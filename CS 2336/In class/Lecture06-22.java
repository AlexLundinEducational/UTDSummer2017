import java.util.*;
import java.lang.*;
public class Lecture06-22{
	
//Alex Lundin
//06-20-2017
//Lecture Template
	
   //stub for inputs
	public static void  Ex_1(){
   
		System.out.println("This stub is for Ex1.");


	}
   
   
   
   //stub for inputs
	public static void  Ex_2(){
   
		System.out.println("This stub is for Ex2.");

      
	}
   
   
   
   //stub for inputs
	public static void  Ex_3(){
		System.out.println("This stub is for Ex3.");

           
	}
   
   // main driver
	public static void main(String[] args) {

		Scanner input = new Scanner (System.in);
		int choice = 0;
		do{
         System.out.println ("" );
         System.out.println ("" );
         System.out.println ("" );
         System.out.println ("Welcome to the main driver for Lecture Examples. " );
         System.out.println ("Choose a class file to call by typing one of the options below:: " );
			System.out.println ("0 - Quit " );
			System.out.println ("1 - Ex1" );
         System.out.println ("2 - Ex2" );
			System.out.println ("3 - Ex3" );
			
			
			choice = input.nextInt();
			
			if (choice == 1){
				Ex_1();
			}
			else if (choice == 2){
				Ex_2();
			}	
         else if (choice == 3){
				Ex_3();
			}
		}while (choice != 0);
	} 
   
   
   
}
