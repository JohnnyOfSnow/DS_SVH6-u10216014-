import java.io.*;
import java.util.Scanner;

public class TestFileRead{
	
	public static void main(String[] args) {
		String a = readData("grade.txt");
		System.out.println(a);
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
