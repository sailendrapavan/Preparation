package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.BoardOfMembersOneToOne;
import hibernate.CompanyOneToMany;

public class TestOnToMany {
	public static void main(String args[]) {
		Configuration cf = new Configuration().configure();

		SessionFactory sf = cf.buildSessionFactory();
		Session s = sf.openSession();
		BoardOfMembersOneToOne bd = new BoardOfMembersOneToOne();
		bd.setName("shanker");
		BoardOfMembersOneToOne bd1 = new BoardOfMembersOneToOne();
		bd1.setName("Ramesh");
		CompanyOneToMany c = new CompanyOneToMany();
		c.setCompanyName("urjanet");
		c.setCompanyLocation("chennai");
		c.getMem().add(bd);
		c.getMem().add(bd1);
//		s.save(bd1);
//		s.save(bd);
		s.persist(c);
		/**
		 * if you want to save all dependent objects we should use cascade option in CompanyOneToMany and use persist instead of save
		 * 
		 * Check why ?
		 */
		s.beginTransaction().commit();
		s.close();
		
		/*It creates three tables one for 
		 * BoardOfMembersOneToOne
		 * CompanyOneToMany
		 * CompanyOneToMany_BoardOfMembersOneToOne
		 * This third has a relation between the above two tables;
		 */
	}
}
