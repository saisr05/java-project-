import java.util.*;

public class Q5A {
    public static void main(String[] args) {

        SportStudent s1 = new SportStudent("no");
        enrollment e1 = new SpecialEnrollment();
        CourseModes c = new CourseModes('A');
        CourseModes c2 = new CourseModes('B');
        // course details
        c.courseId = 123;
        c.couseName =" math";
        c2.courseId =909;
        c2.couseName = "AOOP";
        //student details
        s1.id = 30312;
        s1.name ="Abel";
        s1.courses.add(c);
        s1.courses.add(c2);
        //enrollement
        e1.students.add(s1);
        //print 
        printdetails(e1);

    }
  public static void printdetails(enrollment e){
          
          for(int i=0;i<e.students.size();i++){
            SportStudent s = e.students.get(i);
            // Specialcatogory-> if any
           if(!e.getSpecialcatagory(s).equals("no")){
               System.err.println("specila catogory =" + e.getSpecialcatagory(s));
           }
         
            //details
            System.out.println("name = "+ s.name);
            System.out.println("id = "+ s.id);
            for(int j=0;j<s.courses.size();j++){
                System.out.println("---------------");
                CourseModes c = s.courses.get(j);
                //courses
                System.out.println("course modes " + c.Modes);
                int num = j+1;
                System.out.println(" course no = "+ num);
                System.out.println("courseid = " + c.courseId);
                System.out.println("coursename = " + c.couseName);
            }
            
          }
         

    }
}


class  Course{
    int courseId;
    String couseName;

}
// open -closed principle
class CourseModes extends Course{
        char Modes;//A-> Advanced, B->basic
        CourseModes(char Modes){
            this.Modes =Modes;
        }
}

 class Student{
    String name;
    int id;
    ArrayList<CourseModes> courses = new ArrayList<>();

    Student(){
        courses = new ArrayList<>();
    }
}

class SportStudent extends Student{
      String sport ;

      SportStudent(String sport){
        this.sport = sport;
      }
}
abstract class enrollment{
    ArrayList<SportStudent> students ;

    enrollment(){
        students = new ArrayList<>();
    }

   abstract String getSpecialcatagory(SportStudent s);

}

class SpecialEnrollment extends enrollment{
   
    public String getSpecialcatagory(SportStudent s){
           return s.sport;
    }
}
