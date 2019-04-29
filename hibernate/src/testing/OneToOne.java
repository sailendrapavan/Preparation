package testing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.Actor;
import hibernate.Vote;
import hibernate.Voter;

public class OneToOne {
	public static void main(String args[]) {
		Configuration cf = new Configuration();
		cf.configure("resources/hibernate.cfg.xml");
		SessionFactory sf= cf.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		Voter v = new Voter();
		v.setVid(123);
		v.setAge(18);
		v.setVname("sailendta");
		
		Vote vv = new Vote();
		vv.setPname("prp");
		vv.setVoter(v);
		
		s.save(v);
		s.save(vv);
		t.commit();
	
}
}
