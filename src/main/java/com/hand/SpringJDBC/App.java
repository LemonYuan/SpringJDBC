package com.hand.SpringJDBC;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.SpringJDBC.dao.StudentDAO;
import com.hand.SpringJDBC.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
    	StudentDAO studentDAO=(StudentDAO) context.getBean("studentDAO");
    	System.out.println("-------connection configured successfully-------");
    	studentDAO.create("lemon", 22);
    	studentDAO.create("jason", 11);
    	System.out.println("-------sutdent inserted successfully-------");
    	List<Student> students=studentDAO.getStudents();
    	System.out.println("-------student-list get--------");
    	for(int i=0;i<students.size();i++){
    		System.out.println("id: "+students.get(i).getId());
    	}
    }
}
