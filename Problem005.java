// What is the smallest number that is evenly divisible by all the
// numbers from 1 to 20?

public class Problem005 {
	public static void main(String[] args) {
		Kirill.main();
	}
}

class Kirill {
	static void main() {
		long LCM = 1;
		for (int i=2;i<=20;i++)
			LCM = LCM(LCM,i);
		System.out.println(LCM);
	}

	static long LCM(long x, long y) {
		long xy = x*y;
		long LCM = xy;
		for (int i=1; i <= ((x>y) ? y : x); i++)
			if (xy % i == 0)
				if ((xy/i) % x == 0 && (xy/i) % y == 0)
					LCM = xy / i; 
		return LCM;
	}
}
