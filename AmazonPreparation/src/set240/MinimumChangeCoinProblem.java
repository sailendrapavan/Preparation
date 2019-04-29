package set240;
//https://www.techiedelight.com/coin-change-problem-find-total-number-ways-get-denomination-coins/

public class MinimumChangeCoinProblem {
	static int min=Integer.MAX_VALUE;
	int mimmumCoinsRequired(int change[], int sum, int k, int i,int count) {

		
		if(i>4||sum>k) {
			return Integer.MAX_VALUE;
		}
		if (sum == k) {
			return count;
		}
		int d=Integer.MAX_VALUE;
		int c=Integer.MAX_VALUE;
		int e = Integer.MAX_VALUE;
		if (k >= sum + change[i]) {
			c=mimmumCoinsRequired(change, sum + change[i], k, i,count+1);
			if(i+1<change.length) {
			d=mimmumCoinsRequired(change, sum + change[i + 1], k, i + 1,count+1);
			}
			
		}
		else
		{
			e=mimmumCoinsRequired(change, sum, k, i + 1,count);
			
		}
		if(e<d) {
			d=e;
		}
		int x = (c<d)?c:d;
		min=(x<min)?x:min;
		return min;


	}
	
	int count=0;
	int minimunCoinChangeProblemFromGeeksForGeeks(int change[],int m,int sum) {{ 
	       // base case 
	       if (sum == 0) return 0; 
	       
	       // Initialize result 
	       int res = Integer.MAX_VALUE; 
	       
	       // Try every coin that has smaller value than V 
	       for (int i=0; i<m; i++) 
	       { 
	         if (change[i] <= sum) 
	         { 
	             int sub_res = minimunCoinChangeProblemFromGeeksForGeeks(change, m, sum-change[i]); 
	       
	             // Check for INT_MAX to avoid overflow and see if 
	             // result can minimized 
	             if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res) 
	                res = sub_res + 1; 
	         } 
	       } 
	       return res; 
	    } }

	public int minimumCoinBottomUp(int total, int coins[]){
        int T[] = new int[total + 1];
        int R[] = new int[total + 1];
        T[0] = 0;
        for(int i=1; i <= total; i++){
            T[i] = Integer.MAX_VALUE-1;
            R[i] = -1;
        }
        for(int j=0;j<coins.length;j++) {
        	for(int i=1;i<total;i++) {
        		if(i>=coins[j]) {
        			if(T[i]>(T[i-coins[j]]+1)) {
        				T[i]=T[i-coins[j]]+1;
        				R[i]=j;
        			}
        		}
        	}
        }
        printCoinCombination(R, coins);
        return T[total];
    }
	
	//This is brilliant by tushor roy
	private void printCoinCombination(int R[], int coins[]) {
        if (R[R.length - 1] == -1) {
            System.out.print("No solution is possible");
            return;
        }
        int start = R.length - 1;
        System.out.print("Coins used to form total ");
        while ( start != 0 ) {
            int j = R[start];
            System.out.print(coins[j] + " ");
            start = start - coins[j];
        }
        System.out.print("\n");
    }

	public static void main(String args[]) {

		int change[] ={1,3,5,7};
		MinimumChangeCoinProblem min = new MinimumChangeCoinProblem();
		System.out.println(min.minimumCoinBottomUp(6,change));
		
	}

}
