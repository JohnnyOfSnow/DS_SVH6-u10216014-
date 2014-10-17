public class TestHeapSort{
	private static int heapSize = 0;
	public static void main(String[] args) {
		int[] h = {0,3,5,7,9};
		h = HeapSort(h);
		for(int p = 1; p < h.length; p++){
			System.out.println("h[" + p + "] is : " + h[p]);
		}
	}

	static int[] HeapSort(int[] A){
		setHeapSize(A.length);
		A = BuildHeap(A);
		
		for(int k = A.length - 1; k >= 2; k--){
			System.out.println("A[1]: " + A[1] + "A[k]: " + A[k]);
			int temp = A[1];
			A[1] = A[k];
			A[k] = temp;
			setHeapSize(getHeapSize() - 1);
			A = Heapify(A,1);
		}
		return A;
	}

	static int[] BuildHeap(int[] A){
		System.out.println("The floor result is: " + (int)(Math.floor(A.length / 2)));
		for(int i = (int)(Math.floor(A.length / 2)); i >= 1; i--){
			A = Heapify(A,i);
		}
		for(int p = 1; p < A.length; p++){
			System.out.println("BuildHeap A[" + p + "] is : " + A[p]);
		}
		return A;
	}

	static int[] Heapify(int[] A, int i){
		int l = 2 * i;
		int r = 2 * i + 1;
		int largest = i;

		if(l < getHeapSize() && A[l] > A[i]){
			largest = l;
		}

		if(r < getHeapSize() && A[r] > A[largest]){
			largest = r;
		}
		System.out.println("--------------------------------------");
		for(int p = 1; p < A.length; p++){
			System.out.println(" Heapify A[" + p + "] is : " + A[p]);
		}


		if(largest != i){
			int temp = A[largest];
			A[largest] = A[i];
			A[i] = temp;
			Heapify(A,largest);
		}else{
			return A;
		}
		return A;
	}

	static void setHeapSize(int newHeapSize){
		heapSize = newHeapSize;
	}

	static int getHeapSize(){
		return heapSize;
	}
}
