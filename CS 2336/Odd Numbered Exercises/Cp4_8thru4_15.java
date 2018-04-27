package checkPoints;

public class Cp4_8thru4_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cp4_14();
	}
	
	public static void cp4_8() {
		
		System.out.println((int)'1');
		System.out.println((int)'A');
		System.out.println((int)'B');
		System.out.println((int)'a');
		System.out.println((int)'b');

	}
	
	public static void cp4_9() {
		
		System.out.println('1');
		//System.out.println('\u345dE'); INCORRECT BECAUSE OVER MAX of FFFF
		System.out.println('\u3fFa');
		System.out.println('\t');
		System.out.println('\b');

	}	
	public static void cp4_10() {
		
		System.out.println((int)'1');
		System.out.println((int)('1'+'2' * ('4' - '3') + 'b' / 'a'));
		System.out.println((int)'a');
		System.out.println((char) 90);


	}	
	public static void cp4_12() {
		
		System.out.println((int)'A');
		System.out.println((int)(1000.34F));
		System.out.println((int)1000.34);
		System.out.println((char)97);


	}
	public static void cp4_14() {
		
// lowercase chars range from 97 to 122
// so random number must be between 97 and 123
		
		int random = (int)(97 + ((Math.random()) * 26));
		System.out.println(random);
		System.out.println((char)random);


	}
}
