package hibernate;

public class Hardware extends Employee {

	public Hardware(int id, String email, String salary, String name,String working) {
		super(id, email, salary, name);
		this.working=working;
	}

	public String getWorking() {
		return working;
	}

	public void setWorking(String working) {
		this.working = working;
	}

	String working;
}
