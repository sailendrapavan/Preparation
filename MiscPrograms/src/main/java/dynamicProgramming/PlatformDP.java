package dynamicProgramming;

public class PlatformDP {
	
	int n=4;
	int count;
	public boolean dpforPlatform(int a[],int sum,int k,int i){
		
		if(i>=n&&sum!=k) {
			return false;
		}
		count++;
		if(k==sum) {
			return true;
		}
		System.out.println(sum+":"+i);

		if(dpforPlatform(a, sum, k, i+1)|dpforPlatform(a, sum+a[i], k,i+1)) {
			return true;
		}
		else {
			return false;
		}
		
	}

	public static void main(String args[]) {
		int a[]= {1,2,35,75};
		PlatformDP dp = new PlatformDP();
		System.out.println(dp.dpforPlatform(a, 0, 113, 0));
		System.out.println(dp.count);
		
		
	}
}
