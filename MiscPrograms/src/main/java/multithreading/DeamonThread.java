package multithreading;

public class DeamonThread {

	 public static void main(String args[]) throws InterruptedException  {
		   
		  Thread t= Thread.currentThread();
		  
		  System.out.println("Mater thread itiated by jvm "+t.getName());
		  System.out.println("Mater thread itiated by jvm "+t.getPriority());
	      
	      testone te= new testone(); 
	      te.setDaemon(true); //testone is set as demaon thread
	      te.start();
	      te.sleep(10);
	      
	      System.out.println("main thread");
	      
	      
	   }
}

class testone extends Thread {
   
   public void run() {
	   nestestedThread nest = new nestestedThread();
	   nest.start();
	   
	   for(int i=0;i<1000;i++) {
		  
	   System.out.println("dj"+i);
	   }
	  
   }
}


class nestestedThread extends Thread{
	
	public void run() {
		
		for(int i=0;i<1000;i++) {
			System.out.println("nestestedThread"+i);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}



//Usually even after main thread completes child threads keeps running....if we set child thread as deamon....
//then if parent thread is died that child thread automatically dies
