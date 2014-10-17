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
	JButton btnNewButton = new JButton("\u8B80\u53D6\u6A94\u6848");
	JButton btnNewButton_1 = new JButton("\u5132\u5B58\u7D50\u679C");
	JButton btnNewButton_2 = new JButton("\u59D3\u540D\u6392\u5E8F");


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
		
		JButton btnNewButton_3 = new JButton("math\u6392\u5E8F");
		btnNewButton_3.setBounds(116, 98, 106, 23);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("English\u6392\u5E8F");
		btnNewButton_4.setBounds(232, 98, 106, 23);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\u5E73\u5747\u6392\u5E8F");
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


}

class handleSort{

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
}
