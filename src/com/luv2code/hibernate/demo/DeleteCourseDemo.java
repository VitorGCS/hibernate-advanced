package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.course;


public class DeleteCourseDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.addAnnotatedClass(course.class)
							.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();

		//use the session object to save Java object		
		try {
			//start a transaction
			session.beginTransaction();
			

			//get a course
			int theId=13;
			course tempCourse = session.get(course.class, theId);
			
			//delete couse
			System.out.println("Deletng course: "+tempCourse);
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
