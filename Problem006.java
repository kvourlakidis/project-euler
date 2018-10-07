// Find the difference between the sum of the squares 
// of the first 100 natural numbers and the square of 
// the sum.

public class Problem006 {
	public static void main(String[] args) {
		int i = 100;
		long sumOfSquares = sumOfSquaresUpTo(i);
		long squareOfSum  = sumUpTo(i) * sumUpTo(i);
		System.out.println(squareOfSum - sumOfSquares);
	}

	static int sumUpTo(int ceil) {
		int sum = 0;
		for (int i=1;i<=ceil;i++) sum += i;
		return sum;
	}

	static long sumOfSquaresUpTo(int ceil) {
		long sum = 0;
		for (int i=1;i<=ceil;i++) sum += (i*i);
		return sum;
	}
}
