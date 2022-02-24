/**
 * @authorchrisg - Cgeralds
 * CIS175-Fall2022
 * Feb 24, 2022
 */
package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	@ManyToOne           //many lists, but only one student per list
	private Student student;
	@OneToMany(cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<GeographyItem> listOfCountries;
	
	public ListDetails() {    //REMEMBER JPA always need default constructor!!!!
		super();
		// TODO Auto-generated constructor stub
	}
	public ListDetails(int id, String listName, Student student, List<GeographyItem> listOfCountries) {
		super();
		this.id = id;
		this.listName = listName;
		this.student = student;
		this.listOfCountries = listOfCountries;
	}
	public ListDetails(String listName, Student student, List<GeographyItem> listOfCountries) {
		super();
		this.listName = listName;
		this.student = student;
		this.listOfCountries = listOfCountries;
	}
	public ListDetails(String listName, Student student) {
		super();
		this.listName = listName;
		this.student = student;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public List<GeographyItem> getListOfCountries() {
		return listOfCountries;
	}
	public void setListOfCountries(List<GeographyItem> listOfCountries) {
		this.listOfCountries = listOfCountries;
	}





}
