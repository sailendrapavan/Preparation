

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Priorityqueue {

	public static void main(String[] args) {
		
		//natural ordering example of priority queue
		Queue<Integer> integerPriorityQueue = new PriorityQueue<>(7);
		Random rand = new Random();
//		for(int i=0;i<7;i++){
//			integerPriorityQueue.add(new Integer(rand.nextInt(100)));
//		}
//		for(int i=0;i<7;i++){
//			Integer in = integerPriorityQueue.poll();
//			System.out.println("Processing Integer:"+in);
//		}
		
		//PriorityQueue example with Comparator
		Queue<Customer> customerPriorityQueue = new PriorityQueue<>(7, idComparator);
		addDataToQueue(customerPriorityQueue);
		
		pollDataFromQueue(customerPriorityQueue);
		
		
		Comparator<Integer> compr = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return (o1.intValue()-o2.intValue());
			}
			
			
		};
		Queue<Integer> queu= new PriorityQueue<>(compr);
        
		queu.add(1);
		queu.add(3);
		queu.add(6);
		queu.add(14);
		queu.add(2);
		queu.add(4);
		
		Iterator<Integer> utr= queu.iterator();
		while(utr.hasNext())
		{
		System.out.println("mycode"+utr.next());
		}
		
		System.out.println("size"+queu.size());
		
	
		
		while(queu.size()!=0)
		{
			System.out.println("mycode"+queu.remove());
		}
	}
	
	//Comparator anonymous class implementation
	public static Comparator<Customer> idComparator = new Comparator<Customer>(){
		
		@Override
		public int compare(Customer c1, Customer c2) {
            return (int) (c2.getId()-c1.getId());
        }
	};

	//utility method to add random data to Queue
	private static void addDataToQueue(Queue<Customer> customerPriorityQueue) {
		Random rand = new Random();
		for(int i=0; i<7; i++){
			int id = rand.nextInt(100);
			customerPriorityQueue.add(new Customer(id, "Pankaj "+id));
		}
	}
	
	//utility method to poll data from queue
	private static void pollDataFromQueue(Queue<Customer> customerPriorityQueue) {
		while(true){
			Customer cust = customerPriorityQueue.poll();
			if(cust == null) break;
			System.out.println("Processing Customer with ID="+cust.getId());
		}
	}

}