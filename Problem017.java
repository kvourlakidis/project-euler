// If the numbers 1 to 5 are written out in words:
// one, two, three, four, five, then there are
// 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
// If all the numbers from 1 to 1000 inlusive were
// written out in words, how many letters would be used?
// Note: do not count spaces or hyphens.
// The use of 'and' when writing out numbers in
// compliance with British usage.

import java.util.HashMap;

public class Problem017 {
	public static void main(String[] args) {
		int charCountSum = 0;
		for (int i=1;i<=1000;i++) {
			charCountSum += charCount(getEnglishNumber(i));
		}
		System.out.println(charCountSum);
	}

	static String getEnglishNumber(int x) {
		if (x == 0) return "zero";
		HashMap<Integer, String> numbers = new HashMap<>();
		numbers.put(1, "one");
		numbers.put(2, "two");
		numbers.put(3, "three");
		numbers.put(4, "four");
		numbers.put(5, "five");
		numbers.put(6, "six");
		numbers.put(7, "seven");
		numbers.put(8, "eight");
		numbers.put(9, "nine");
		numbers.put(10, "ten");
		numbers.put(11, "eleven");
		numbers.put(12, "twelve");
		numbers.put(13, "thirteen");
		numbers.put(14, "fourteen");
		numbers.put(15, "fifteen");
		numbers.put(16, "sixteen");
		numbers.put(17, "seventeen");
		numbers.put(18, "eighteen");
		numbers.put(19, "nineteen");
		numbers.put(20, "twenty");
		numbers.put(30, "thirty");
		numbers.put(40, "forty");
		numbers.put(50, "fifty");
		numbers.put(60, "sixty");
		numbers.put(70, "seventy");
		numbers.put(80, "eigthy");
		numbers.put(90, "ninety");
		final String c = "hundred";
		final String k = "thousand";
		final String and = "and";
		final String hyphen = "-";
		final String space = " ";

		String number = "";
		int thousands = x / 1000;
		x = x % 1000;
		int hundreds = x / 100;
		x = x % 100;
		int tens;
		if (x > 20) {
			tens = x / 10;
			x = x % 10;
		} else {
			tens = 0;
		}
		if (thousands > 0)
			number += numbers.get(thousands) + space + k + space;
		if (hundreds > 0)
			number += numbers.get(hundreds) + space + c + space;
		if (number.length() > 0 && (tens > 0 || x > 0))
			number += and + space;
		if (tens > 0)
			number += numbers.get(tens * 10) + space;
		if (x > 0)
			number += numbers.get(x);
		return number.trim();
	}

	static int charCount(String s) {
		s = s.replace(" ", "");
		s = s.replace("-","");
		return s.length();
	}
}
