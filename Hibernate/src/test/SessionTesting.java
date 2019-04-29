package test;

import org.hibernate.query.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.Vehicle;

public class SessionTesting {

	public static void main(String args[]) {
		
		Configuration cf = new Configuration().configure();

		SessionFactory sf = cf.buildSessionFactory();
		Session s = sf.openSession();
		Session s1 = sf.openSession();
		
		Vehicle v = new Vehicle();
		
		//only one query even if we selected two times
		//this is first level cache and this will be inside session olyS
		System.out.println(s.get(Vehicle.class, 1).getVehicleId()+s.get(Vehicle.class,1).getVehicleId());
		
	}
	
}
