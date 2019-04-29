package designpricnciples;


class superclass{
	
	public int add(int a, int b) {
				return 0;
	}
	
	public void addAll() {
	   for(int i=0;i<10;i++) {
		   
	   }
	}
}

 class subclass extends superclass {
	
	public int add (int a,int b) {
		return a+b+1;
	}

}
 
 public class FavourCompositionOverInheritance {

	 public static void main(String args[]) {
		subclass a = new subclass();
		a.addAll();
	}
		
 }
 