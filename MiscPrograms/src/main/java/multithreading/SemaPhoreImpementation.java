package multithreading;

import java.util.concurrent.Semaphore;

public class SemaPhoreImpementation {

    public static void main(String args[]) {
        Semaphore s = new Semaphore(2);
        sem object = new sem(s);
        Thread first = new Thread(object);
        Thread second = new Thread(object);
        Thread third = new Thread(object);
        Thread fourth = new Thread(object);
        first.start();
        second.start();
        third.start();
        fourth.start();
    }
}

class sem implements Runnable {
    Semaphore s;

    sem(Semaphore s) {
        this.s = s;
    }

    public void run() {
        try {
            s.acquire();
            
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (int i = 0; i < 100; i++)
            System.out.println(Thread.currentThread().getName() + "count:" + i);
        s.release();
    }
}


// IN synchonised block only one thread can enter and can perform operations. But semaphore we can set the
//Limits like max number of threads to enter. Best example is trail room in shopping mall. Based on number
//of rooms persons can change parallely
//We can acquire multiple perrmist also if you want and reduce the possibilty of other threds to enter
//s.acquire(permits);