import java.util.*;
public class Course {
  private String courseName;
  private ArrayList students = new ArrayList();
  private int numberOfStudents = 0;
  
  // print loop for ArrayList
  public void printStudents (){
     for (int i = 0; i < students.size(); i++)
     System.out.println(students.get(i));  
  }
  
  // value constructor
  public Course(String courseName) {
    this.courseName = courseName;
  }
  
  //method to add student
  public void addStudent(String student) {
    students.add(student);
    numberOfStudents++;
  }
  
  public ArrayList getStudents() {
    return students;
  }

  public int getNumberOfStudents() {
    return numberOfStudents;
  }  

  public String getCourseName() {
    return courseName;
  }  
  

}