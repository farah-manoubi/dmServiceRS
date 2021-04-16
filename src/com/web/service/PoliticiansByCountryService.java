package com.web.service;
import java.util.ArrayList;
import java.util.HashMap;

import com.web.data.Politician;


/**
 * Classe qui contient les méthodes permettant de réaliser les traitements des données, comme l'ajout de pays, de politiciens...
 * @file PoliticiansByCountryService.java
 * @author MANOUBI Farah, DENDOUNE Rayane
 * @version 1.0
 * @date 16/04/2021
 *
 */
public class PoliticiansByCountryService {
	private HashMap<String, ArrayList<Politician>> politicians;

	/**
     * Constructeur de CountryImplement.
     */
	public PoliticiansByCountryService(){
		politicians= new HashMap<String, ArrayList<Politician>>();
	}
	
	/**
	 * Fonction qui permet d'ajouter un pays.
	 * String addCountry(String country)
     * @param [in] country Nom du pays. (Type String)
     * @return Retourne le nom du pays qui à été ajouté.
     */
	public String addCountry(String country) {
		politicians.put(country, new ArrayList<Politician>());
		return country;
	}
	
	
	/**
	 * Fonction qui permet d'ajouter un politicien.
	 * String addPolitician(String name, int age, int popularity, String location)
     * @param [in] name Nom du politicien. (Type String)
     * @param [in] age Age du politicien. (Type int)
     * @param [in] popularity NOmbre d'abonnés. (Type int)
     * @param [in] location Nom du pays. (Type String)
     * @return Retourne 0 si le politicien à bien été ajouté, -1 en cas d'erreur.
     */
	public int addPolitician(String name, int age, int popularity,String location) {		
		boolean exist = false;
		ArrayList<Politician> al;
		if((al = politicians.get(location)) != null) {
			for(Politician pl : al) {
				if(pl.getName() == name) {
					exist = true;
					break;
				}
			}
		}
		if(!exist) {
			al.add(new Politician(name, age, popularity, location));
		}
		else
			return -1;
		
		return 0;
	}

	/**
	 * Fonction qui permet d'obtenir le nom des N politiciens d'un pays en fonction du pays passé en paramètre.
	 * String getPoliticianByCountry(String country)
     * @param [in] country Nom du pays. (Type String)
     * @return Retourne un String contenant les noms des politiciens du pays choisi.
     */
	 public String getPoliticianByCountry(String Country) {
        String polis = "";
        for (HashMap.Entry<String, ArrayList<Politician>> entry : politicians.entrySet()){
                if(entry.getKey().equals(Country)) {
                    for (int i = 0; i< entry.getValue().size(); i++) {
                        polis += entry.getValue().get(i).getName() + "\n";
                    }
                }
        }
        return polis;
    }
}
