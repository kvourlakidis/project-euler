// If we list all the natural numbers below 10 that are multiples
// of 3 and 5, we get 3, 5, 6 and 9. The sum of these multiples
// is 23. Find the sum of all the multiples of 3 and 5 below 1000.

public class Problem001 {
	public static void main(String[] args) {
		kirill();
	}

	static void kirill(){
		int sum = 0; // running total
		for (int i=1; i < 1000; i++) { // loop to 1:1k
			if (i % 3 == 0 || i % 5 == 0) // check if multiple
				sum += i; // add to sum
		}
		System.out.println(sum);
	}
}
