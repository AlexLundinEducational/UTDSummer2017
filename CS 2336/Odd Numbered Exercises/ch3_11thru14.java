package checkPoints;

public class ch3_11thru14 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		int j = 1;
		int k = 1;
		int x = 5;
		int y = 5;
		int z = 5;
		
		//if (i > 0)if
		//(j > 0)
		//	x = 0; else
		//if (k > 0) y = 0;
		//else z = 0;
		//System.out.println("x " + x + " y " + y + " z " + z);
		
		
		if (i > 0)
		{
			if	(j > 0)
				x = 0; 
			else if (k > 0) 
				y = 0;
		}
		else z = 0;
		System.out.println("x " + x + " y " + y + " z " + z);
	}
}
