package dynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreakProblem {

	static Set<String> h = new HashSet<String>(Arrays.asList("mobile","samsung","sam","sung", 
            "man","mango","icecream","and", 
             "go","i","like","ice","cream")); 
	public Boolean wordBreak(String s) {
		
		if (s.length() == 0)  
			return true; 
		for(int i=1;i<=s.length();i++)
		{
			
			
			if( h.contains(s.substring(0, i))&&wordBreak(s.substring(i,s.length())))
					{
				    
                    return true;				
					}
		   System.out.println(s.substring(0, i));	
		}
		return false;
		
		
	}
	
	public static void main(String args[])
	{
		WordBreakProblem brea = new WordBreakProblem();
		System.out.println(brea.wordBreak("slikemango"));
		
	}
}


