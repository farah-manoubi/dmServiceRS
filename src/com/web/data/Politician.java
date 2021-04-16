package com.web.data;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * @file Politician.java
 * @brief Classe qui permet de créer l'objet Politician. 
 * @author MANOUBI Farah, DENDOUNE Rayane
 * @version 1.0
 * @date 16/04/2021
 *
 */
@XmlRootElement
public class Politician {
	private String name;
	private int age;
	private int popularity;
	private String location;
	
	/**
     * Constructeur de Country
     * @param [in] name Nom du politicien. (Type String)
     * @param [in] age Age du politicien. (Type int)
     * @param [in] popularity NOmbre d'abonnés. (Type int)
     * @param [in] location Nom du pays. (Type String)
     */
	public Politician(String name, int age, int popularity, String location) {
		this.name = name;
		this.age = age;
		this.popularity = popularity;
		this.location = location;
	}
	
	public Politician(String name) {
		this.name = name;
	}
	
	/**
	 * Fonction qui retourne le nom du politicien.
	 * String getName()
     * @return Retourne le nom du politicien.
     */
	public String getName() {
		return name;
	}
	
	/**
	 * Fonction qui modifie le nom du politicien.
	 * void setName()
     * @param [in] name Nom du politicien. (Type String)
     */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Fonction qui retourne l'âge du politicien.
	 * String getAge()
     * @return Retourne l'âge du politicien.
     */
	public int getAge() {
		return age;
	}
	
	/**
	 * Fonction qui modifie l'âge du politicien.
	 * String setAge()
     * @param [in] age Âge du politicien. (Type int)
     */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Fonction qui retourne le nombre d'abonné du politicien.
	 * String getPopularity()
     * @return Retourne le nombre d'abonnés du politicien.
     */
	public int getPopularity() {
		return popularity;
	}
	
	/**
	 * Fonction qui modifie le nombre d'abonnés du politicien.
	 * String setAge()
     * @param [in] popularity nombre d'abonnés du politicien. (Type int)
     */
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
	
	/**
	 * Fonction qui retourne le pays du politicien.
	 * String getLocation()
     * @return Retourne le pays du politicien.
     */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Fonction qui modifie le pays du politicien.
	 * String setLocation()
     * @param [in] location Le pays du politicien. (Type String)
     */
	public void setLocation(String popularity) {
		this.location = location;
	}
	

}
