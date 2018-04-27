//Alex Lundin
//07-09-2017
//Assignment 3


import java.util.ArrayList;
import java.util.Date;

public class Exercise11_06 {

    public static void main(String[] args) {

      System.out.println ("" );
      System.out.println ("" );
      System.out.println ("" );
      System.out.println ("Welcome to Exercise11_06. " );
      System.out.println ("This program creates ArrayList and adds an object of each type avaiable." );
      System.out.println ("Then the objects toString methods are called with the println method." );
      System.out.println ("" );
      System.out.println ("" );
      System.out.println ("" );      
      
      ArrayList<Object> list = new ArrayList<>();
      
      list.add(new Circle2D());
      list.add("Hello this is a string Object");
      list.add(new Date());
      list.add(new Loan("Fall Tuition",126, 2500.00));
      
      list.forEach(System.out::println);

    }

}