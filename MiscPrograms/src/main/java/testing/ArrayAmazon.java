package testing;

public class ArrayAmazon {
	public static void main(String args[])
	{
	    int a[] = { 7, 7, 8, 8, 9, 1, 1, 4, 2, 2 ,11,10,10 }, i = 1, m = 13;
	    // int a[]={7, 8, 8, 9, 1, 1, 4, 2, 2, 7}, i=1, m=10;
	 
	    if (a[0] == a[m - 1]) {
	        i = 2;
	        m = m - 1;
	    }
	 
	    for (; i < m; i++)
	        if (a[i] == a[i - 1])
	        {
	        	System.out.println(a[i]+"and"+a[i-1]);
	            i++;
	        }
	        else
	            System.out.println("for"+i+""+a[i - 1]);
	 
	}
}
