import java.util.Scanner;
public class TestMergeSort{
	public static void main(String[] args) {
		String[] op = {"","eat","Apple","tog","Dop","Kop","LEO","Cat"};
		String[] ui = MergeSort(op,1,op.length - 1);
		for(int y = 1; y < ui.length; y++){
			System.out.println("ui[" + y + "] is: " + ui[y]);
		}

		String[] a = {"","eat,3","Apple,5","tog,4","Dop,1","Kop,10","LEO,87","Cat,47"};
		String[] ol = SortDataBaseOnStringArray(op,ui,a);

		for(int h = 1; h < ol.length; h++){
			System.out.println("ol[" + h + "] is: " + ol[h]);
		}

		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a name for search: ");
		String wamted = input.nextLine();
		int result = binarysearch(ui,wamted);
		if(result == -1){
			System.out.println("Not find!!!!!");
		}else{
			System.out.println(a[result]);
		}


	}


	static String[] SortDataBaseOnStringArray(String[] originalArray, String[] sortedArray, String[] dataArray){
		for(int i = 1; i < originalArray.length; i++){
			for(int u = 1; u < sortedArray.length; u++){
				System.out.println("sortedArray[" + i + "] is: " + sortedArray[i] + " originalArray[" + u + "] is: " + originalArray[u]);
				if(sortedArray[i].compareTo(originalArray[u]) == 0){
					System.out.println("u = " + u + "i = " + i);
					String temp = dataArray[i];
					dataArray[i] = dataArray[u];
					dataArray[u] = temp;
					String temp1 = originalArray[i];
					originalArray[i] = originalArray[u];
					originalArray[u] = temp1;
					originalArray[i] = "";
					break;
				}
			}
		}
		return dataArray;
	} // end SortDataBaseOnStringArray method.

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

	static int binarysearch(String[] sortedArray, String key){

		int low = 1;
		int mid = 0;
		int high = 0;
		high = sortedArray.length - 1;
		while(low <= high){
			mid = (int)((low + high) / 2);
			if(sortedArray[mid].compareTo(key) < 0){
				low = mid + 1;
			}else if(sortedArray[mid].compareTo(key) > 0){
				high = mid - 1;
			}else{
				return (mid);
			}
		}

		return (-1);
	}
}
