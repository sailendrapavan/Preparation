package dynamicProgramming;

import java.util.ArrayList;

public class BuyingStocksProblem {

	class Interval  
	{ 
	    int buy, sell; 
	} 
	
	public void butStocks(int a[],int n) {
        if (n == 1) 
            return; 
          
        int count = 0; 
  
        // solution array 
        ArrayList<Interval> sol = new ArrayList<Interval>();
		int i=0;
		
		while(i<n-1) {
			
			while(i<n-1&&a[i]>=a[i+1]) {
				i++;
			}
			if(i==n-1)
				break;
			Interval e = new Interval(); 
	        e.buy = i++;
	        
	        while(i<n&&a[i]>=a[i-1]) {
	        	i++;
	        }
	        
	        e.sell=i-1;
	        sol.add(e);
	        
	        count++;
		}
		if (count == 0) 
            System.out.println("There is no day when buying the stock "
                                                  + "will make profit"); 
        else 
            for (int j = 0; j < count; j++) 
                System.out.println("Buy on day: " + sol.get(j).buy 
                        +"        " + "Sell on day : " + sol.get(j).sell); 
          
        return; 
	}
	
	public static void main(String args[]) {
		
        int a[] = {100, 180, 260, 310, 40, 535, 695}; 
        int n = a.length; 
        BuyingStocksProblem b = new BuyingStocksProblem();
        b.butStocks(a, n);
	}
}
