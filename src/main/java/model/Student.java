/**
 * @authorchrisg - Cgeralds
 * CIS175-Fall2022
 * Feb 24, 2022
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private int id;
	String studentName;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String studentName) {
		super();
		this.id = id;
		this.studentName = studentName;
	}
		
	public Student(String studentName) {
		super();
		this.studentName = studentName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + "]";
	}
	
	
	

}
