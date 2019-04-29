package testing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.Chatbot;

public class updateTest {
	
	public static void main(String args[]) {
	Chatbot a = new Chatbot();
	Configuration cfg = new Configuration();
	cfg.configure("resources/hibernate.cfg.xml");
	SessionFactory sf = cfg.buildSessionFactory();
	Session s = sf.openSession();
//   Object o= s.load(Chatbot.class, "ss");
//   Chatbot ct = (Chatbot) o;  
//   System.out.println(ct.getSkylight());
//
//   System.out.println(ct.getDummy());

//	a.setDummy("dumy@gmail.co");
//	a.setJira("sdssd");
//	a.setPortal("hibernate");
//	a.setSkylight("11dd");
//	a.setTest("1");
//
//	s.merge(a);
	s.beginTransaction().commit();
	
	
	}
}
