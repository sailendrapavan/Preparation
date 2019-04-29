package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.FourWeeler;
import hibernate.TwoWeeler;
import hibernate.Vehicle;

public class TestIsa {
	

	
	public static void main(String args[]) {
		
		TwoWeeler t = new TwoWeeler();
		FourWeeler f = new FourWeeler();
		Vehicle v = new Vehicle();
		t.setVechicleName("bike");
		t.setHandleBar("yes it has");
		f.setVechicleName("car");
		f.setSteering("yes it haas streering");
		Configuration cf = new Configuration().configure();
/***
 * 
 * A single table is created and all sub class properties are added 
 * This is called single table strategy
 * It is least normalised...some colums have null
 * Here all sub-classes are mentioned entity no seperate table is created
 * by default DTYPE a column is added this tells which sub class it belongs to
 * 
 * TABLE_PER_CLASS
 * Slightly normalised
 * Two seperate tables
 * 
 * More normalised
 * Three tables 
 * Vehicle has vehicleName and id
 * Four weeler and two weeler has forigeg key (primary key of vehicle)
 * 
 */
		SessionFactory sf = cf.buildSessionFactory();
		Session s = sf.openSession();
		s.save(t);
		s.save(f);
		s.beginTransaction().commit();
		s.close();
		sf.close();
	}
}
