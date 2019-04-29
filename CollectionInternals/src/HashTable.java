import java.util.Hashtable;

public class HashTable {

	public static void main(String args[]) {
		
        Hashtable h = new Hashtable(); 
        h.put("sailendra", 3);
        h.put(3, 5);
        System.out.println(h.get(3));

	}
}
