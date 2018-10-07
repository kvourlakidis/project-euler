// The prime factors of 13,195 are 5, 7, 13 and 29.
// What is the largest prime factor of the number 600851475143?

public class Problem003 {
	public static void main(String[] args) {
		Kirill.go();
	}
}

class Kirill {
	// in current state won't find repeating prime factors properly
	static void go() {
		long x = 600_851_475_143L; // doesn't fit into an int
		long highPrime = 1; // I know, I know...
		for (long i=2; i <= x; i++)
			if (x % i == 0) {
				System.out.println("Found a factor: " + i);
				System.out.println(x + " / " + i + " = " + x / i);
				x = x / i;
				// probably don't need the if logic here
				if (isPrime(i) && highPrime < i) highPrime = i;
			}
		System.out.println(highPrime);
	}

	// not a real isPrime function
	static boolean isPrime(long l) {
		int r = (int) Math.sqrt(l);
		for (int i=2;i<=r;i++)
			if (l % i == 0)
				return false;
		return true; 
	}
}	

