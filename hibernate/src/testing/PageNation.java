package testing;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.Actor;
import hibernate.Employee;

public class PageNation {
  public static void main(String args[]) {
		Configuration cf = new Configuration();
		cf.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cf.buildSessionFactory();
		Session s = sf.openSession();
		Criteria c = s.createCriteria(Actor.class);
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<3;i++) {
		//using criteria	
		c.setFirstResult(sc.nextInt());
		c.setMaxResults(sc.nextInt());
		List<Actor> list = c.list();
		for(Actor e : list) {
			System.out.println(e.getId());
		}
		
		}
		
		//using hql
//		Query q = s.createQuery("from Actor");
//		
//		Scanner sc = new Scanner(System.in);
//		
//		for(int i=0;i<3;i++) {
//		q.setFirstResult(sc.nextInt());
//		q.setMaxResults(sc.nextInt());
//		
//		List<Actor> list = q.list();
//		for(Actor e : list) {
//			System.out.println(e.getId());
//		}
//		}
		
  }
}
