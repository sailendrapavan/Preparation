package multithreading;


 class even extends Thread{
   public void run() {
		 
		 for(int i=1;i<10;i=i+1)
		 {
			 synchronized (this) {
				 
				System.out.println("even"+i);
				try {
					System.out.println(getState()+"Released lock on and waiting for next turn");	
				    this.wait();
					
					
					Thread.sleep(1000);
				
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				this.notifyAll();
			}
		 }
	 }	
}
 
 class odd extends Thread{
	 even e;
	 odd(even e){
		this.e=e; 
	 }
	 
	 @Override
	 public void run() {
		 
		 for(int i=1;i<10;i=i+2)
		 {
			 synchronized (e) {
				System.out.println("odd"+i);
				try {
					Thread.sleep(1000);
				
			
					e.notifyAll();
			     
			     Thread.sleep(1000);
					e.wait();
					
				}
				 catch (Exception e1) {
					// TODO Auto-generated catch block
					 System.out.println(getState());
					e1.printStackTrace();
				}
			}
		 }
	 }
 }

public class oddEvenWaitNotify {
    public static void main(String args[]) throws InterruptedException {
	even ev = new even();
	odd s = new odd(ev);
	ev.start();
	Thread.sleep(1000);
	s.start();
	
	
    }
	
}
