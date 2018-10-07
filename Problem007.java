// What is the 10_001st prime?

public class Problem007 {
	public static void main(String[] args) {
		Kirill.main();
	}
}

class Kirill {
	static void main() {
		int primeIndex = 10_001;
		int prime = 0;
		int count = 0;
		int i = 1;
		while (count < primeIndex)
			if (isPrime(++i)) {
				prime = i;
				count++;
			}
		System.out.println(count + "st prime is: " + prime);
	}

	static boolean isPrime(int x) {
		int sq = (int) Math.sqrt(x);
		for (int i=2;i<=sq;i++)
			if (x % i == 0) return false;
		return true;
	}
}
