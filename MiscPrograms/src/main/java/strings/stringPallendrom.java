package strings;

public class stringPallendrom {

	
	Boolean Recurssive(String s,int start,int end) {
		
		if(s.charAt(start)!=s.charAt(end))
		{
			return false;
		}
		else
		{
			if(start<end-1)
			{
				return Recurssive(s, start+1, end-1);
			}
			else
			{
				return true;
			}
		    
		}
		
	}
	
	public static void main(String args[]) {
		stringPallendrom pall = new stringPallendrom();
		String s = new String("125643521");
		System.out.println(pall.Recurssive(s, 0, s.length()-1));
//		int i=0;
		
//		for(;i<s.length()/2;i++) {
//			if(s.charAt(i)!=s.charAt(s.length()-1))
//			{
//				break;
//			}
//		}
//		if(i+1==s.length()/2)
//		{
//			System.out.println("pallendrom");
//		}
//		else
//		{
//			System.out.println("not a pallendrom");
//		}
		
		/*another way of doing */
		
		
	}
}
