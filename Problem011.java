// First medium difficulty problem.
// In the number grid, find the greatest product of four
// adjacent numbers in the same direction (up, down, left, right,
// diagonally).

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class Problem011 {
	public static void main(String[] args) throws IOException {
		int gridSize = 20;
		/* [row] [column] */
		int[][] grid = new int[gridSize][gridSize];
		String[] gridLine = new String[gridSize];
		String filePath = "Problem011.txt";
		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);
		String currentLine = "";
		for (int i=0;i<gridSize;i++) {
			currentLine = br.readLine();
			gridLine = currentLine.split(" ");
			for (int j=0;j<gridSize;j++) {
				grid[i][j] = Integer.parseInt(gridLine[j]);
			} 
		}
		br.close();
		fr.close();
		Kirill.main(grid);
	}
}

class Kirill {

	static void main(int[][] grid) {

		final int M = grid.length;
		final int N = 4;

		// flip the grid
		int[][] flippedGrid = flip(grid);

		// check all the horizontals and verticals
		for (int i=0;i<M;i++) {
			// maxInRow(grid[i]);
			// maxInRow(flippedGrid[i]);
			break;
		}

		// check all the diagonals

		// check the positively sloping diagonals
		System.out.println("Checking all the positively sloping diagonals - 1st half");
		for (int i=0;i<M;i++) {
			int[] intList = new int[M];
			int counter = 0;
			try {
				for(int x=i,y=0;true;x--,y++) {
					intList[counter] = grid[y][x];
					counter++;
				}
			} catch (ArrayIndexOutOfBoundsException ex) {
				int[] subList = new int[counter]; 
				System.arraycopy(intList, 0, subList, 0, counter);
				// maxInRow(subList);
				for (int k : subList) System.out.print(k + " ");
 				System.out.println();
			}
		}
		System.out.println("Checking all the positively sloping diagonals - 2nd half");
		for (int i=1;i<M;i++) {
			int[] intList = new int[M];
			int counter = 0;
			try {
				for (int x=i,y=(M-1);true;x++,y--) {
					intList[counter] = grid[y][x];
					counter++;
				}
			} catch (ArrayIndexOutOfBoundsException ex) {
				int[] subList = new int[counter];
				System.arraycopy(intList, 0, subList, 0, counter);
				// maxInRow(subList);
				for (int k : subList) System.out.print(k + " ");
				System.out.println();
			}
		}

		// check the negatively sloping diagonals
		System.out.println("Checking all the negatively sloping diagonals - 1st half");
		for (int i=0;i<M;i++) {
			int [] intList = new int[i+1];
			int counter = 0;
			for (int x=i,y=(M-1);x>=0;x--,y--) {
				intList[counter] = grid[y][x];
				counter++;
			}
			// maxInRow(intList);
			for (int k : intList) System.out.print(k + " ");
			System.out.println(); 
		} 

		System.out.println("Checking all the negatively sloping diagonals - 2nd half");
		for (int i=1;i<M;i++) {
			int[] intList = new int[M-i];
			for (int x=i,y=0;x<M;x++,y++) {
				intList[y] = grid[y][x];
			}
			for (int k : intList) System.out.print(k + " ");
			System.out.println();
		} 
	}

	/**
	  * Loops through the input 1-dimensional
	  * array, calculating the product of 4
	  * consecutive elements at a time. 
	  * Returns the greatest product.
	  */
	static int maxInRow(int[] row) {
		int maxProduct = 0;
		int curProduct;
		for (int i=0;i<=(row.length-N);i++) {
			System.out.println(row[i] + " " + row[i+1] + " " + row[i+2] + " " + row[i+3]);
			curProduct = row[i] * row[i+1] * row[i+2] * row[i+3];
			if (curProduct > maxProduct) maxProduct = curProduct;
		}
		return maxProduct;
	}

	/**
	  * Flips the input 2-dimentional matrix
	  * so that the first row of the input
	  * matrix, becomes the first column of
	  * the output matrix, etc.
	  */
	static int[][] flip(int[][] grid) {
		int height = grid.length;
		int width  = grid[0].length;
		int[][] newGrid = new int[width][height];
		for (int i=0;i<height;i++)
			for (int j=0;j<width;j++)
				newGrid[j][i] = grid[i][j];
		return newGrid;
	}
}
