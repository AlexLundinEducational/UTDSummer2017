package checkPoints;

public class ch3_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 35;
		
		// dangling else
		if (number % 2 == 0)

			System.out.println(number + " is even.");

		System.out.println(number + " is odd.");
		
		
		// dangling else
		if (number % 2 == 0)

			System.out.println(number + " is even.");
		else
		System.out.println(number + " is odd.");
	}

}
