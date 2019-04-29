package hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity (name="user_detail")
/*@Table (name="")
 * if you want to change the name of table....we will see later in detail
 */
public class UserDetails {
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column (name="user_id")
	private int userId;
	@Column (name="user_nam")
	private String userName;
	@Lob
	private String address;
	@Transient
	private String descriptio;
	
	@Temporal (TemporalType.TIME)
	private Date date;
	
    @ElementCollection (fetch=FetchType.EAGER)
    @JoinTable (name="dummy", 
		joinColumns=@JoinColumn(name="user_id")
    		)
    @GenericGenerator(name="sequence-gen",strategy="increment")
    @CollectionId (columns = {@Column(name="primaryKey")}, generator= "sequence-gen", type = @Type(type="long")  )
    private Collection<Address>  listOfAddress = new ArrayList<Address>() ;
	public Collection<Address> getListOfAddress() {
		return listOfAddress;
	}

	public void setListOfAddress(Collection<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}
	/***********************************
	/* stores the collection of address instances a separate(named with userdetils_listofaddress) table is created
	 * and primary key of this class is used as foreign key in address table***********/
     
	// @ElementCollection
	
    /******On of the use of join table is to name the table name instead of predefined
     * table by hibernate************/
    /***********We can override the column name of foreign key name by using 
     * the below annotation*****/
	
    /*@JoinTable (name="dummy", 
      		joinColumns=@JoinColumn(name="user_id")
    )
	private Set<Address> listOdAddress = new HashSet<>();
  
	public Set<Address> getListOdAddress() {
		return listOdAddress;
	}

	public void setListOdAddress(Set<Address> listOdAddress) {
		this.listOdAddress = listOdAddress;
	}*/
    /*
     * If you want to embed an another class in this class then the
     * below implementation is used if you want to overrides the values
     * The we should use attribute overrdie
     * A single table is created with all the values including the embeded
     * columns too..
     */
    
//	@AttributeOverrides({
//		@AttributeOverride(name ="street",column=@Column(name="st")),
//		@AttributeOverride(name ="phone",column=@Column(name="ph"))
//	})
//  single table is created with all the collumns 
//  we can define @Embedded or can define @eembedabble in address clas    
//	private Address addr;
//	
//	public Address getAddr() {
//		return addr;
//	}
//
//	public void setAddr(Address addr) {
//		this.addr
	
//	}

   
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescriptio() {
		return descriptio;
	}

	public void setDescriptio(String descriptio) {
		this.descriptio = descriptio;
	}


    
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
