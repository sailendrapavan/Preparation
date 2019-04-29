package multithreading;
//synchronized usage
public class Volatile {
    
    static int x = 0, y = 0;
    
    static synchronized void method1() {
    	
           x++; y++;
    }
    static synchronized void method2() {
           System.out.println("x=" + x + " y=" + y);
    }
    
    
    public static void main(String[] args) {
    	
    	int i=0;
    	for(;;) {
    		for(i=0;i<5;i++) {
    			System.out.println(i);
    		}
    		if(i>5)
    			break;
    	}
//           Thread thread1=new Thread(){
//                  public void run(){
//                        for(int i=0; i<100000;i++)
//                               method1();
//                        
//                  }
//           };
// 
//           Thread thread2=new Thread(){
//                  public void run(){
//                        for(int i=0; i<100;i++)
//                               method2();
//                        
//                  }
//           };
//           
//           thread1.start();
//           thread2.start();
    }
}
//here x=1535 y=1936
//This scenario may come as output as static methods are shared by differnt threads hence inconsistency problem may be occured....to overcome 
//that we have use synchronized key word for the methods 