package hibernate;

import javax.persistence.Cacheable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
@DiscriminatorColumn (name="subclass",discriminatorType=DiscriminatorType.STRING)
/***
 * 
 * @author sailendra
 *@Inheritance(strategy=InheritanceType.SINGLE_TABLE)

 *
 */
//@NamedNativeQuery(name ="sqlquery",query="select * from Vehicle where  vehicleId = ?0",resultClass=Vehicle.class)
//result is used for typecasting object
//@NamedQuery(name="vehicle.Id",query="from Vehicle where vehicleId = ?0")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.TRANSACTIONAL)
public class Vehicle {

    public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVechicleName() {
		return vechicleName;
	}
	public void setVechicleName(String vechicleName) {
		this.vechicleName = vechicleName;
	}
	@Id
	@GeneratedValue
	int vehicleId;
    String vechicleName;
}
