



public class Ex07_32 {
  public static void main (String[] args) {
    java.util.Scanner input = new java.util.Scanner(System.in);

    // Enter values for list1
    System.out.print("Enter a list: ");
    int size = input.nextInt();
    int[] list = new int[size];    
    for (int i = 0; i < list.length; i++) 
      list[i] = input.nextInt();

    partition(list);
    
    System.out.print("After the partition, the list is ");
    for (int i = 0; i < list.length; i++)
      System.out.print(list[i] + " ");
  }

	/** Partition the array list[firstIndex..lastIndex] */
		public static int partition(int[] list) {
		int firstIndex = 0;
		int lastIndex = list.length - 1;
		int pivotValue = list[firstIndex];                                                         // Choose the firstIndex element as the pivotValue
		int lowIndex = firstIndex + 1;                                                             // Index for lowIndex value
		int highIndex = lastIndex;                                                                 // Index for highIndex value

      // while loop to continue based on highIndex index being greater than lowIndex index
		while (highIndex > lowIndex) {
      
		  // post increment lowIndex index 
        // until highIndex is reached or value larger or equal to pivot is found
		  while (lowIndex <= highIndex && list[lowIndex] <= pivotValue)
			lowIndex++;

		  // post decrement highIndex index
        // until lowIndex is reached or the value at highIndex is greater than pivotValue
		  while (lowIndex <= highIndex && list[highIndex] > pivotValue)
			highIndex--;

		  // if highIndex index is greater than lowIndex index, switch the values
		  if (highIndex > lowIndex) {
			int temp = list[highIndex];
			list[highIndex] = list[lowIndex];
			list[lowIndex] = temp;
		  }
		}

		while (highIndex > firstIndex && list[highIndex] >= pivotValue)
		  highIndex--;

		// switch pivotValue with list[highIndex]
		if (pivotValue > list[highIndex]) {
		  list[firstIndex] = list[highIndex];
		  list[highIndex] = pivotValue;
		  return highIndex;
		}
		else {
		  return firstIndex;
		}
	}
}