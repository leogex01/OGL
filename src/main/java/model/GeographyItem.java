/**
 * @authorchrisg - Cgeralds
 * CIS175-Fall2022
 * Feb 3, 2022
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="locations")
public class GeographyItem {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="COUNTRY")
	private String country;
	@Column(name="CAPITAL")
	private String capital;
	@Column(name="LANGUAGE")
	private String language;
	
	//Constructors
	public GeographyItem() {
		super();
	}

	public GeographyItem(String country, String capital, String language) {
		super();
		this.country = country;
		this.capital = capital;
		this.language = language;
	}
    
	//Getter & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String returnCountryDetails() {
		return " Country: " + this.country + "| Capital: " + this.capital + "| Language: " + this.language;
	}
	
	
	

}
