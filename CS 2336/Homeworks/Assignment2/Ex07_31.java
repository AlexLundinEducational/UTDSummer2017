import java.util.*;
import java.lang.*;
//Alex Lundin
//06-25-2017
//Assignment 2

public class Ex07_31 {
  public static void main (String[] args) {
    Scanner input = new Scanner(System.in);

    // Enter values for list1
    System.out.print("Enter length of first list: ");
    int size1 = input.nextInt();
    int[] list1 = new int[size1];  
    System.out.print("Each integer of the first list: ");  
    for (int i = 0; i < list1.length; i++) 
      list1[i] = input.nextInt();
      
     // Enter values for list2
    System.out.print("Enter length of second list: ");
    int size2 = input.nextInt();
    int[] list2 = new int[size2];  
    System.out.print("Each integer of the second list: ");  
    for (int i = 0; i < list2.length; i++) 
      list2[i] = input.nextInt();   
    
    int[] mergedArray = new int[size1 + size2];
    
    mergedArray = mergeArrays (list1, list2, mergedArray);
    
    printArrays (list1,list2, mergedArray);
    
      
      
  }
  
   public static int[] mergeArrays (int[] listFirst, int [] listSecond, int [] mergedArray){
   
 
    
    boolean isNumber1 = false;
    boolean isNumber2 = false;
    int number1 = 0;
    int number2 = 0;
    int i = 0;
    int j = 0;
    int k = 0;
    int high = 0;
    int low = 0;
    // loop through empty mergedArray
     for (; k < mergedArray.length;){
            if
               ( i < listFirst.length){
               number1 = listFirst[i];
               isNumber1 = true;
               }
            else
               isNumber1 = false;
            if
               ( j < listSecond.length){
               number2 = listSecond[j];
               isNumber2 = true;
               }
            else 
               isNumber2 = false;
               
            if (isNumber1 && isNumber2){
               // compare to find high and low
               // increment based on which is greater
               if (number1 > number2){
               high = number1;
               low  = number2;
               j++   ;
               }
               else if (number2 > number1){
               high = number2;
               low = number1;
               i++;
               }
               // if neither is greater, use both and increment everything
               else{
               high = number1;
               low  = number2;
               mergedArray[k] = high;
               j++;
               i++;
               k++;              
               }
               mergedArray[k] = low;
               k++;
               }
            // if only one number exists just use one
            else if (isNumber1){
               mergedArray[k] = number1;
               k++;
               i++;
            }   
            else if (isNumber2){
               mergedArray[k] = number2;
               k++;
               j++;
            }
    }
    
    
    
      
      return mergedArray;  
   }
   
   public static void printArrays (int[] listFirst, int [] listSecond, int [] listThird){
    System.out.println();
    System.out.print("The first list is, ");
    for (int i = 0; i < listFirst.length; i++)
      System.out.print(listFirst[i] + " ");
      
    System.out.println();
    System.out.print("The second list is, ");
    for (int j = 0; j < listSecond.length; j++)
      System.out.print(listSecond[j] + " "); 
      
    System.out.println();  
    System.out.print("The merged list is, ");
    for (int k = 0; k < listThird.length; k++)
      System.out.print(listThird[k] + " ");
             
   }

}
