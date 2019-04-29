package multithreading;


//killing main thread from child thread
public class multithreading {

   public static void main(String args[]) throws InterruptedException  {
	   
	  Thread t= Thread.currentThread();
	  System.out.println("Mater thread itiated by jvm "+t.getName());
	  System.out.println("Mater thread itiated by jvm "+t.getPriority());
      
      test te= new test(t); 
      
      te.start();
      t.sleep(10000);
      System.out.println("main thread");
      
   }
}

class test extends Thread {
    Thread t;
	test(Thread t){
		this.t=t;
	}
   public void run() {
	    t.stop();
	   for(int i=0;i<1000;i++) {
	   System.out.println("dj"+i);
	   }
	  
   }
}
//Main thread and child thread executes parallely .Here in the above example we made main thread sleep and mean while from 
//child thread we have stopped main thread. hence "main thread message is not printed""