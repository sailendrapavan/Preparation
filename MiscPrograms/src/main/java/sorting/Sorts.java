package sorting;


public class Sorts {
	
	void selectionSort(int a[]) {
		
		for(int i=0;i<a.length-1;i++)
		{
			int min = a[i];
			int minIndex=i;
			for(int j=i+1;j<a.length;j++)
			{
				if(min>a[j])
				{
					minIndex=j;
					min=a[j];
				}
			}
			int temp=a[minIndex];
			a[minIndex]=a[i];
			a[i]=temp;
		}
	}
	
	
	void selectionSortRecurssive(int a[],int index,int n) {
		
		if(index==n)
		{
			return;
		}
		int exchangeIndex=minIndex(a,index,n);
	      if (exchangeIndex != index){ 
	           // swap 
	           int temp = a[exchangeIndex]; 
	           a[exchangeIndex] = a[index]; 
	           a[index] = temp; 
	        } 
		
	      selectionSortRecurssive(a,index+1,n);
	}
	
	int minIndex(int a[], int i, int j) 
    { 
        if (i == j) 
            return i; 
       
        int k = minIndex(a, i + 1, j); 
       
        return (a[i] < a[k])? i : k; 
    } 
	
	public static void main(String args[])
	{
	 Sorts s = new Sorts();
     int a[]= {1,8,6,5,7};
     s.selectionSortRecurssive(a,0,a.length-1);
     for(int i=0;i<a.length;i++)
     {
    	 System.err.println(a[i]);
     }
	}
	
	
}
