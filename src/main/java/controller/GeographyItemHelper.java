/**
 * @authorchrisg - Cgeralds
 * CIS175-Fall2022
 * Feb 3, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.GeographyItem;


public class GeographyItemHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CountryList");
	
	//Insert item
	public void InsertItem(GeographyItem gi) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(gi);
		em.getTransaction().commit();
		em.close();
	}
	
	//Show items
	public List<GeographyItem>showAllItems() {
		EntityManager em = emfactory.createEntityManager();
		List<GeographyItem>allItems = em.createQuery("SELECT i FROM GeographyItem i").getResultList();
		return allItems;
	}
	
	//Delete Item
	public void deleteItem(GeographyItem toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<GeographyItem>typedQuery = em.createQuery("select gi from GeographyItem gi where gi.country =:selectedCountry and gi.capital =:selectedCapital and gi.language =:selectedLanguage ", GeographyItem.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedCountry",toDelete.getCountry());
		typedQuery.setParameter("selectedCapital",toDelete.getCapital());
		typedQuery.setParameter("selectedLanguage",toDelete.getLanguage());
		
		//One result
		typedQuery.setMaxResults(1);
		
		//get result and save to new list item
		GeographyItem result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	//Update 
	/**
	 * @param toEdit
	 */
	public void updateItem(GeographyItem toEdit) {
		// TODO Auto-generated method stub
		EntityManager em =emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	//Edit entry
	/**
	 * @param idToEdit
	 * @return
	 */
	public GeographyItem searchForItemById(int idToEdit) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		GeographyItem found = em.find(GeographyItem.class, idToEdit);
		em.close();
		return found;
	}
	
	/**
	 * @param countryName
	 * @return
	 */
	public List<GeographyItem> searchForCountryByCountry(String countryName) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<GeographyItem>typedQuery  = em.createQuery("select gi from GeographyItem gi where gi.country = :selectedCountry", GeographyItem.class);
		typedQuery.setParameter("selectedCountry",countryName);
		
		List<GeographyItem>foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	/**
	 * @param capitalName
	 * @return
	 */
	public List<GeographyItem> searchForCountryByCapital(String capitalName) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<GeographyItem>typedQuery = em.createQuery("select gi from GeographyItem gi where gi.capital =:selectedCapital",GeographyItem.class);
		typedQuery.setParameter("selectedCapital",capitalName);
		
		List<GeographyItem>foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	
	

	/**
	 * @param languageName
	 * @return
	 */
	public List<GeographyItem> searchCountryByLanguage(String languageName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<GeographyItem>typedQuery = em.createQuery("select gi from GeographyItem gi where gi.language =:selectedLanguage", GeographyItem.class);
		typedQuery.setParameter("selectedLanguage",languageName);
		List<GeographyItem>foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
	
	

}
