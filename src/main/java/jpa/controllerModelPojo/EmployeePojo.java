package jpa.controllerModelPojo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class EmployeePojo 
{
	int id;
	String name;
	int age;
	String country;
	String state;
	String password;
	String date;
	
	
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
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
