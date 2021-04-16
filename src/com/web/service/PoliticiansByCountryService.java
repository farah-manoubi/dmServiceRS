package com.web.service;
import java.util.ArrayList;
import java.util.HashMap;

import com.web.data.Politician;


public class PoliticiansByCountryService {
	private HashMap<String, ArrayList<Politician>> politicians;

	public String addCountry(String country) {
		politicians.put(country, new ArrayList<Politician>());
		return country;
	}
	
	public int addPolitican(String name, int age, int popularity,String location) {		
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
