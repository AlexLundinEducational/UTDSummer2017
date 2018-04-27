package blankPackage;
import java.util.*;
import java.math.*;

public class Q4_17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int m,year,leap,d = 0;
		
		System.out.println ("Enter year:" );
		year = input.nextInt();
		
		System.out.println ("Enter month:" );
		m = input.nextInt();
		
	    if 	(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)){
	    	leap = 1;
	    }
	    else {
	        leap = 0;		
	    }
		
		
		if (m == 1){
			d = 0;
		}
		if (m == 2){
			d = 28;
			if (leap == 1){
				d = 29;
			}
		}	
		if (m == 3){
			d = 0;
		}
		if (m == 4){
			d = 0;
		}
		if (m == 5){
			d = 0;
		}
		if (m == 6){
			d = 0;
		}
		if (m == 7){
			d = 0;
		}
		if (m == 8){
			d = 0;
		}
		if (m == 9){
			d = 0;
		}
		if (m == 10){
			d = 0;
		}
		if (m == 11){
			d = 0;
		}
		if (m == 12){
			d = 0;
		}


		System.out.println ("The : " + d );
		
		
		}
		

	}

