package testing;

import java.util.Scanner;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.Actor;

public class SessionLevelCache {

	public static void main(String args[]) {
		
		Configuration cf = new Configuration();
		cf.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cf.buildSessionFactory();
		Session s = sf.openSession();
//		Actor a=(Actor)s.get(Actor.class, 1);
//		//here only one time query if fired as already object is there in the session
//		System.out.println(a.getId());
//		System.out.println(a.getId());
//		Session s1 = sf.openSession();
//		Actor b=(Actor)s1.get(Actor.class, 1);
//        //As here it is different session new query is fired
//		System.out.println(b.getId());

	//some problem is setting second level cache
		
//query level cache is linked with second level cache so i guess it is also not wokring
//		Query q = s.createQuery("from Actor where id=1");
//		q.setCacheable(true);
//		Query q1 = s.createQuery("from Actor where id=1");
//		q1.setCacheable(true);
//		System.out.println(((Actor)q.uniqueResult()).getActorName());
//		System.out.println(((Actor)q1.uniqueResult()).getActorName());

	}
}
