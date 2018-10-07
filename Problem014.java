// Collatz sequence
// n -> n/2 (n is even)
// n -> 3n + 1 (n is odd)
// Which starting number, under one million,
// produces the longest chain?

public class Problem014 {
	public static void main(String[] args) {
		int maxSeq = 0;
		for (int i=1;i<=1_000_000;i++) {
			int seq = collatz(i,1,false);
			if (seq > maxSeq) {
				maxSeq = seq;
				System.out.print(i);
				// collatz(i,1,true);
				System.out.print(" (" + seq + ")\n");
				// System.out.print("\n\n\n");
			}
		}
	}

	static int collatz(long n, int seq, boolean print) {
		if (n == 1) return seq;
		long next;
		if (n % 2 == 0) next = n / 2;
		else next = 3 * n + 1;
		if (print) System.out.print(" - > " + next);
		return collatz(next, ++seq, print);
	}
}

