/**
 * @authorchrisg - Cgeralds
 * CIS175-Fall2022
 * Feb 24, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.GeographyItem;
import model.Student;

/**
 * @author chrisg
 *
 */
public class StudentHelper {
	static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("CountryList");
	 
	 public void insertShopper(Student s) {
		 EntityManager em = emFactory.createEntityManager();
		 em.getTransaction().begin();
		 em.persist(s);
		 em.getTransaction().commit();
		 em.close();
	 }
	 
	//show all students
		 public List<Student>showAllStudents() { 
			 EntityManager em = emFactory.createEntityManager();
			 List<Student> allStudents = em.createQuery("SELECT s FROM Student s").getResultList();
			 return allStudents;
		 }
		 
		 public Student findStudent(String nameToLookUp) {
			 EntityManager em = emFactory.createEntityManager();
			 em.getTransaction().begin();
			 TypedQuery<Student> typedQuery = em.createQuery("select sh from Student sh where sh.studentName = :selectedName",Student.class);
			 typedQuery.setParameter("selectedName", nameToLookUp);
			 typedQuery.setMaxResults(1);
			 
			 Student foundStudent;
			 try{
				 foundStudent = typedQuery.getSingleResult();
				 } catch(NoResultException ex) {
					 foundStudent = new Student(nameToLookUp);
					 }
			 em.close();
			 return foundStudent;}
		 

/**
 * @param idToEdit
 * @return
 */
		 public GeographyItem searchForItemById(int idToEdit) {
			 // TODO Auto-generated method stub
			 EntityManager em = emFactory.createEntityManager();
			 em.getTransaction().begin();
			 GeographyItem found = em.find(GeographyItem.class, idToEdit);
			 em.close();
			 return found;
         }
}



