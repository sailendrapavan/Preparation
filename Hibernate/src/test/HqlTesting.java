package test;

import java.util.List;

import javax.persistence.NamedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.query.Query;

import hibernate.Vehicle;

public class HqlTesting {

	
	public static void main(String args[]) {
		
		Configuration cf = new Configuration().configure();

		SessionFactory sf = cf.buildSessionFactory();
		Session s = sf.openSession();
		//Query q =s.createQuery("select new map(vehicleId,vechicleName)from Vehicle");
				//check how to use map
		String number="100 or 1 = 1";//sql injection may occur so hacker gets all details
		//sql injection is not working if we use parameter binding concept....but dig into it why it is happening
		//Query q =s.createQuery("from Vehicle where vehicleId >"+number);
		Query q =s.createQuery("from Vehicle where vehicleId > ?0");
		Criteria cm= s.createCriteria(HqlTesting.class);
		Projection p = Projections.property("");
		ProjectionList p1 = Projections.projectionList();
		
		SimpleExpression d = Restrictions.eq("", "");
//		q.setString(0, number);
	//	to overcome the above problem we use parameter binding 
		
		/***
		 * 
		 * PageNation
		 * q.setFirstResult(1);
			q.setMaxResults(6);
		 */

		
		/**
		 * 
		 * Named quires
		 * @NamedQuery(name="vehicle.Id",query="from Vehicle where vehicleId = ?")

		 */
		Query q=s.getNamedQuery("vehicle.Id");
		q.setInteger(0, 2);
		
		/**
		 * 
		 * getNamedNativeQuery is used to write sql quiries directly
		 */
		Query q1=s.getNamedNativeQuery("sqlquery");
		q1.setString(0, "2");
		
		
		
		List<Vehicle>  sq  = q1.list();
		for(Vehicle i : sq)
		{
			System.out.println(i.getVechicleName());
		}
		
	}
}
