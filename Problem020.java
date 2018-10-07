// n! means n x (n-1) x (n-2) x ... x 3 x 2 x 1
// For example, 10! = 10 x 9 x ... x 3 x 2 x 1 = 3,628,800;
// and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
// Find the sum of the digits in the number 100!

public class Problem020 {
	public static void main(String[] args) {
		for (int i=1;i<=20;i++) System.out.println(i + "! = " + fact(i) + " (" + sumOfDigits(fact(i)) + ")");
	}

	// this method is only good until 20!
	// due to 21! > MAX_LONG
	static long fact(int x) {
		long y = 1;
		for (int i=2;i<=x;i++) y *= i;
		return y;
	}
	
	static int sumOfDigits(long x) {
		int sum = 0;
		String s = Long.toString(x);
		for (String sub : s.split("")) sum += Integer.parseInt(sub);
		return sum;
	}
}
