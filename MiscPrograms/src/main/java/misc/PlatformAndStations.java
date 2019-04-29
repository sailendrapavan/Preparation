package misc;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class PlatformAndStations {


	
	public static void main(String args[]) {
		
		ArrayList<Integer> platforms = new ArrayList<Integer>();
		
		platforms.add(910);
		Scanner s = new Scanner(System.in);		
		 	for(int i=1;i<6;i++) {
			
		 		System.out.println("eneter arrival time");
		 		int arrival=s.nextInt();
		 		System.out.println("eneter departure time");
		 		int departure =s.nextInt();
		 		int flag=1;
		 		for(int j=0;j<platforms.size();j++ ) {
		 			if(platforms.get(j)<arrival)
		 			{
		 				
		 				platforms.remove(j);
		 				platforms.add(departure);
		 				flag=0;
		 			}
		 		}
		 		if(flag==1) {
		 			platforms.add(departure);
		 		}
		}
		System.out.println("Minumun no of platforms required"+platforms.size());
	}
}
