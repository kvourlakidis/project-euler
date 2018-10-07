// A palindromic number reads the same both ways.
// The largest palindrome made from the product of 
// two 2-digit numbers is 9009 = 91 x 99.
// Find the largest palindrome made from the product
// of two 3-digit numbers.

public class Problem004 {
	public static void main(String[] args) {
		Kirill.main();
	}
}

class Kirill {
	static void main() {
		int largestPal = 0;
		for (int i = 100; i < 999; i++) {
			for (int j = 100; j < 999; j++) {
				int ij = i*j;
				if (isPalindrome(ij) && ij > largestPal) {
					largestPal = ij;
					System.out.println(i + " * " + j + " = " + largestPal);
				}
			}
		}
	}

	static boolean isPalindrome(int x) {
		String fwdStr = Integer.toString(x);
		String revStr = reverse(fwdStr);
		if (fwdStr.equals(revStr)) return true;
		return false;
	}

	static String reverse(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = (s.length() - 1); i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

}
