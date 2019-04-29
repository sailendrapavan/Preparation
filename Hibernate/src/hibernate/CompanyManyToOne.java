package hibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class CompanyManyToOne {

	@Id
	@GeneratedValue
	private int companyId;
	private String companyName;
	private String companyLocation;

    @OneToMany
	private Collection<BoardOfMembersManyToOne> m = new ArrayList<BoardOfMembersManyToOne>();
	public Collection<BoardOfMembersManyToOne> getM() {
		return m;
	}

	public void setM(Collection<BoardOfMembersManyToOne> m) {
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
