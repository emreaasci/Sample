package org.csystem.app.samples.date;

public class DateUtil {
	public static int [] daysOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static String [] monthsTR = {
			"", "Ocak", "�ubat", "Mart", "Nisan", "May�s", "Haziran", "Temmuz",
			"A�ustos", "Eyl�l", "Ekim", "Kas�m", "Aral�k"};
	public static String [] monthsEN = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	public static String [] daysOfWeekTR = {"Pazar", "Pazartesi", "Sal�", "�ar�amba", "Per�embe", "Cuma", "Cumartesi"};
	public static String [] daysOfWeekEN = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

	public static void displayDateTR(int day, int month, int year)
	{
		int dayOfWeek = getDayOfWeek(day, month, year);

		if (dayOfWeek == -1) {
			System.out.println("Ge�ersiz tarih");
			return;
		}
		System.out.printf("%d %s %d %s%n", day, monthsTR[month], year, daysOfWeekTR[dayOfWeek]);

		if (isWeekend(day, month, year))
			System.out.println("Bug�n kurs var tekrar yapt�n�z m�?");
		else
			System.out.println("Hafta sonu kurs var. Tekrar yapmay� unutmay�n�z!!!");
	}

	public static void displayDateEN(int day, int month, int year)
	{
		int dayOfWeek = getDayOfWeek(day, month, year);

		if (dayOfWeek == -1) {
			System.out.println("Invalid Date");
			return;
		}
		System.out.printf("%d%s %s %d %s%n", day, getDaySuffix(day), monthsEN[month], year, daysOfWeekEN[dayOfWeek]);

		if (isWeekend(day, month, year))
			System.out.println("It is course day. I hope you reviewed!....");
		else
			System.out.println("There will be a course on weekend. Do not forget to review!...");
	}

	public static boolean isWeekend(int day, int month, int year)
	{
		int dayOfWeek = getDayOfWeek(day, month, year);

		return dayOfWeek == 0 || dayOfWeek == 6;
	}

	public static boolean isWeekday(int day, int month, int year)
	{
		return !isWeekend(day, month, year);
	}


	public static int getDayOfWeek(int day, int month, int year)
	{
		int totalDays;

		if (year < 1900 || (totalDays = getDayOfYear(day, month, year)) == -1)
			return -1;

		for (int y = 1900; y < year; ++y)
			totalDays += isLeapYear(y) ? 366 : 365;

		return totalDays % 7;
	}

	public static String getDateTR(int day, int month, int year)
	{
		return String.format("%d %s %d %s", day, getMonthTR(month), year, getDayOfWeekTR(day, month, year));
	}

	public static String getDayOfWeekTR(int day, int month, int year)
	{
		return daysOfWeekTR[getDayOfWeek(day, month, year)];
	}

	public static String getMonthTR(int month)
	{
		return monthsTR[month];
	}

	public static int getDayOfYear(int day, int month, int year)
	{
		return isValidDate(day, month, year) ? day + getTotalDaysByMonth(month, year) : -1;
	}

	public static int getTotalDaysByMonth(int month, int year)
	{
		int totalDays = 0;

		for (int m  = month - 1; m >= 1; --m)
			totalDays += daysOfMonth[m];

		return month > 2 && isLeapYear(year) ? totalDays + 1 : totalDays;
	}

	public static boolean isValidDate(int day, int month, int year)
	{
		if (day < 1 || day > 31 || month < 1 || month > 12)
			return false;

		return day <= (month == 2 && isLeapYear(year) ? 29 : daysOfMonth[month]);
	}

	public static String getDaySuffix(int day)
	{
		String suffix = "th";

		switch (day) {
			case 1:
			case 21:
			case 31:
				suffix = "st";
				break;
			case 2:
			case 22:
				suffix = "nd";
				break;
			case 3:
			case 23:
				suffix = "rd";
				break;
		}

		return suffix;
	}

	public static boolean isLeapYear(int year)
	{
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
}