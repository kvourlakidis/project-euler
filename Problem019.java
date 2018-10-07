// 1 Jan 1900 was a Monday
// September, April, June and November
// all have 30 days.
// January, March, May, July, August,
// October and December have 31 days.
// February has 28 days, 29 on leap years,
// which occur on years divisible by 4, but not
// by 100, unless is also divisible by 400.
// How many Sundays fell on the first of the month
// during the twentieth century (1 Jan 1901 to 31 Dec 2000) ?

public class Problem019 {
	public static void main(String[] args) {
		int numOfSundays = 0;
		Date d = new Date(Day.MONDAY, 1, Month.JANUARY, 1900);
		while (d.getYear() < 2001) {
			if (d.getDayOfMonth() == 1 && d.getDayOfWeek() == Day.SUNDAY) {
				numOfSundays++;
				System.out.println(d.getDayOfMonth() + " " + d.getMonth() + " " + d.getYear());
			}
			d.next();
		}
		System.out.println("Months starting on Sunday in C20: " + numOfSundays);
	}
}

class Date {
	private Day dayOfWeek;
	private int dayOfMonth;
	private Month month;
	private int daysInMonth;
	private int year;
	private boolean leap;

	Date(Day day, int dayOfMonth, Month month, int year) {
		this.dayOfWeek = day;
		this.dayOfMonth = dayOfMonth;
		this.month = month;
		this.year = year;
		this.leap = isLeap(year);
		this.daysInMonth = month.getDays(leap);
	}
	static boolean isLeap(int year) {
		return (year % 4 == 0) ? (year % 100 == 0) ? (year % 400 == 0) ? true : false : true : false;
	}
	
	boolean isLeap()    { return leap; }
	int getDayOfMonth() { return dayOfMonth; }
	Day getDayOfWeek()  { return dayOfWeek; }
	Month getMonth()    { return month; }
	int getYear()       { return year; }

	void next() {
		dayOfWeek = dayOfWeek.next();
		dayOfMonth++;
		if (dayOfMonth > daysInMonth) {
			if (month == Month.DECEMBER) {
				year++;
				leap = isLeap(year);
			}
			month = month.next();
			daysInMonth = month.getDays(leap);
			dayOfMonth = 1;
		}
	}  
}

enum Day {
	MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY;

	Day next() {
		int pos = this.ordinal();
		pos = (pos + 1) % 7;
		return Day.values()[pos];
	}
}

enum Month {
	JANUARY(31), FEBRUARY(28), MARCH(31), APRIL(30), MAY(31), JUNE(30),
	JULY(31), AUGUST(31), SEPTEMBER(30), OCTOBER(31), NOVEMBER(30), DECEMBER(31);

	private final int days;

	Month(int days) {
		this.days = days;
	}

	public int getDays() { return getDays(false); }

	public int getDays(boolean leap) {
		if (this == FEBRUARY && leap == true) 
			return (this.days + 1);
		else
			return this.days;
	}

	Month next() {
		int pos = this.ordinal();
		pos = (pos + 1) % 12;
		return Month.values()[pos];
	}
}
