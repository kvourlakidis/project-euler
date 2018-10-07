// The four adjacent digits in the 1000-digit
// number that have the greatest product are 
// 9 x 9 x 8 x 9 = 5832.
// Find the thirteen adjacent digits in the
// 1000-digit number that have the greatest
// product.

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class Problem008 {
	public static void main(String[] args) throws IOException {
		String filePath = "Problem008.txt";
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String numberString = "", lineString = "";
		while(lineString != null) {
			numberString += lineString;
			lineString = bufferedReader.readLine();
		}
		fileReader.close();
		bufferedReader.close();
		Kirill.main(numberString);
	}
}

class Kirill {
	static void main(String numberString) {
		long highProduct = 0;
		long product;
		int numDigits = 13;
		String subString = "";
		for (int i=0;i<=(numberString.length()-numDigits);i++) {
			subString = numberString.substring(i,i+numDigits);
			product = 1;
			for (int j=0;j<numDigits;j++)
				product *= Integer.parseInt(String.valueOf(subString.charAt(j)));
			if (product > highProduct) highProduct = product;
		}
		System.out.println(highProduct);
	}
}

