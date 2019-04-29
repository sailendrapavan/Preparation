package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringBasicPrograms {
	
	public Boolean OnlyCharacters(String s)
	{
		for(int i=0;i<s.length();i++)
		{
	     if(!(s.charAt(i)>=65&&s.charAt(i)<=121))
	     {
	    	 return false;
	     }
		}
		return true;
	}
	
	public void removeAllDelimitersInString(String s) {
		String str=s.trim();
		String a[]=str.split("\\W+");
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
 	}
	
	public void removeAllDuplicatesWithoutPredefinedFunctions(String s) {
		String sub="";
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)>=97&&s.charAt(i)<=122)
			{
				sub=sub+s.charAt(i);
			}
			else
			{
				if(sub.length()!=0)
				System.out.println(sub);
				sub="";
			}
		}
		System.out.println(sub);
	}
	
	public void printOccurancesOfLetters(String s) {
		
		HashMap<Character, Integer> count = new HashMap<Character, Integer>();
		
		for(char c : s.toCharArray())
		{
			if(count.containsKey(c))
			{
				count.put(c, count.get(c)+1);
			}
			else
			{
				count.put(c, 1);
			}
		}
		for(Map.Entry entry : count.entrySet()) {
			System.out.println(entry.getKey()+"and its value is"+entry.getValue());
		}
	}
	
	public void removeWhiteSpaces(String s) {
		Pattern patt = Pattern.compile("[\\s]");
		Matcher mat = patt.matcher(s);
		
		System.out.println(mat.replaceAll(""));
		
	}
	public static void main(String args[]) {
		
		StringBasicPrograms basic = new StringBasicPrograms();
		//System.out.println(basic.OnlyCharacters("GeeksforGeeks"));
		basic.removeAllDelimitersInString("sail , s!%^bkj,j");
		basic.printOccurancesOfLetters("sailendrapavan");
		basic.removeWhiteSpaces("sasa adad ad");
	}

}
