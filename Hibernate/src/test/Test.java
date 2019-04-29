package test;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.Address;
import hibernate.UserDetails;

public class Test {

	
	public static void main(String args[]) {
		UserDetails u = new UserDetails();
	    Address a = new Address();
	    a.setPhone("a");
	    a.setPhone("p");
	    Address a1 = new Address();
	    a1.setPhone("d");
	    a1.setPhone("w");
		u.setUserName("sailendra");
		u.setAddress("chennai");
		u.setDescriptio("dd");
	    u.getListOfAddress().add(a);
	    u.getListOfAddress().add(a1);
		u.setDate(new Date());
		Configuration cf = new Configuration().configure();
		
		SessionFactory sf = cf.buildSessionFactory();
		Session s =sf.openSession();
		s.save(u);
		s.beginTransaction().commit();
		s.close();
		Session s1 = sf.openSession();
		UserDetails us=(UserDetails) s1.get(UserDetails.class, 1);
		System.out.println(us.getUserId());
		/*we think that we got an entire object and close the session
		 * But by default we get only first level objects but not embeded objects 
		 * these second level will get the values lazyly when ever they called 
		 * so here session is closed and expcetion is thrown 
		 * To overcome this change the ftech strategys
		 */
		s1.close();
		System.out.println(us.getListOfAddress().size());
		
		
		
	}
}
