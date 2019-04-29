package testing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.Software;

public class ISArelation {

	public static void main(String args[]) {
		
		Configuration cf = new Configuration();
		cf.configure("resources/hibernate.cfg.xml");
	    SessionFactory sf= cf.buildSessionFactory();
	    Session s= sf.openSession();
	    Transaction t = s.beginTransaction();
	    Software soft = new Software(4, "sailendra.pavan@gmail.com", "100000", "sailendra", "2");
	    
	    s.save(soft);
	    t.commit();
		
	}
}
