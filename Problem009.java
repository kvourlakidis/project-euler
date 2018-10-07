// Pythagorean triplet:
// a^2 + b^2 = c^2
// where a, b and c are natural numbers.
// Find a Pythagorean triplet where:
// a + b + c = 1000
// Find the product abc.

public class Problem009 {
	public static void main(String[] args) {
		Kirill.main();
	}
}

class Kirill {
	static void main() {
		int desiredSum = 1000;
		int sum;
		int a=1, b=1;
		double c = 0;
		OUTER: 
		for (a=1;a<desiredSum;a++)
			INNER:
			for (b=1;b<desiredSum;b++)
				if (isTriplet(a,b)) {
					c = Math.sqrt(a*a + b*b);
					if (a + b + c == desiredSum) break OUTER;
				}
		System.out.println(a +"+"+b+"+"+c+"="+desiredSum);
	}

	static boolean isTriplet(int a, int b) {
		double c = Math.sqrt(a*a + b*b);
		if ((int)c - c == 0) return true;
		return false;
	}
}
