package hibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
@Entity
public class CompanyOneToMany {
	 @Id
	    @GeneratedValue
		private int companyId;
	    private String companyName;
	    private String companyLocation;
	    @OneToMany(cascade=CascadeType.PERSIST)
	    //third table is used to map two tables....so properties of third table can be set
	    @JoinTable(name="dummy", joinColumns=@JoinColumn(name="companyPrimaryKey"), 
	      inverseJoinColumns=@JoinColumn(name="BoardOfMemembersPrimaryKey"))
		private Collection<BoardOfMembersOneToOne> mem = new ArrayList<BoardOfMembersOneToOne>();

		public Collection<BoardOfMembersOneToOne> getMem() {
			return mem;
		}
		public void setMem(Collection<BoardOfMembersOneToOne> mem) {
			this.mem = mem;
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
