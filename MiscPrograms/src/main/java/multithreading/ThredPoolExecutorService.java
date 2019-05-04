package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThredPoolExecutorService {

    public final static  ExecutorService service = Executors.newFixedThreadPool(3);
    public static void main(String args[]) {
        for(int i=0;i<1000;i++) {
            printThreadNameClasee a = new printThreadNameClasee(i);
            service.execute(a);
        }
    }
}

class printThreadNameClasee implements Runnable{
    
    int i;
    printThreadNameClasee(int i){
        this.i=i;
    }
    public void run() {
        System.out.println(Thread.currentThread().getName() +"object number "+i);
    }
}

