package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.UserDetails;
import hibernate.Vehicle;

public class CurdOperations {

	
	public static void main(String args[]) {
		
		Configuration cf = new Configuration().configure();

		SessionFactory sf = cf.buildSessionFactory();
		Session s = sf.openSession();
		
		Vehicle u = new Vehicle();
		
	/***
	 * 	u.setVechicleName("carru");
	 * 
	 * upto here objet is transaient 
	 * 
	 * From below it is persistent object 
	 * 
		s.save(u);
		
//		any changes after this will go as update statement
 * 
		u.setVechicleName("hha");
		
		u.setVechicleName("sfws");
		
		
		s.beginTransaction().commit();
		
		here vehicle name will be haha even it is after save operation
	 * 
	 * 	
	 */
		
		/**
		 * 
		 * No transinet state
		 * Vehicle ff=(Vehicle)s.get(Vehicle.class, 2);
		persist state
		ff.setVechicleName("updateed macha");
		s.save(ff);
		ff.setVechicleName("finalre");
		
		Here after save i have changed the name then it an update query is raised
		 */

	
		//Detached to perisitence
		
		
		/**
		 * Vehicle ff=(Vehicle)s.get(Vehicle.class, 2);
		 *
		   s.beginTransaction().commit();
		   s.close();
		   in between user updated the  name we can save the object and move 
		   the object to detached state....(Still ff  object is there in 
		   program stack)
		    
		   ff.setVechicleName("finalre");
            
		   Session s = sf.openSession();
		   s.beginTransacstion().commit();
		   s.update(ff);

		 */
		
	/*Even if we dont change object it will update as we wrote update
	to overcome this add annotation @org.hibernate.annotations.Entity(selectBeforeUpdate=true)

	so first is selects the row if there is any change then update is triggered**/ 
		

		/**
		 * From here it will become detached object
		 * 
		 */
		sf.close();
		
		

	}
}
