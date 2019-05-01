package multithreading;

public class BasicThreadProgram {

	public static void main(String args[]) throws InterruptedException {

		testre r = new testre("sailendra");
		testre ra = new testre("siva");
		ra.setPriority(1);
		r.start();
		ra.start();
		//Through lambda expressions using runnable interface
		Thread s = new Thread(() -> {
         System.out.println("sjbd");
	    });
		s.start();
}
}



class testre extends Thread {
	testre(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i < 10000; i++) {
			System.out.println(Thread.currentThread().getName() + i);

		}

	}
}

