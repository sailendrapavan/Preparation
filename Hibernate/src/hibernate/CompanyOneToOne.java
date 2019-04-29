package hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class CompanyOneToOne {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int companyId;
    private String companyName;
    private String companyLocation;
    @OneToOne
	private BoardOfMembersOneToOne mem;

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
    public BoardOfMembersOneToOne getMem() {
		return mem;
	}
	public void setMem(BoardOfMembersOneToOne mem) {
		this.mem = mem;
	}

    
}
