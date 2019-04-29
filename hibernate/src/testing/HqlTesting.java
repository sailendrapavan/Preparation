package testing;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.Chatbot;
import hibernate.NewMovie;

public class HqlTesting {
	
	public static void main(String args[]) {
		
		Configuration cf = new Configuration();
		cf.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cf.buildSessionFactory();
		Session s = sf.openSession();
		//select query 
//		Query q= s.createQuery("from NewMovie");
//		List<Chatbot> n  = q.list();
//		for(Chatbot i : n)
//		{
//			System.out.println(i.getSkylight());
//			
//		}
		
		//why insert Query is expecting commit ?(Oracle doesn't need)?
		Transaction tr=s.beginTransaction();
//		Query q = s.createQuery("insert into NewMovie(sid,name,movieTiming) select s.id,s.movie,s.showtime from Movie s"); 
//             int i   = q.executeUpdate();
//             System.err.println(i);
//             tr.commit();
		
		
		//update we can update primary key values also
//		Query q = s.createQuery("update NewMovie set name='f' where sid=2"); 
//      int i   = q.executeUpdate();
//      System.err.println(i);
//      tr.commit();
		
		//delete command 
//		Query q = s.createQuery("delete NewMovie where sid=2"); 
//		int i   = q.executeUpdate();
		
		//select query for single row no need of commit as we are just retrving data
//		Query q = s.createQuery("from NewMovie"); 
//        NewMovie n  =(NewMovie) q.uniqueResult();
//        System.out.println(n.getMovieTiming());
		
		//if you think your query will result multiple rows then we use list other wise you will get an exception 
		//org.hibernate.NonUniqueResultException:
		
		//mUltiple rows then
//		Query q = s.createQuery("from NewMovie"); 
//      List<NewMovie> n  =(List<NewMovie>) q.list();
//      for (NewMovie d : n) {
//    	  System.out.println(d.getName());
		
		
      
		
		
		
     // tr.commit();
		
             s.close();
             sf.close();
	}

}
