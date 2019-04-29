package test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.BoardOfMembersManyToMany;
import hibernate.BoardOfMembersManyToOne;
import hibernate.CompanyManyToMany;
import hibernate.CompanyManyToOne;

public class ManyToMany {
	public static void main(String args[]) {
		Configuration cf = new Configuration().configure();
		CompanyManyToMany c = new CompanyManyToMany();
		c.setCompanyName("urjanet");
		c.setCompanyLocation("chennai");
		CompanyManyToMany c1 = new CompanyManyToMany();
		c1.setCompanyName("urjanet");
		c1.setCompanyLocation("atlanta");
		SessionFactory sf = cf.buildSessionFactory();
		Session s = sf.openSession();
		BoardOfMembersManyToMany bd = new BoardOfMembersManyToMany();
		bd.setName("shanker");
		BoardOfMembersManyToMany bd1 = new BoardOfMembersManyToMany();
		bd1.setName("Ramesh");
		c.getM().add(bd1);
		c.getM().add(bd);
		c1.getM().add(bd1);
		c1.getM().add(bd);
		bd.getComp().add(c);
		bd.getComp().add(c1);
		bd1.getComp().add(c1);
		bd1.getComp().add(c);
		s.save(c);
		s.save(bd1);
		s.save(bd);
		
		s.save(c1);
		s.beginTransaction().commit();
		s.close();

		/*
		 * It creates four tables one for BoardOfMembersManyToMany CompanyManyToMany
		 * CompanyOneToMany_BoardOfMembersOneToOne This third has a relation between the
		 * above two tables and fourth table BoardOfMembersManyToMany_CompanyManyToMany
		 * 
		 * The fourth is unnecessary as both third and fourth are same redundant mapping
		 * To overcome this we used 	@ManyToMany(mappedBy="m")
		 * Means we are telling BoardOfMembersManyToMany not to map company......as company is mapping board of members 
		 */
	}
}
