import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class Treeset {

	public static void main(String args[]) {
		
		TreeSet<Integer> ts = new TreeSet<Integer>();
		ts.add(1);
		ts.add(1);
		ts.addAll(new ArrayList<Integer>(Arrays.asList(8,1,6,9)));
		
		Iterator<Integer> tr = ts.iterator();
//		while(tr.hasNext()) {
//			
//			if(tr.next()==8)
//			{
//				tr.remove();
//			}
//		}
	      
       
		tr=ts.descendingIterator();
		
		while(tr.hasNext()) {
			
			System.out.println(tr.next());
		}

	}

	
}
