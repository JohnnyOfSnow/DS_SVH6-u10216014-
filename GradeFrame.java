import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.io.*;
import java.util.Scanner;



public class GradeFrame extends JFrame {

	private static JPanel contentPane;
	private static JTextField textField; // read fdata from a file name that iuput in here.
	private static JTextField textField_1; // store the sort result in a file that you can give a name in here.
	private static JTextField textField_2; // you can enter a name in here that you can search.
	static TextArea textArea; // display sort result.
	static TextArea textArea_1; // display search result.
	static TextArea textArea_2; // display the process.
	JButton btnNewButton = new JButton("\u8B80\u53D6\u6A94\u6848"); // click it can read the file
	JButton btnNewButton_1 = new JButton("\u5132\u5B58\u7D50\u679C"); // click it can store the result in a file
	JButton btnNewButton_2 = new JButton("\u59D3\u540D\u6392\u5E8F"); // click it can do Merge sort base on name ASCII code
	JButton btnNewButton_3 = new JButton("math\u6392\u5E8F"); // click it can do Heap sort base on math grade
	JButton btnNewButton_4 = new JButton("English\u6392\u5E8F"); // click it can do Quick sort base on english grade
	JButton btnNewButton_5 = new JButton("\u5E73\u5747\u6392\u5E8F"); // click it can do insertion sort base on average grade evaluted by math and english grade


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GradeFrame frame = new GradeFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GradeFrame() {
		setTitle("\u6392\u5E8F\u7A0B\u5F0F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8B80\u53D6\u6A94\u6848\u540D\uFF1A");
		lblNewLabel.setBounds(22, 23, 96, 15);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(128, 20, 163, 21);
		panel.add(textField);
		textField.setColumns(10);
		textField.setText("grade.txt");
		
		
		btnNewButton.setBounds(301, 19, 87, 23);
		panel.add(btnNewButton);
		
		
		btnNewButton_1.setBounds(301, 52, 87, 23);
		panel.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(128, 53, 163, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u7D50\u679C\u6A94\u6848\u540D\uFF1A");
		lblNewLabel_1.setBounds(22, 56, 96, 15);
		panel.add(lblNewLabel_1);
		
		
		btnNewButton_2.setBounds(10, 98, 96, 23);
		panel.add(btnNewButton_2);
		
		
		btnNewButton_3.setBounds(116, 98, 106, 23);
		panel.add(btnNewButton_3);
		
		
		btnNewButton_4.setBounds(232, 98, 106, 23);
		panel.add(btnNewButton_4);
		
		
		btnNewButton_5.setBounds(348, 98, 87, 23);
		panel.add(btnNewButton_5);
		
		JLabel lblNewLabel_2 = new JLabel("\u8F38\u5165\u641C\u5C0B\u59D3\u540D\uFF1A\r\n");
		lblNewLabel_2.setBounds(22, 144, 96, 15);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(128, 141, 163, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u641C\u5C0B\u7D50\u679C\uFF1A");
		lblNewLabel_3.setBounds(22, 169, 65, 15);
		panel.add(lblNewLabel_3);
		
		textArea_1 = new TextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(22, 190, 367, 113);
		panel.add(textArea_1);
		
		JLabel lblNewLabel_4 = new JLabel("\u6392\u5E8F\u7D50\u679C\uFF1A");
		lblNewLabel_4.setBounds(22, 309, 65, 15);
		panel.add(lblNewLabel_4);
		
		textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setBounds(21, 330, 367, 119);
		panel.add(textArea);
		
		JLabel lblNewLabel_5 = new JLabel("\u8655\u7406\u904E\u7A0B\uFF1A");
		lblNewLabel_5.setBounds(22, 468, 65, 15);
		panel.add(lblNewLabel_5);
		
		textArea_2 = new TextArea();
		textArea_2.setEditable(false);
		textArea_2.setBounds(22, 489, 366, 138);
		panel.add(textArea_2);
	}

	static String[] SortDataBaseOnIntArray(int[] originalArray, int[] sortedArray, String[] dataArray){
		for(int i = 1; i < originalArray.length; i++){
			for(int u = 1; u < sortedArray.length; u++){
				System.out.println("sortedArray[" + i + "] is: " + sortedArray[i] + " originalArray[" + u + "] is: " + originalArray[u]);
				if(sortedArray[i] == originalArray[u]){
					System.out.println("u = " + u + "i = " + i);
					String temp = dataArray[i];
					dataArray[i] = dataArray[u];
					dataArray[u] = temp;
					int temp1 = originalArray[i];
					originalArray[i] = originalArray[u];
					originalArray[u] = temp1;
					originalArray[i] = 0;
					break;
				}
			}
		}
		return dataArray;
	} // end SortDataBaseOnIntArray method.
	
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


}

/**
 *	class handleSort: The class have the sort method that you can input array which you needs to sort.
 *		HeapSort:
 *			1.HeapSort(int[] A)
 *			2.BuildHeap(int[] A)
 *			3.Heapify(int[] A, int i)
 *			4.setHeapSize(int newHeapSize)
 *			5.getHeapSize()
 *		InsertionSort:
 *			1.InsertionSort(int[] A)
 *		QuickSort:
 *			1.QuickSort(int[] A, int p, int r)
 *			2.Partition(int[] A, int p, int r)
 *		MergeSort:
 *			1.MergeSort(String[] A, int i, int j)
 *			2.Merge(String[] A, int i, int m, int j)
 *
 *
 */
class handleSort{
	private static int heapSize = 0;

	handleSort(){

	}

	static String readData(String filename){
		
		FileReader fr = null;
		BufferedReader br = null;
		String stringforreadData = "";
		String[] readData = new String[5];
		String[] name = new String[5];
		int[] mathGrade = new int[5];
		int[] englishGrade = new int[5];
		int[] averageGrade = new int[5];

		StringBuilder readDataStringBuilder = new StringBuilder();

		try {
			fr = new FileReader(filename); // A file holds the question.
			br = new BufferedReader(fr);
			String data;
			StringBuilder stringBuilderForQuestion = new StringBuilder();
			int index = 1;
			data = br.readLine();
				
			while (((data = br.readLine()) != null)) {
				readData[index] = data;
				String[] dataArray = data.split(",");

				name[index] = dataArray[0];
				mathGrade[index] = Integer.parseInt(dataArray[1]);
				englishGrade[index] = Integer.parseInt(dataArray[2]);
				averageGrade[index] = (mathGrade[index] + englishGrade[index]) / 2;
				index = index + 1;
			}

			for(int i = 1; i < readData.length; i++){
				readDataStringBuilder.append(readData[i] + "\r\n");
			}

			stringforreadData = new String(readDataStringBuilder);


		} // end try
		catch(IOException e){}
		finally{
			try {
				br.close(); // Because the br = new BufferedReader(fr); , we close the br.
			}
			catch(IOException e){}
		} // end finally

		return stringforreadData;
	}

	static int[] HeapSort(int[] A){
		setHeapSize(A.length);
		A = BuildHeap(A);
		
		for(int k = A.length - 1; k >= 2; k--){
			
			int temp = A[1];
			A[1] = A[k];
			A[k] = temp;
			setHeapSize(getHeapSize() - 1);
			A = Heapify(A,1);
		}
		return A;
	}

	static int[] BuildHeap(int[] A){
		
		for(int i = (int)(Math.floor(A.length / 2)); i >= 1; i--){
			A = Heapify(A,i);
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
		/*
		 * Because the statement String[] b = A;
		 * It's mean b array have the A array's location.
		 * So, we change the B array's element(also A's reference is changed)
		 * To avoid it, we need to create a object(for another space)
		 * Use the for loop send the data one to one. 
		 *
		 */ 
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
