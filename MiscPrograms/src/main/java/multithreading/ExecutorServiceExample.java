package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
/**
 * ExecutorService interface Example
 * 
 * @author javaguides.net
 *
 */
public class ExecutorServiceExample {
    public static void main(String[] args) {
 
        System.out.println("Thread main started");
 
        // Create a task
        Runnable task1 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("[" + Thread.currentThread().getName() + "] " + "Message " + i +"task1");
            }
        };
 
       // Create a task
        Runnable task2 = () -> {
            for (int i = 0; i < 5; i++) {
                 System.out.println("[" + Thread.currentThread().getName() + "] " + "Message " + i +"task2");
            }
        };
 
      // Create a task
       Runnable task3 = () -> {
           for (int i = 0; i < 5; i++) {
               System.out.println("[" + Thread.currentThread().getName() + "] " + "Message " + i  +"task3");
           }
       };
 
    // Create a task
      Runnable task4 = () -> {
          for (int i = 0; i < 5; i++) {
              System.out.println("[" + Thread.currentThread().getName() + "] " + "Message " + i + "task4");
          }
      };
      ExecutorService executorService = Executors.newFixedThreadPool(2);
 
      executorService.execute(task1);
      executorService.execute(task2);
      executorService.execute(task3);
      executorService.execute(task4);
 
      System.out.println("Thread main finished");
 
      executorService.shutdown();
   }
}


// executor service have pool of threads we can send objects which we want to run .These should implement runnable interface. So executor will
//call these start method of that objects and executor maintains synchronization. If there are less threads and more tasks like above. First
//Each thread pick one task and completes and try to execute other tasks. The main advantage of using this thread pool executor is it manages all
//start methods and uses threads in most efficient manner
