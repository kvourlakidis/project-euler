import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class Problem018 {
	public static void main(String[] args) {
		String filePath = "Problem018.txt";
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(filePath);
			bufferedReader = new BufferedReader(fileReader);
			String lines = "";
			int width = 0;
			int height = 0;
			String line = bufferedReader.readLine();
			while (line != null) {
				lines += line + "\n";
				if (line.split(" ").length > width) width = line.split(" ").length;
				height++;
				line = bufferedReader.readLine();
			}
			int[][] grid = new int[height][width];
			String[] linesArray = lines.split("\n");
			for (int i=0;i<linesArray.length;i++) {
				String[] lineArray = linesArray[i].split(" ");
				for (int j=0;j<lineArray.length;j++) {
					grid[i][j] = Integer.parseInt(lineArray[j]);
				}
			}
			Kirill.main(grid);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (fileReader != null) fileReader.close();
				if (bufferedReader != null) bufferedReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}

class Kirill {
	static void main(int[][] grid) {
		String bestRoute = "";
		int bestSum = 0;
		for (int x = (int) Math.pow(2,14);x<Math.pow(2,15);x++) {
			String route = Integer.toBinaryString(x).substring(1);
			int index = 0;
			int sum = 0;
			sum += grid[0][index];
			for (int i=0;i<route.length();i++) {
				index += route.charAt(i) == '0' ? 0 : 1;
				sum += grid[i+1][index];
			}
			if (sum > bestSum) {
				bestSum = sum;
				bestRoute = route;
			}
		}
		System.out.println("Best route: " + bestRoute);
		System.out.println("Best sum: " + bestSum);
	}

	static void main2(int[][] grid) {
		String bestRoute = "";
		int bestSum = 0;
	}

	class Node {
		int value;
		Node parent;
		// List<Node> children;
		int sum;

		Node() {}

		void calculateAndSetParent() {}

		void setParent(Node parent) {
			this.parent = parent;
		}
	}
}
