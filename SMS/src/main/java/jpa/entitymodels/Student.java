package jpa.entitymodels;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {
	// fields
	@Id
	private String sEmail;
	private String sName;
	private String sPass;
	// relational table with Course
	@OneToMany(targetEntity = Course.class)
	private List<Course> sCourse;

	// default constructor
	public Student() {
	}

	// my constructor without sCourse
	public Student(String sEmail, String sName, String sPass) {
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPass = sPass;
	}

	// my constructor with sCourse
	public Student(String sEmail, String sName, String sPass, List<Course> sCourse) {
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPass = sPass;
		this.sCourse = sCourse;
	}

	// getters and setters
	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsPass() {
		return sPass;
	}

	public void setsPass(String sPass) {
		this.sPass = sPass;
	}

	public List<Course> getsCourse() {
		return sCourse;
	}

	public void setsCourse(List<Course> sCourse) {
		this.sCourse = sCourse;
	}

}
