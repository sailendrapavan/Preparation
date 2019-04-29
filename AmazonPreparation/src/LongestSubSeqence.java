import java.util.ArrayList;
import java.util.List;

public class LongestSubSeqence {

	public static void main(String args[]) {

		List<Integer> s = new ArrayList<Integer>();
		s.add(-4);
		s.add(-2);
		s.add(-1);
		s.add(-3);
		s.add(-7);
		s.add(-2);
		s.add(100);
		int max = s.get(0);
		int sum = s.get(0);
		for (int i = 1; i < s.size(); i++) {
			if (sum + s.get(i) < s.get(i)) {
				sum = s.get(i);

			} else {
				sum = sum + s.get(i);
			}
			if (sum > max) {
				max = sum;
			}

		}
		System.out.println(max);
	}
}
