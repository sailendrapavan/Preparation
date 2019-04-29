package hibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class CompanyManyToMany {
	@Id
	@GeneratedValue
	private int companyId;
	private String companyName;
	private String companyLocation;

    @ManyToMany
	private Collection<BoardOfMembersManyToMany> m = new ArrayList<BoardOfMembersManyToMany>();
	public Collection<BoardOfMembersManyToMany> getM() {
		return m;
	}

	public void setM(Collection<BoardOfMembersManyToMany> m) {
		this.m = m;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyLocation() {
		return companyLocation;
	}

	public void setCompanyLocation(String companyLocation) {
		this.companyLocation = companyLocation;
	}
}
