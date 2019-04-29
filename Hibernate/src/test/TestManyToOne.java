package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import hibernate.BoardOfMembersManyToOne;
import hibernate.CompanyManyToOne;

public class TestManyToOne {
	public static void main(String args[]) {
		Configuration cf = new Configuration().configure();
		CompanyManyToOne c = new CompanyManyToOne();
		c.setCompanyName("urjanet");
		c.setCompanyLocation("chennai");
		SessionFactory sf = cf.buildSessionFactory();
		Session s = sf.openSession();
//		BoardOfMembersManyToOne bd = new BoardOfMembersManyToOne();
//		bd.setName("Rah");
//		BoardOfMembersManyToOne bd1 = new BoardOfMembersManyToOne();
//		bd1.setName("Tests");
//		bd.setComp(c);
//		c.getM().add(bd);
//		c.getM().add(bd1);
//
//
//		s.save(bd1);
//		s.save(bd);
//		s.save(c);
		
		Query q=s.createQuery("select comp from BoardOfMembersManyToOne where name like 'Te'");
		CompanyManyToOne ff=(CompanyManyToOne)q.uniqueResult();
		System.out.println(ff.getCompanyId());
		s.beginTransaction().commit();
		s.close();

		/*
		 * It creates three tables one for BoardOfMembersOneToOne CompanyOneToMany
		 * CompanyOneToMany_BoardOfMembersOneToOne This third has a relation between the
		 * above two tables;
		 */
	}
}
