package hibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class BoardOfMembersManyToMany {
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
	
	public Collection<CompanyManyToMany> getComp() {
		return comp;
	}
	public void setComp(Collection<CompanyManyToMany> comp) {
		this.comp = comp;
	}
	@ManyToMany(mappedBy="m")
	private Collection<CompanyManyToMany> comp = new ArrayList<CompanyManyToMany>();
	
	
}
