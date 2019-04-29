package multithreading;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerProblem{

	
	public static void main(String args[]) throws InterruptedException {
	 producer prod=new producer();
     //consumer cons=new consumer(prod);
     consumerone consone=new consumerone(prod);

     Thread prodThread=new Thread(prod,"prodThread");
     

     Thread consThreadone=new Thread(consone,"consThreadone");
      Thread consThreadtwo=new Thread(consone,"consThreadtwo");

     
    // consThread.start();  
    // consThreadtwo.start();
     consThreadone.start();
     consThreadtwo.start();
     Thread.sleep(100);      //This minor delay will ensure that consumer thread starts before producer thread.
     prodThread.start();     //start producer thread.
	}
}

class producer implements Runnable{
     
	BlockingQueue<Integer> queue  ;
	//ArrayList<Integer> queue;
	 producer(){
		 queue = new LinkedBlockingQueue<Integer>();
		 //queue=new ArrayList<Integer>();
	}
	@Override
	public void run() {
		
		synchronized (this) {
			System.out.println("producer starts producing");
			
			
			for(int i=0;i<10000;i++)
			{
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				queue.add(i);
			}
			
			System.out.println("producer completed its prodcution");
			
			
			this.notify();
		}
		
	}
	
	
}

class consumer implements Runnable{

	producer prodThread;
	consumer(producer thread){
		prodThread=thread;
	}
	@Override
	public void run() {
		
		
		  synchronized(prodThread) {
			System.out.println("Consumer waiting for production to get over.");
            try{
          
                prodThread.wait(); 
                System.out.println(Thread.currentThread().getName()+"is waiting");
               }catch(InterruptedException e){System.out.println("got a phone caall");}
		  }
	           int productSize=prodThread.queue.size();
	           System.out.println(productSize+"in consumer");
	           for(int i=0;i<productSize;i++)
	                  System.out.println("Consumed by "+Thread.currentThread().getName() + prodThread.queue.remove(0) +" ");  
		  
	}
	
	
}


class consumerone implements Runnable{

	producer prodThread;
	consumerone(producer thread){
		prodThread=thread;
	}
	@Override
	public void run() {
		synchronized (prodThread) {
			System.out.println("Consumer waiting for production to get over.");
            try{
                System.out.println(Thread.currentThread().getName()+"is waiting");

                prodThread.wait();  
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
			
		
		       
	           int productSize=prodThread.queue.size();
	           for(int i=0;i<productSize;i++)
	                  System.out.println("Consumed by "+Thread.currentThread().getName() + prodThread.queue.poll() +" ");  
		
	}
	
	
}

//what happens when we place wait outside of synchronized block 
/*Let's illustrate what issues we would run into if wait() could be called outside of a synchronized block with a concrete example.

Suppose we were to implement a blocking queue (I know, there is already one in the API :)

A first attempt (without synchronization) could look something along the lines below

class BlockingQueue {
    Queue<String> buffer = new LinkedList<String>();

    public void give(String data) {
        buffer.add(data);
        notify();                   // Since someone may be waiting in take!
    }

    public String take() throws InterruptedException {
        while (buffer.isEmpty())    // don't use "if" due to spurious wakeups.
            wait();
        return buffer.remove();
    }
}
This is what could potentially happen:

A consumer thread calls take() and sees that the buffer.isEmpty().

Before the consumer thread goes on to call wait(), a producer thread comes along and invokes a full give(), that is, buffer.add(data); notify();

The consumer thread will now call wait() (and miss the notify() that was just called).

If unlucky, the producer thread won't produce more give() as a result of the fact that the consumer thread never wakes up, and we have a dead-lock.

Once you understand the issue, the solution is obvious: Always perform give/notify and isEmpty/wait atomically.

Without going into details: This synchronization issue is universal. As Michael Borgwardt points out, wait/notify is all about communication between threads, so you'll always end up with a race condition similar to the one described above. This is why the "only wait inside synchronized" rule is enforced.

*/




//inconsistency problem how you will solve?