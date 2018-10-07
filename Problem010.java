// Find the sum of primes below two million.
// 
// Kirill: my solution is pretty inefficient

public class Problem010 {
	public static void main(String[] args) {
		long sumOfPrimes = 0;
		int limit = 2_000_000;
		for (int i=2;i<limit;i++)
			if (isPrime(i)) sumOfPrimes += i;
		System.out.println(sumOfPrimes);
	}

	static boolean isPrime(int x) {
		int sqrt = (int) Math.sqrt(x);
		for (int i=2; i<=sqrt;i++)
			if (x % i == 0) return false;
		return true;
	}
}
