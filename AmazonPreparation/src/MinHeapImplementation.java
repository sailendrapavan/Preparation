import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeapImplementation {

	void buildMinheap(List<Integer> l) {

		int n = l.size();
		for (int i = n / 2 - 1; i >= 0; i--) {
			minheapify(l, n, i);
		}

	}

	void minheapify(List<Integer> l, int n, int position) {

		int left = position * 2 + 1;
		int right = position * 2 + 2;

		int smallest = position;

		if (left < n && l.get(left) < l.get(smallest)) {
			smallest = left;
		}
		if (right < n && l.get(right) < l.get(smallest)) {
			smallest = right;
		}

		if (smallest != position) {
			int temp = l.get(position);
			l.set(position, l.get(smallest));
			l.set(smallest, temp);
			minheapify(l, n, smallest);

		}

	}

	int getMinimum(List<Integer> l) {
		int n = l.get(0);
		l.set(0, l.get(l.size() - 1));
		l.remove(l.size() - 1);
		minheapify(l, l.size(), 0);
		return n;
	}

	void insertElement(List<Integer> l, int element) {

		l.add(element);
		int i = l.size() - 1;
		while (i > 0 && l.get(i) < l.get(i / 2)) {

			int temp = l.get(i);
			l.set(i, l.get(i / 2));
			l.set(i / 2, temp);
			i = i / 2;
		}

	}

	int ropeProblem(List<Integer> l) {
		int sum = 0;
		while (l.size() != 1) {

			int a = getMinimum(l);
			System.out.println("minimum" + a);
			int b = getMinimum(l);
			System.out.println("minimum" + b);
			insertElement(l, a + b);
			sum = sum + a + b;

		}
		return sum;

	}

	public static void main(String args[]) {

		MinHeapImplementation min = new MinHeapImplementation();
		List<Integer> l = new ArrayList<Integer>(Arrays.asList(4, 3, 2, 6, 12));
		System.out.println(l);
		min.buildMinheap(l);
		System.out.println(l);
//         System.out.println(min.getMinimum(l));
//         System.out.println(l);
//         min.insertElement(l,1);
//         System.out.println(l);
		System.out.println(min.ropeProblem(l));

	}
}
