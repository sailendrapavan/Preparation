package multithreading;

public class thread {

public static void main(String args[]) {
	runner s = new runner();
	s.start();
	
}
	
}

class runner extends Thread {
	
	public void run() {
		for(int i=0;i<10;i++ )
		{
			System.out.println(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

