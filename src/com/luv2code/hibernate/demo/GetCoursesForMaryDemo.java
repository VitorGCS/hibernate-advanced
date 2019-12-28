
package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;
import com.luv2code.hibernate.demo.entity.course;


public class GetCoursesForMaryDemo  {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.addAnnotatedClass(course.class)
							.addAnnotatedClass(Review.class)
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();

		//use the session object to save Java object		
		try {
			//start a transaction
			session.beginTransaction();
			
			//get the student Mary from database
			int theStudentId=1;
			Student tempStudent = session.get(Student.class, theStudentId);
			
			System.out.println("\nLoaded student: "+ tempStudent);
			System.out.println("\nCourse: "+tempStudent.getCourses());
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally{
			//add clean up code
			session.close();
			factory.close();
		}
	}

}

