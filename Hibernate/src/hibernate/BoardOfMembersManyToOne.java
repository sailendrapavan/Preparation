package hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
@Entity
public class BoardOfMembersManyToOne {
    @Id
    @GeneratedValue
	private int id;
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
	private String name;
	
	public CompanyManyToOne getComp() {
		return comp;
	}
	public void setComp(CompanyManyToOne comp) {
		this.comp = comp;
	}
	@ManyToOne
	//@NotFound (action=NotFoundAction.EXCEPTION)
	private CompanyManyToOne comp;
	
	
	
}
