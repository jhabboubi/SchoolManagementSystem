package jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

public class CourseService implements CourseDAO {
	// method to get all course available
	@Override
	public List<Course> getAllCourses() {
		// open connection
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("SMS");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		// query database for all courses
		TypedQuery<Course> query = entitymanager.createQuery("Select c from Course c", Course.class);
		// save the query to list of courses
		List<Course> c = query.getResultList();
		// close connection
		entitymanager.close();
		entitymanagerfactory.close();

		return c;
	}

}
