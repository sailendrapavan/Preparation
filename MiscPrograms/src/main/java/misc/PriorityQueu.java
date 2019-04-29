package misc;

import java.util.Iterator;
import java.util.PriorityQueue;

class test implements Comparable<test>{
	String key;
	int freq;
	
	test(String key,int freq){
		this.key=key;
		this.freq=freq;
	}
	@Override
	public int compareTo(test o) {
		if(this.freq<o.freq)
		{
			return 1;
			
		}
		else if(this.freq>o.freq)
		{
			return -1;
		}
		return 0;
	}
}
public class PriorityQueu {

	
	public static void main(String args[]) {
		PriorityQueue<test> q = new PriorityQueue<test>();
		test c = new test("g", 5);
		q.add(c);
		c = new test("d", 3);
	    q.add(c);
	    c = new test("a", 2);
	    q.add(c);
	    c = new test("c", 2);
	    q.add(c);
	    c = new test("b", 2);
	    q.add(c);
	    c = new test("f", 1);
	    q.add(c);
	    
	    test prev = new test("#",-1);
	    
	    while(!q.isEmpty())
	    {
	    	test d = q.poll();
	    	System.out.println(d.key);
	    	if(prev.freq>0)
	    	{
	    		q.add(prev);
	    	}

	    	d.freq--;
	    	prev=d;
	    }
       
		
		
		
	}
}

