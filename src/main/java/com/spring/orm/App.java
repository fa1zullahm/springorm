package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao  = context.getBean("studentDao",StudentDao.class);
        
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       System.out.println("Press 1 for adding a new Student");
       System.out.println("Press 2 for display all  Students");
       System.out.println("Press 3 get detail of single Student");
       System.out.println("Press 4 for deleting a new Student");
       System.out.println("Press 5 for update a new Student");
       System.out.println("Press 6 for Exit");
       
       
       
       boolean go = true;
       while ( go ) {
    	   
       Student student = null;
           
           try {
        	   int input = Integer.parseInt(br.readLine());
        	   switch(input) {
        	   case 1:
        		   //add a new student
        		   System.out.println("Press 1 for adding a new Student");
        		   student = new Student();
        		   student.setStudentName("Muhammad Faizullah");
        		   student.setStudentCity("Karachi");
        		   studentDao.insert(student);
        		   
        		   break;
        	   case 2:
        		   // display all students
        		   System.out.println("Press 2 for display all  Students");
        		   List<Student> students = studentDao.getAllStudents();
        		   System.out.println(students);
        		 
        		   for(Student s: students)  {
        			   System.out.println(s.getStudentName() + " " + s.getStudentId() + " " + s.getStudentCity() );
        		   }
        		  
        		   break;
        	   case 3:
        		   //detail of a single student
        		   System.out.println("Press 3 get detail of single Student");
        		   Random r = new Random();
        		   int low = 11;
        		   int high = 15;
        		   int result = r.nextInt(high-low) + low;
        		   student = studentDao.getStudent(result);
        		   System.out.println(student);
        		   break;
        	   case 4:
        		   //delete a student
        		   System.out.println("Press 4 for deleting a new Student");
        		 
        		   studentDao.delete(14);

        		   break;
        	   case 5:
        		   //update a student
        	       System.out.println("Press 5 for update a  Student");
        	       student = studentDao.getStudent(12);
        	       student.setStudentName("Muhammad Faizullah");
        	       student.setStudentCity("Karachi");
        	       System.out.println("STUDNET: " + student);
        		   studentDao.update(student);
        	       
        		   break;
        	   case 6:
        		   //switch is break
        		   System.out.println("Press 6 for Exit");
        		   
        		   go = false;     		   
        		   
        	   }//ends switch
           }catch(Exception e) {
        	   System.out.println("Invalid Input.. Try again");
        	   System.out.println(e.getMessage());
           }
       }
       System.out.println("Thanks for using my application .. See You soon");
        
    }
}
