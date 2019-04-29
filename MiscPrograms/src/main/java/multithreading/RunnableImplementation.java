package multithreading;

public class RunnableImplementation {

	
	public static void main(String args[]) {
		int n=10;
		Thread s = new Thread(new runn());
		Thread ss = new Thread(new runn11());
		Thread rr = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Thread new"+n );
				s.start();
				ss.start();
			}
		});
		rr.start();
		
	}
	
	
	
}

class runn implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<10000;i++)
		{
			System.out.println("Thread1"+i);
		}
		
	}
	
	
	
}

class runn11 implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<10000;i++)
		{
			System.out.println("Thread2"+i);
		}
		
	}
	
//Here threads are running in different process so there will be no use of multi threading behaviour 
	
	
	
}