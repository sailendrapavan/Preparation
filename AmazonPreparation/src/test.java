 class MinimumCostToConnectRopes {

	public static void main(String[] args) {
		
		MinimumCostToConnectRopes m = new MinimumCostToConnectRopes();
		int[] arr = {4,3,2,6};
		int s = m.getMinCost(arr, arr.length);
		System.out.println(s);
	}

	private int getMinCost(int[] arr, int length) {
		
		int res = 0;
		
		while(length != 1){
			for(int i =length/2; i>=0; i--){
				heapify(arr, length, i);
			}
			if(length>2 && arr[1]>arr[2]){
				int temp = arr[1];
				arr[1] = arr[2];
				arr[2] = temp;
			}			
			int sum=arr[0]+arr[1];
			res += arr[0]+arr[1];
			for(int i = 0; i< length-2; i++){
				arr[i] = arr[i+2];
			}
			arr[length-2] = sum;
			length--;
		}
		return res;
	}

	private void heapify(int[] arr, int length, int i) {

		int largest = i;
		int l = 2*i+1;
		int r = 2*i+2;
		
		if(l<length && arr[largest]>arr[l]){
			largest = l;
		}
		if(r<length && arr[largest]>arr[r]){
			largest = r;
		}
		
		if(largest != i){
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			
			heapify(arr, length, largest);
		}
	}
}
public class test {

}
