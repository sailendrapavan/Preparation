package testing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.Movie;

public class Movietest {

	public static void main(String args[]) {
		
	
	//Movie ma = new Movie();
//	Movie m1 = new Movie();
//    m1.setMovie("maghadeera");
//    m1.setShowtime("evening");
//	ma.setMovie("dinchak");
//	ma.setShowtime("weekend");
	Configuration cf = new Configuration();
	cf.configure("resources/hibernate.cfg.xml");
	SessionFactory sf = cf.buildSessionFactory();
	Session s = sf.openSession();
	//s.save(ma);
	//s.save(m1);
	//s.beginTransaction().commit();
	}
}
