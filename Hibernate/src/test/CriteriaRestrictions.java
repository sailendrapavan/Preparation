package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import hibernate.Vehicle;

public class CriteriaRestrictions {

	public static void main(String args[]) {

	Configuration cf = new Configuration().configure();

	SessionFactory sf = cf.buildSessionFactory();
	Session s = sf.openSession();
	Criteria c = s.createCriteria(Vehicle.class);
	
	/**
	 * 
	 * We can create an example object and if we give to hibernate it will get similar objects to results
	 * 
	 * It ignores and give all the result set if you give null values or if you give only primary key without any other parameter
	 * example v.setVehicleId(5);
	 * It returns all the values
	 * 
	 * if you dont set any values to example then also it all rows will return
	 */
	Vehicle v = new Vehicle();
	v.setVechicleName("carru");
	v.setVehicleId(5);
	Example ex = Example.create(v);
	c.add(ex);
	
	
	//Restriction or clause
	//c.add(Restrictions.or(Restrictions.between("", "", ""),Restrictions.between("", "", "")));
	//c.add(Restrictions.eq("vehicleId", 5));
	//below is adding of projection
	//c.setProjection(Projections.property("vehicleId"));
	//sorting
	//c.addOrder(Order.desc("vehicleId"));
	
	List<Vehicle> l=c.list();
	for(Vehicle i :l)
	{
		System.out.println(i.getVechicleName());
	}
	
	}
}
