package testing;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import hibernate.NewMovie;

public class CriteriaExample {

	public static void main(String args[]) {
		Configuration cf = new Configuration();
		cf.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cf.buildSessionFactory();
		Session s = sf.openSession();
		
		//select command using criteria
		Criteria cr=s.createCriteria(NewMovie.class);
//		List<NewMovie> dd =cr.list();
//		
//		for(NewMovie d :dd)
//		{
//			System.out.println(d.getName());
//		}
		
		//restrictons 
		Criteria cr1=s.createCriteria(NewMovie.class);
		Criterion c1 = Restrictions.eq("sid", 3);
//		cr.add(c1);
//		NewMovie ob=(NewMovie)cr.uniqueResult();
//		System.out.println(ob.getName());
		
		
		//Projections
//		Criteria cr=s.createCriteria(NewMovie.class);
//		Criterion c1 = Restrictions.eq("sid", 3);
//		Projection p = Projections.property("name");
//		cr.setProjection(p);
//		cr.add(c1);
//		String ob=(String)cr.uniqueResult();
//		System.out.println(ob);
		
		//we cant add multiple projections using setProjection it will override so for that we should use projection list
		
//		Criteria cr=s.createCriteria(NewMovie.class);
//		Criterion c1 = Restrictions.gt("sid", 1);
//		ProjectionList p = Projections.projectionList();
//		Projection p1= Projections.property("name");
//		Projection p2= Projections.property("movieTiming");
//        p.add(p1);
//        p.add(p2);
//        cr.add(c1);
//        cr.setProjection(p);
//        List<Object[]> ob=(List<Object[]> )cr.list();
//        for(Object[] d :ob)
//    		{
//    			System.out.println(d[0]);
//    			System.out.println(d[1]);
//
//    		}
		
		
		//Aggregate Functions
		Criteria cr=s.createCriteria(NewMovie.class);
		Projection p1= Projections.avg("sid");
		cr.setProjection(p1);
		Double d =(Double)cr.uniqueResult();
		System.out.println(d);
	}
}
