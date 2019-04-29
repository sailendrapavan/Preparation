package strings;

public class Patternwithoutusingloop {

	static void tryReccursion(int  n,Boolean flag,int m)
	{
		System.out.println(n);
		if(n>0&&flag==true)
		{
			tryReccursion(n-5,true,16);
		}
		else
		{
			flag=false;
			if(n!=m)
			{
				tryReccursion(n+5,false,16);
			}
		}
		
	}
	
	public static void main(String args[]) {
		
		tryReccursion(16,true,16);
	}
}
