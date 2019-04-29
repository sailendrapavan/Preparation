package arrays;

public class arrayRotation {

	
	public static void main(String args[]) {
		
		int a[]= new int[] {5,6,7,8,9,1,2};
		int k=3;
		int dummy[]= new int[k];
		for(int i=0;i<k;i++) {
			dummy[i]=a[i];
		}
		for(int i=0;i<a.length-k;i++)
		{
			a[i]=a[i+k];
		}
		for(int i=0;i<k;i++)
		{
		    a[a.length-k]=dummy[i];	
		}
		for(int i=0;i<k;i++)
		{
		    a[a.length-k+i]=dummy[i];	
		}
		for(int i=0;i<a.length;i++)
		{
		    System.out.println(a[i]);
		}
	}
}
