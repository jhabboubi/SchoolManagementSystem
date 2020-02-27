package jpa.test;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import jpa.entitymodels.Student;
import jpa.service.StudentService;

public class JUnit_StudentService_Test {

	static StudentService acutal = new StudentService();

	// method to test if all student actual to expected
	@Test
	public void getAllStudentsTest() {
		
		// open connection
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("SMS");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		// list of actual results
		List<Student> actualStudent = acutal.getAllStudents();
		//close
		entitymanager.close();
		entitymanagerfactory.close();

		// list of expected manually entered from database
		List<Student> expectedStudent = new ArrayList<Student>();

		// adding manually student info to test
		Student temp1 = new Student("aiannitti7@is.gd", "Alexandra Iannitti", "test");
		expectedStudent.add(temp1);
		Student temp2 = new Student("cjaulme9@bing.com", "Cahra Jaulme", "test");
		expectedStudent.add(temp2);
		Student temp3 = new Student("cstartin3@flickr.com", "Clem Startin", "test");
		expectedStudent.add(temp3);
		Student temp4 = new Student("habboubi@gmail.com", "jafer", "test");
		expectedStudent.add(temp4);
		Student temp5 = new Student("hguerre5@deviantart.com", "Harcourt Guerre", "test");
		expectedStudent.add(temp5);
		Student temp6 = new Student("hluckham0@google.ru", "Hazel Luckham", "X1uZcoIh0dj");
		expectedStudent.add(temp6);
		Student temp7 = new Student("htaffley6@columbia.edu", "Holmes Taffley", "test");
		expectedStudent.add(temp7);
		Student temp8 = new Student("imad@gmail.com", "imad", "test");
		expectedStudent.add(temp8);
		Student temp9 = new Student("ljiroudek8@sitemeter.com", "Laryssa Jiroudek", "test");
		expectedStudent.add(temp9);
		Student temp10 = new Student("qllorens2@howstuffworks.com", "Quillan Llorens", "test");
		expectedStudent.add(temp10);
		Student temp11 = new Student("sbowden1@yellowbook.com", "Sonnnie Bowden", "SJc4aWSU");
		expectedStudent.add(temp11);
		Student temp12 = new Student("tattwool4@biglobe.ne.jp", "Thornie Attwool", "test2");
		expectedStudent.add(temp12);

		// conversion to array from arraylist
		Object[] actual = actualStudent.toArray();
		Object[] expected = expectedStudent.toArray();
		// sorting array
		Arrays.sort(actual);
		Arrays.sort(expected);

		// checking if matchs
		assertArrayEquals(expected, actual);

	}

}
