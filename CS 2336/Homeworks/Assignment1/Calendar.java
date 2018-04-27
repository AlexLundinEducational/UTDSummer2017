import java.util.*;


public class Calendar {

	public static void main(int year, int day) {


          Calendar currentCalendar = new Calendar(year, day);
          
                  int returnedDaysInCurrentMonth = 0;
                  
                  int RowPrevious = 0;
                  int ColPrevious = 0;
                  int Row = 0;
                  int Column = 0;
                  //loop through entire year
                  for (int i = 0; i < 12; i++){
                       
                      String Object[][] = new String[7][6];                                                       //create new two dimensional array every iteration
                      
                      returnedDaysInCurrentMonth = currentCalendar.getDaysInCurrentMonth(i);                      //get number of days in month
                      System.out.printf("%n"); 
                      
                      
                       //fill array with empty string 
                      for (Column = 0; Column < 6; Column++){
                           
                           
                           for (Row = 0; Row < 7; Row++){
                                 String j1 = "";
                                 Object[Row][Column] = j1;
                           } 

                      }
                                           
                      
                      
                      //loop through entire month and place value of j in the 2d integer array Object
                      int j = 1;
                                          
                      if   (i == 0){
                           Row = day;
                           Column = 0; 
                      }
                      else{
                           Row = RowPrevious ;
                            Column = ColPrevious;
                      }
                      for (; j <= returnedDaysInCurrentMonth; Column++){                        //both loops controlled by number of days
                          
                            if (Column >= 6){                                                   //if column is out of bounds
                            
                                 Column = 0;                                                    //start at beginning of calendar
                                 Row = 0; 
                                 }
                                                          
                           for (;j <= returnedDaysInCurrentMonth ; Row++){                      //both loops controlled by number of days
                              if (Row >= 7){                                                    // if row is out of bounds
                                 Row = 0;                                                       // reset row
                                 Column++;                                                      //increment column
                                 }
                              if (Column >= 6){                                                 //if column is out of bounds                     
                                 break;                                                         //break and let outer loop handle
                                 }                               
                              if (j > returnedDaysInCurrentMonth){                              //if we reached the last day
                                 RowPrevious = Row;                                             //save location of slot for next month
                                 RowPrevious = --RowPrevious;
                                 ColPrevious = Column;
                                 String j1 = "";                                                //fill remaining empty spaces with blank string
                                 Object[Row][Column] = j1; 
                                 }
                              else{
                                 Object[Row][Column] = Integer.toString(j);                     //when in bounds, place j into array 
                                 j++;
                              }

                           } 
                           


                      }
                      
                      //print loop for Object array   
                      for (Column = 0; Column < 6; Column++){
                           
                           
                           for (Row = 0; Row < 7; Row++){
                               System.out.print(String.format("%-10s", Object[Row][Column]));
                           } 
                           System.out.printf("%n"); 

                      }   
                                            
                                        
                  }         
          
                  
          }
       


                //default contructor for Calendar
                public Calendar (){
                  //System.out.println ("Default currentCalendar constructor.");
                }
      		    
                //overloaded default contructor for Calendar  
                public Calendar (int argYear, int argDay){
                  
                  //System.out.println ("Overloaded default currentCalendar constructor.");
 
               }
                  
                 
              
               //returns days in the month and starts print header   
               public int getDaysInCurrentMonth (int argMonthNumber){
                  String currentMonth = "nil";
                  int daysInMonth = 0;
                  if       (argMonthNumber == 0)
                           {
                           currentMonth = "January";
                           daysInMonth = 31;
                           }
                  if  (argMonthNumber == 1)
                           {
                           currentMonth = "February";
                           daysInMonth = 28;
                           }
                  if  (argMonthNumber == 2)
                           {
                           currentMonth = "March";
                           daysInMonth = 31;
                           }
                  if  (argMonthNumber == 3)
                           {
                           currentMonth = "April";
                           daysInMonth = 30;
                           }
                  if  (argMonthNumber == 4)
                           {
                           currentMonth = "May";
                           daysInMonth = 31;
                           }                     
                  if  (argMonthNumber == 5)
                           {
                           currentMonth = "June";
                           daysInMonth = 30;
                           }                     
                  if  (argMonthNumber == 6)
                           {
                           currentMonth = "July";
                           daysInMonth = 31;
                           }
                  if  (argMonthNumber == 7)
                           {
                           currentMonth = "August";
                           daysInMonth = 31;
                           }
                  if  (argMonthNumber == 8)
                           {
                           currentMonth = "September";
                           daysInMonth = 30;
                           }   
                  if  (argMonthNumber == 9)
                           {
                           currentMonth = "October";
                           daysInMonth = 31;
                           }                                             
                  if  (argMonthNumber == 10)
                           {
                           currentMonth = "November";
                           daysInMonth = 30;
                           }                      
                  if
                    (argMonthNumber == 11)
                           {
                           currentMonth = "December";
                           daysInMonth = 31;
                           }
                  System.out.println ("");  
                  System.out.println ("                         " + currentMonth + "                         ");
                  System.out.println ("______________________________________________________________________");
                  System.out.print(String.format("%-10s", "Sun"));
                  System.out.print(String.format("%-10s", "Mon"));
                  System.out.print(String.format("%-10s", "Tue"));
                  System.out.print(String.format("%-10s", "Wed"));
                  System.out.print(String.format("%-10s", "Thu"));
                  System.out.print(String.format("%-10s", "Fri"));
                  System.out.print(String.format("%-10s", "Sat"));
                  return daysInMonth;                  
                  }  
                                        

         
       
       
       
       
          		
	}


