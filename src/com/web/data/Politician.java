package com.web.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Politician {
	private String name;
	private int age;
	private int popularity;
	private String location;
	
	public Politician(String name, int age, int popularity, String location) {
		this.name = name;
		this.age = age;
		this.popularity = popularity;
		this.location = location;
	}
	
	public Politician(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String popularity) {
		this.location = location;
	}
	

}
