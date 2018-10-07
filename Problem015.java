// Starting in the top left corner of a 2x2 grid,
// and only being able to move to the right and down,
// there are exactly 6 routes to the bottom right corner.
// right -> right -> down  -> down (1100)
// right -> down  -> right -> down (1010)
// right -> down  -> down  -> right (1001)
// down  -> right -> right -> down (0110)
// down  -> right -> down  -> right (0101)
// down  -> down  -> right -> right (0011)
// How many such routes are there in a 20x20 grid?

public class Problem015 {
	public static void main(String[] args) {
		for (int i=1;i<=20;i++) {
			// System.out.println(i + ", " + latticePath(i));
			System.out.println(i + ", " + latticePath2(i));
		}
	}

	// this is akin to a 'brute force' solution
	// slow for size > 14
	static long latticePath(int size) {
		int steps = size * 2;
		String lowString = "", highString = "";
		for (int i=0;i<size;i++) {
			lowString += "0";
			highString += "1";
		}
		for (int i=0;i<size;i++) {
			lowString += "1";
			highString += "0";
		}
		long low = Long.parseLong(lowString, 2);
		long high = Long.parseLong(highString, 2);
		// System.out.println("Low : " + low);
		// System.out.println("High: " + high);
		long numPaths = 0;
		for (long i=low;i<=high;i++) {
			if (Long.bitCount(i) == size) {
				numPaths++;
			}
		}
		return numPaths;
	}

	// this is an efficient solution
	// however spills over MAX_LONG at size >= 11
	static long latticePath2(int size) {
		return (factorial(size * 2))/(factorial(size)*factorial(size));
	}

	static long factorial(int n) {
		long fact = 1;
		for (int i=2;i<=n;i++)
			fact *= i;
		return fact;
	}
}

