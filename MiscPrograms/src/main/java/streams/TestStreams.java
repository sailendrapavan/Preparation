package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestStreams {

	public static void main(String args[]) {
		
		List<String> a = Arrays.asList("sa","a","sf","sd");
		List<String> count =  a.stream().map(String->String.concat("a")).collect(Collectors.toList());
		List<Integer> b = Arrays.asList(1,2,3,4,4);
		b.stream().map(y->y*y).map(y->y*y).collect(Collectors.toSet()).stream().forEach(o->System.out.println(o));
//		String s=count.stream().collect(Collectors.joining(""));
//		System.out.println("after joining"+s);
//		long coun = a.stream().filter(string->string.contains("a")).count();
//	      System.out.println("Total strings " + coun);
	}
}
