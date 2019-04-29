package hibernate;

public class Software extends Employee {

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	String total;

	public Software(int id,String email, String salary, String name ,String total) {
		super(id,email,salary,name);
		this.total= total;
	}
}
