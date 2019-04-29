package codeChef;


import java.util.Scanner;


public class magicianBoxSwap {

	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int noOfSwaps = s.nextInt();
		int coinPosition =s.nextInt();
		System.out.println("enter boxes");
		
		for(int i=0;i<noOfSwaps;i++)
		{
			int start=s.nextInt();
			int end = s.nextInt();
			if(start==coinPosition)
			{
				coinPosition=end;
			}
			else if(end==coinPosition)
			{
				coinPosition=start;
			}
			else
			{
				continue;
			}
		}
		System.out.println(coinPosition);
		
	}
}
