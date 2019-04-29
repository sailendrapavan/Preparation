import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class ConnectingRooes {

	public static void main(String args[]) {
		
		
		
		Queue<Integer> q = new PriorityQueue<Integer>(Arrays.asList(4,3,2,6,12));
		int sum=0;
		while(q.size()!=1) {
			
			int a=q.poll();
			int b=q.poll();
			q.add(a+b);
		    sum=sum+a+b;
	}
		System.out.println(sum);
}
}
