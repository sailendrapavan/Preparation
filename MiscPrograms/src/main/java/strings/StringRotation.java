package strings;

public class StringRotation {

	
	public static void main(String args[]) {
		
		String s = new String("ABAD");
		String s1 = new String("ADAB");
//		int i=0;
//       for(i=0;i<s.length();i++) {
//    	   if(s1.charAt(i)==s.charAt(0))
//    	   {
//    		   break;
//    	   }
//       }
//       int j=0;
//      for(;j<s.length();j++)
//      {
//    	  if(s.charAt(j)!=s1.charAt((j+i)%(s1.length()))) {
//    		  break;
//    	  }
//      }
//    
//      if(j==s.length())
//      {
//    	  System.out.println("yes");
//      }
//      else
//      {
//    	  System.out.println("no");
//      }
		
		
		//we can do other way around
		
		if((s+s).contains(s1))
		{
			System.out.println("yes");
		}
		else
		{
			System.out.println("no");

		}
      
	}
}
