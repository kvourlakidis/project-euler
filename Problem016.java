// What is the sum of the digits
// of the number 2^1000?

public class Problem016 {
	public static void main(String[] args) {
		for (int i=1;i<=40;i++) {
			System.out.println("2 ^ " + i + " = " +  pow(2,i) + " (" + sumOfDigits(pow(2,i)) + ")" );
		}
	}

	static int sumOfDigits(long x) {
		String s = Long.toString(x);
		int sum = 0;
		for (int i=0;i<s.length();i++)
			sum += Integer.parseInt(Character.toString(s.charAt(i)));
		return sum;
	}

	static long pow(int base, int exp) {
		long result = 1;
		for (int i=0;i<exp;i++)
			result *= base;
		return result;
	}
}

