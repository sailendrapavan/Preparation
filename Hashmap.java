import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Hashmap {

	public static void main(String args[]) {
		
		HashMap<String,Integer> a = new HashMap<String,Integer>();
	
		ArrayList<String> li = new ArrayList<String>(Arrays.asList("a","a","g","b","g","g"));
		
		for(String i:li) {
			if(a.get(i)==null)
			{
				a.put(i, 1);
			}
			else
			{
				a.put(i,a.get(i)+1);
			}
		}
		
//		for(Entry<String, Integer> i: a.entrySet())
//		{
//			System.out.println(i);
//		}
		
		
		Iterator<Entry<String, Integer>> it= a.entrySet().iterator();
		while(it.hasNext()) {
			
			System.out.println(((Map.Entry<String, Integer>)it.next()).getValue());
		}
		
		for(Map.Entry element: a.entrySet()) {
			
			System.out.println(element.getKey());
			System.out.println(element.getValue());
		}
 	}
}
