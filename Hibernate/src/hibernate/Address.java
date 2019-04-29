package hibernate;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class Address {

	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	String street;
	String phone;
}
