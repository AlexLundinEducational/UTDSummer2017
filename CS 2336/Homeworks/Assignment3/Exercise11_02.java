public class Exercise11_02 {

   public static void main(String[] args) {
      System.out.println ("" );
      System.out.println ("" );
      System.out.println ("" );
      System.out.println ("Welcome to Exercise11_02. " );
      System.out.println ("This program creates a person, student, employee, faculty and staff member. " );
      System.out.println ("" );
      System.out.println ("" );
      System.out.println ("" );      
      
      Person person = new Person("Mandy Smith");
      Student student = new Student("John Doe");
      Employee employee = new Employee("Professor Jones");
      Faculty faculty = new Faculty("CEO Amanda");
      Staff staff = new Staff("Engineer Tom");
      
      System.out.println(person.toString());
      System.out.println(student.toString());
      System.out.println(employee.toString());
      System.out.println(faculty.toString());
      System.out.println(staff.toString());
   
   }


}
