package jpa.service;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

// class implements StudentDAO
public class StudentService implements StudentDAO {
	// static EntityManagerFactory & EntityManager to be used in open connection and
	// close connection
	static EntityManagerFactory entitymanagerfactory = null;
	static EntityManager entitymanager = null;

	// method to open connection to database
	private void openCon() {

		try {
			// setting the schema to be used
			entitymanagerfactory = Persistence.createEntityManagerFactory("SMS");
			entitymanager = entitymanagerfactory.createEntityManager();
		} catch (Exception e) {
			// catch exception if failed to open connection
			e.printStackTrace();
			System.out.println("Problem in opening connection to SMS DB!");
		}
	}

	private void closeCon() {
		try {
			// close connection
			entitymanager.close();
			entitymanagerfactory.close();
		} catch (Exception e) {
			// catch exception if failed to close connection
			e.printStackTrace();
			System.out.println("Problem in closing connection to SMS DB!");
		}
	}

	// method to get a list of all students in DB return as list of student objects
	@Override
	public List<Student> getAllStudents() {
		// method to open connetion
		openCon();
		// query the database and save query as student object
		TypedQuery<Student> query = entitymanager.createQuery("Select s from Student s", Student.class);

		// save all objects of students in s list
		List<Student> s = query.getResultList();
		// close connection
		closeCon();
		return s;

	}

	// method to get the student object by the PK email
	@Override
	public Student getStudentByEmail(String sEmail) {
		// open connection to DB
		openCon();
		// query the database and save query as student object
		TypedQuery<Student> query = entitymanager.createQuery("Select s from Student s", Student.class);

		// save all objects of students in s list
		List<Student> s = query.getResultList();
		// loop through the list and find the email matching all the list of students
		for (int i = 0; i < s.size(); i++) {
			if (s.get(i).getsEmail().equals(sEmail)) {
				// if found the same email save the object in ss student object
				Student ss = new Student(s.get(i).getsEmail(), s.get(i).getsName(), s.get(i).getsPass());
				// close connection
				closeCon();
				return ss;
			}

		}
		// print not found in case not data
		System.out.println("Student not found");
		return null;
	}

	// method to check if student credentials
	@Override
	public boolean validateStudent(String sEmail, String sPassword) {
		// open connection
		openCon();
		// query the database and save query as student object
		TypedQuery<Student> query = entitymanager.createQuery("Select s from Student s", Student.class);

		// save all students in list s
		List<Student> s = query.getResultList();
		// loop through list and finds the email and password must match otherwsie
		// return flase
		for (int i = 0; i < s.size(); i++) {
			if (s.get(i).getsEmail().equals(sEmail) && s.get(i).getsPass().equals(sPassword)) {
				// close connection
				closeCon();
				return true;
			}

		}
		// close connection if loop fail
		closeCon();

		return false;
	}

	// method to register course to student
	@Override
	public void registerStudentToCourse(String sEmail, int cId) {
		try {
			// open connection manually
			EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("SMS");
			EntityManager entitymanager = entitymanagerfactory.createEntityManager();
			// start a transaction with database
			entitymanager.getTransaction().begin();

			// object of Course
			Course addNewCo = new Course();
			// object of Student
			Student currStu = new Student();
			// list of Course object
			List<Course> sCourse = new ArrayList<Course>();
			// object of StudentServices to use method getStudentByEmail
			StudentService getStu = new StudentService();
			// save Student object to currStu
			currStu = getStu.getStudentByEmail(sEmail);
			// save student courses to sCourse
			sCourse = getStudentCourses(sEmail);
			// get Course selected by user by id and save all the information in object ofd
			// Course
			addNewCo = entitymanager.find(Course.class, cId);
			// add the new course selected by user to the main courses of the student
			sCourse.add(addNewCo);
			// add all the information of student info and new courses list
			Student finalStu = new Student(currStu.getsEmail(), currStu.getsName(), currStu.getsPass(), sCourse);
			// merge that data using JPA to database
			entitymanager.merge(finalStu);
			// commit to changes
			entitymanager.getTransaction().commit();
			// close connection
			entitymanager.close();
			entitymanagerfactory.close();
		} catch (Exception e) {
			// catch the exception
			e.printStackTrace();
			System.out.println("Problem registerStudentToCourse connection to SMS DB!");
		}

	}

	// method to get all student courses
	@Override
	public List<Course> getStudentCourses(String sEmail) {
		// open connection
		openCon();
		// save all the object of that student into stu which brings with it the student
		// courses list
		Student stu = entitymanager.find(Student.class, sEmail);
		// use getter of courses and save it to a list
		List<Course> stuCour = stu.getsCourse();

		// close connection
		closeCon();

		return stuCour;
	}

}
