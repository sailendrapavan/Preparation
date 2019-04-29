package testing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.ActorManyToOne;
import hibernate.MovieManyToOne;

public class ManyToOne {
	public static void main(String args[]) {
		Configuration cf = new Configuration();
		cf.configure("resources/hibernate.cfg.xml");
		SessionFactory sf= cf.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		MovieManyToOne mov = new MovieManyToOne();
		MovieManyToOne movone = new MovieManyToOne();

		//when we do like this foreign key will be null so i guesss we need to add constraint as not null 
//		mov.setMovieId(11);
//		mov.setMovieName("sail");
//		s.save(mov);
//		t.commit();
		ActorManyToOne a = new ActorManyToOne();
		a.setActorName("vishnu");
		a.setId(1);
		mov.setId(a);
		mov.setMovieId(14);
		mov.setMovieName("sail");
		movone.setId(a);
		movone.setMovieId(15);
		mov.setMovieName("sail");
		s.save(a);
		s.save(movone);
		s.save(mov);
		t.commit();
		
				
	}
	
	
}
