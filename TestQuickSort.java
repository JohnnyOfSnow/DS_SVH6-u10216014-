public class TestQuickSort{
	public static void main(String[] args) {
		int[] h = {0,3,5,4,1,10};
		h = QuickSort(h, 1, h.length - 1);
		for(int p = 1; p < h.length; p++){
			System.out.println("QuickSort h[" + p + "] is : " + h[p]);
		}
	}

	static int[] QuickSort(int[] A, int p, int r){
		if(p < r){
			int q = Partition(A,p,r);
			A = QuickSort(A,p,q);
			A = QuickSort(A,q + 1,r);
		}
		return A;
	}

	static int Partition(int[] A, int p, int r){
		int x = A[p];
		int i = p - 1;
		int j = r + 1;

		while(true){
			j = j - 1;
			while(A[j] > x){
				j = j - 1;
			}

			i = i + 1;

			while(A[i] < x){
				i = i + 1;
			}

			if(i < j){
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}else{
				return j;
			}
		}
		
	}
}
