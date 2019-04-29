package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.BoardOfMembersOneToOne;
import hibernate.CompanyOneToOne;

public class TestOneToOne {
	
    public static void main(String args[]) {
		Configuration cf = new Configuration().configure();

    	SessionFactory sf = cf.buildSessionFactory();
		Session s =sf.openSession();
	   	BoardOfMembersOneToOne bd = new BoardOfMembersOneToOne();
    	bd.setName("shanker");
    	CompanyOneToOne c=  new CompanyOneToOne();
     	c.setCompanyName("urjanet");
    	c.setCompanyLocation("chennai");
    	c.setMem(bd);
    	
    	
    	//If you change the order one extra hql update will differ
    	
    	/*****
    	 * s.save(c);
    	   s.save(bd);
    	 * Hibernate: select next_val as id_val from hibernate_sequence for update
		   Hibernate: update hibernate_sequence set next_val= ? where next_val=?
		   Hibernate: select next_val as id_val from hibernate_sequence for update
		   Hibernate: update hibernate_sequence set next_val= ? where next_val=?


    	s.save(bd);
    	s.save(c);
		   Hibernate: insert into CompanyOneToOne (companyLocation, companyName, mem_id, companyId) values (?, ?, ?, ?)
		   Hibernate: insert into BoardOfMembersOneToOne (name, id) values (?, ?)
		   Hibernate: update CompanyOneToOne set companyLocation=?, companyName=?, mem_id=? where companyId=?
    	 */
    	s.save(c);
    	s.save(bd);
/*
 * Hibernate: insert into BoardOfMembersOneToOne (name, id) values (?, ?)
Hibernate: insert into CompanyOneToOne (companyLocation, companyName, mem_id, companyId) values (?, ?, ?, ?)
 */
    	s.beginTransaction().commit();
    	s.close();
    	//primary key of BoardOfMembersOneToOne will be used as 
    	
    }
}
