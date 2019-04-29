package testing;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.Actor;
import hibernate.Movies;

public class HASARelation {

	//one to many
	public static void main(String args[]) {
		Configuration cf = new Configuration();
		cf.configure("resources/hibernate.cfg.xml");
		SessionFactory sf= cf.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		Actor a = new Actor();
		a.setActorName("sailendra");
		a.setId(124);
		Movies m = new Movies();
		m.setMovieId(124);
		m.setMovieName("pk");
		Movies m1 =new Movies();
		m1.setMovieId(99);
		m1.setMovieName("kp");
		Set<Movies> mov = new HashSet<Movies>();
		mov.add(m);
		mov.add(m1);
		a.setMovies(mov);
		// the below two are not needed if we apply cascade all in actor configuration file
		s.saveOrUpdate(m1);
		s.saveOrUpdate(m);
		s.saveOrUpdate(a);
/*he main dis advante i have seen in this code is
 * example
 * actor id 1
 * moive 1 
 * Movie 2
 * 
 * If we use saveorupdate  and set actor id as 1 and movie 3 movie 4
 * then previous movies realted to actore 1 will loose thier link 
 * (movie 1,movie 2) foriegn keys become null
 * 
 * How to overcome
 * Not sure but get all the existing movies related to actor and add new ot it
 * 
 * Find the best way
 */
       
		t.commit();
		
		s.close();
		sf.close();
	}
}
