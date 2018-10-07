// Work out the sum of the one-hundred 50-digit
// numbers in Problem013.txt.

import java.io.IOException;
import java.io.FileReader;

public class Problem013 {
	public static void main(String[] args) {
		String filePath = "Problem013.txt";
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(filePath);
			String numberString = "";
			int nextChar = fileReader.read();
			while (nextChar != -1) {
				numberString += (char) nextChar;
				nextChar = fileReader.read();
			}
			Kirill.main(numberString);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (fileReader != null) fileReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}

class Kirill {
	static void main(String numberString) {
		String[] nsa = numberString.split("\n");
		int height = nsa.length;
		// assumes that all numbers are the same length
		int width = nsa[0].length();
		char[][] numbers = new char[height][width];
		for (int i=0;i<height;i++)
			for (int j=0;j<width;j++)
				numbers[i][j] = nsa[i].charAt(j);
		char[] sum = new char[width * 2];
		for (int i=0;i<sum.length;i++) sum[i] = '0';
		int l = sum.length;
		for (int j=1;j<=width;j++) {
			int  curSum = 0;
			for (int i=0;i<height;i++)
				curSum += Character.digit(numbers[i][width-j], 10);
			char[] curSumChars = Integer.toString(curSum).toCharArray();
			int m = curSumChars.length;
//			System.out.println(curSumChars);
			for (int i=1;i<=m;i++) {
				int s = Character.digit(curSumChars[m-i],10) + Character.digit(sum[l-i-j+1],10);
				if (s < 10) {
					sum[l-i-j+1] = Integer.toString(s).charAt(0);
				} else {
					sum[l-i-j+1] = Integer.toString(s % 10).charAt(0);
					int s2 = Character.digit(sum[l-i-j],10) + (s / 10);
					sum[l-i-j] = Integer.toString(s2).charAt(0);
					if (s2 > 9) {
						System.out.println("fucked");
						System.exit(1);
					}
				}
			}
		}
		System.out.println(sum);
	}
}
