import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapConstruction {

	void BuildMaxHeap(List<Integer> l) {

		int n = l.size();
		for (int i = n / 2 - 1; i >= 0; i--) {

			heapify(l,n, i);

		}

	}

	void heapify(List<Integer> l,int n, int position) {

		int left = 2 * position + 1, right = 2 * position + 2;
		int largest = position;

		if (left < n && l.get(left) > l.get(largest)) {
			largest = left;
		}

		if (right < n && l.get(right) > l.get(largest)) {
			largest = right;
		}

		if (largest != position) {
			int t = l.get(position);
			l.set(position, l.get(largest));
			l.set(largest, t);
			heapify(l, n,largest);

		}
	}
	
	void sort(List<Integer> l) {

		int n = l.size();
		for (int i = n / 2 - 1; i >= 0; i--) {

			heapify(l,n, i);

		}
		 for (int i=n-1; i>=0; i--) 
	     { 
	         
	         int temp=l.get(0);
	         l.set(0, l.get(i));
	         l.set(i, temp);

	         // call max heapify on the reduced heap 
	         heapify(l, i, 0); 
	     } 

	}
	
	
	void insertAnelement(List<Integer> l,int n) {
		//increase an element value is also the same travserse upto a specific element and increase size
		l.add(n);
		int i=l.size()-1;
		while(i>0&&l.get(i/2)<l.get(i))
		{
			int temp=l.get(i/2);
			l.set(i/2, l.get(i));
			l.set(i, temp);
			i=i/2;
		}
		
	}
	
	
	void removeTopElement(List<Integer> l) {
		
		l.set(0,(l.get(l.size()-1)));
		heapify(l, l.size()-1, 0);
		
		
	}
	
	//deleting an arbitary element removes the advantages of heap as we need to search element as normal method which may lead to o(n)
	void deleteArbitaryElement(List<Integer> l,int element) {
		int i=0;
		for(i=0;i<l.size();i++) {
		
			if(l.get(i)==element)
			{
				break;
			}
		}
		
		l.set(i, l.get(l.size()-1));
		heapify(l, l.size()-1, i);
		
	}
	

	public static void main(String args[]) {

		HeapConstruction heap = new HeapConstruction();

		List<Integer> l = new ArrayList<Integer>(Arrays.asList(8, 2, 3, 4, 12, 45, 23,57,44));

		System.out.println(l);

		heap.BuildMaxHeap(l);
		System.out.println(l);

//		System.out.println(l);
		//heap.sort(l);
		//System.out.println(l);
//		System.out.println(l);
//
//		heap.insertAnelement(l, 425);
//
//		System.out.println(l);
//		heap.removeTopElement(l);
//		System.out.println(l);
		heap.deleteArbitaryElement(l, 44);
		System.out.println(l);

		
	}

}
