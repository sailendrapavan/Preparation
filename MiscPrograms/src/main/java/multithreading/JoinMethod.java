package multithreading;

class ops implements Runnable{
    public void run(){
        System.out.println("in run() method");
           for(int i=0;i<5;i++){
                  System.out.println("i="+i+" ,ThreadName="+Thread.currentThread().getName());
           }          
    }
}
 
public class JoinMethod {
    public static void main(String...args) throws InterruptedException{
           System.out.println("In main() method");
           ops runnable=new ops();
           Thread thread1=new Thread(runnable);
           Thread thread2=new Thread(runnable);

           thread1.start();
           thread1.join();

           thread2.start();
           thread2.join();

           System.out.println("end main() method");
    }
}

//main thread waits until thread1 completes its execution ....once completed it called thread2 and it waits until thread2 gets completed