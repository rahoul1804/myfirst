package jpa.daoMOdelEntity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeEntity 
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	int age;
	String country;
	String state;
	String date;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	String password;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "EmployeePojo [id=" + id + ", name=" + name + ", age=" + age + ", country=" + country + ", state="
				+ state + ", password=" + password + ", date=" + date + "]";
	}
	
	
	
	
	
	
}
