package multithreading;

import java.util.concurrent.CountDownLatch;

public class CountdownLatch {

    public static void main(String args[]) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        coutntDown cd = new coutntDown(latch);
        Thread first = new Thread(cd);
        Thread second = new Thread(cd);
        Thread third = new Thread(cd);
        first.start();
        second.start();
        //third.start(); if we remove this main thread waits infinitely
        latch.await();
        System.out.println("completd three threads");
        
    }
}

class coutntDown implements Runnable {

    CountDownLatch latch;
    public coutntDown(CountDownLatch latch) {
        this.latch=latch;
    }

    @Override
    public void run() {
        
        System.out.println("work done so count down latch");
        latch.countDown();
    }

}
/***
 * Mainly count down latch we should use when we want to do actions after completion of certail work
 * Example you have to  start selling milk after getting milk from three cows. Then we will set count
 * down latch to three. When ever you got milk from one cow you will decrease the count so whene ever 
 * It becomes zero then you can start selling
 * 
 * Join is used to wait on particular thread completion but latch count is important than thread. If count is zero
 * Then it can start working 
 * 
 * 
 */
