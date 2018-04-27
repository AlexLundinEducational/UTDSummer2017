package blankPackage;
import java.util.*;
import java.math.*;

public class Q3_21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		
		int h,q,m,j,k,year = 0;
		String day = new String("day");
		
		System.out.println ("Enter year:" );
		year = input.nextInt();
		
		System.out.println ("Enter month:" );
		m = input.nextInt();
		
		if (m == 1){
			m = 13;
		}
		if (m == 2){
			m = 14;
		}		
		System.out.println ("Enter day of the month:" );
		q = input.nextInt();
		
		j = year / 100;
		
		k = year % 100;
		
		h = ( ( q + ( ( 26 * ( m + 1 ) ) /10 ) + k + ( k / 4 ) + ( j / 4 ) + ( 5 / j ) ) % 7 );
		
		if (h == 0){
			day = "Saturday";
		}
		if (h == 1){
			day = "Sunday";
		}
		if (h == 2){
			day = "Monday";
		}
		if (h == 3){
			day = "Tuesday";
		}
		if (h == 4){
			day = "Wednesday";
		}
		if (h == 5){
			day = "Thursday";
		}
		if (h == 6){
			day = "Friday";
		}

		System.out.println ("The day of the week is: " + day );
		
		
		}
		

	}

