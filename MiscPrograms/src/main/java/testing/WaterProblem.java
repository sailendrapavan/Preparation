package testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class WaterProblem {

	public static void main(String args[]) {
		
		Scanner s = new Scanner(System.in);
		int testCases= s.nextInt();
		for (int num=0;num<testCases;num++) {
	    s.nextInt();	
		int noOfPipes=s.nextInt();
		//LinkedList<ArrayList<Integer>> linked = new LinkedList<ArrayList<Integer>> ();
		ArrayList<Integer> start = new ArrayList<Integer>();
		ArrayList<Integer> dest = new ArrayList<Integer>();
		int st,en;
		for(int pipe=0;pipe<noOfPipes;pipe++)
		{
			st=s.nextInt();
			en=s.nextInt();
			start.add(s.nextInt());
			dest.add(s.nextInt());
		//	linked.add(Arrays.asList(st,en,s.nextInt()));
		}
//		for(ArrayList<Integer> listed : linked)
//		{
//			for(Integer hh :listed )
//			{
//				System.out.println(hh);
//			}
//		}
		int k=0;
        for (Integer i : start)
        {
        	if(dest.contains(i))
        	{     
        		continue;
        	}
        	else
        	{
        		k++;
        	}
        }
        System.out.println(k);
	}
	}
}
