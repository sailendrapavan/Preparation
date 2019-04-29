package testing;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.Chatbot;
public class sample {

	public static void main(String args[]) {
	Chatbot a = new Chatbot();
	a.setDummy("dumy@gmail.co");
	a.setJira("sdssd");;
	a.setPortal("hibernate");
	a.setSkylight("11d");
	a.setTest("11");
	Configuration cfg = new Configuration();
	cfg.configure("resources/hibernate.cfg.xml");
	SessionFactory sf = cfg.buildSessionFactory();

	Session s = sf.openSession();
	s.update(a);


//    ArrayList<Long> a = new ArrayList<Long>();
//    char 
//    a.add((long) 2);
//    a.add((long)1);
//    a.add((long)4);
//    a.add((long)3);
//    a.add((long)2);
//    a.add((long)5);
//    a.add((long)1);
//    a.add((long)1); 8101 2443888
//    a.add((long)2);
//    a.add((long)1);
//   
//	Long min=(long)12;
//	Long sum=(long)12;
//	for (int i=1;i<a.size();i++)
//	{
//		int n=a.size()/2;
//		System.out.println("removing"+(i-1));
//		System.out.println("adding"+((i-1)+(n))%a.size());
//        sum=sum-a.get(i-1)+a.get(((i-1)+(n))%a.size());
//        System.out.println("sum"+sum);
//		if(sum<min)
//		{
//			min=sum;
//		}
//		
//	}
//	Stream.iterate(new int[]{2,3},
//			t-> new int[]{arr[1],arr[0]+arr[1]}) 
//	    limit(10).map(arr->arr[0]).forEach(System.out::println);
//	System.err.println(min);
//	}
//	
//	Stream.
	}
}
