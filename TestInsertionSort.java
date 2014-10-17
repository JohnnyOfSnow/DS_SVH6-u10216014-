public class TestInsertionSort{
	public static void main(String[] args) {
		int[] h = {0,3,5,4,1,10};
		h = InsertionSort(h);
		for(int p = 1; p < h.length; p++){
			System.out.println("InsertionSort h[" + p + "] is : " + h[p]);
		}
	}

	static int[] InsertionSort(int[] A){
		int key = 0;
		int i = 0;
		for(int j = 2; j < A.length; j++){
			key = A[j];
			i = j - 1;

			while(i > 0 && A[i] > key){
				A[i + 1] = A[i];
				i = i - 1;
			}
			A[i + 1] = key;
		}
		return A;
	}
}
