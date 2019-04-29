import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

public class vector {

	
	public static void main() {
		
		Vector<Integer> v = new Vector<Integer>();
		Enumeration<Integer> enu =v.elements();
	
		while(enu.hasMoreElements())
		{
		    System.out.println(enu.nextElement());
		}
		
				}
}
