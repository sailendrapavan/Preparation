import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListInternals {

	
	public static void main(String args[]) {
		
		List<Integer> d = new ArrayList<Integer>();
		d.add(1);
		d.add(2);
		d.add(3);
		d.add(4);
		//d.add("ss");
//		d.add("ss");
//		//d.remove(2);
//		System.out.println(d.indexOf("ss"));
		Iterator<Integer> itr= d.iterator();
//		itr.next();
//		itr.remove();

		
		while(itr.hasNext())
		{
			if(itr.next()==2) {
				itr.remove();
				System.out.println("jj");
			}
		}
		
		
//		for(int i=0;i<d.size();i++)
//		{
//			if(d.get(i)==2)
//			d.remove(new Integer(2));
//		}
		for(int i=0;i<d.size();i++)
		{
			System.out.println(d.get(i));
		}
	}
}
