
package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;
import com.luv2code.hibernate.demo.entity.course;


public class DeletePacmanCourseDemo  {

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
			
			//get the Pacman course from db
			course tempCourse = session.get(course.class, 10);
			
			//delete the course
			System.out.println("\nDeleting course: "+tempCourse);
			session.delete(tempCourse);
			
			
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

