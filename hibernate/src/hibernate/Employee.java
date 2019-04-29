package hibernate;

import javax.persistence.Entity;
public class Employee {

	String name;
	
	public Employee(int id, String email, String salary, String name) {
		this.id=id;
		this.name=name;

		this.salary=salary;

		this.email=email;

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	String email;
	String salary;
	int id;
}
