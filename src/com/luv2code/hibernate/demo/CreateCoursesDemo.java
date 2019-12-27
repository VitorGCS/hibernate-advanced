
package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.course;


public class CreateCoursesDemo  {

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
			
			//get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			//create some courses
			course tempCourse1 = new course("Air Guitar - The Ultimate Guitar");
			course tempCourse2 = new course("The PintBall Masterclass");
			
			//add courses to instructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			//save courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			
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

