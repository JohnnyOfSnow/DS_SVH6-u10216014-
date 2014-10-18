public class TestMergeSort{
	public static void main(String[] args) {
		String[] op = {"","eat","Apple","tog","Dop","Kop","LEO","Cat"};
		String[] ui = MergeSort(op,1,op.length - 1);
		for(int y = 1; y < ui.length; y++){
			System.out.println("ui[" + y + "] is: " + ui[y]);
		}
	}

	static String[] MergeSort(String[] A, int i, int j){
		if(i < j){
			int m = (int)(Math.floor((i + j)/2));
			A = MergeSort(A,i,m);
			A = MergeSort(A,m + 1,j);
			A = Merge(A,i,m,j);		
		}
		return A;
	}

	static String[] Merge(String[] A, int i, int m, int j){
		
		String[] b = new String[A.length];
		for(int s = 0; s < A.length; s++){
			b[s] = A[s];
		}
		
		int p = i;
		int q = m + 1;
		int r = i;
		while(p <= m && q <= j){			
			if(A[p].compareTo(A[q]) < 0){				
				b[r] = A[p];
				p = p + 1;
			}else{				
				b[r] = A[q];
				q = q + 1;		
			}			
			r = r + 1;
		}
		
		while(p <= m){
			b[r] = A[p];
			p = p + 1;
			r = r + 1;			
		}

		while(q <= j){
			b[r] = A[q];
			q = q + 1;
			r = r + 1;
		}		
		return b;
	} 
}
