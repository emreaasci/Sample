package org.csystem.app.samples.date;

public class DateApp {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("G�n?");
			int day = Integer.parseInt(kb.nextLine());
			
			if (day == 0)
				break;
			
			System.out.print("Ay?");
			int month = Integer.parseInt(kb.nextLine());
			
			System.out.print("Y�l?");
			int year = Integer.parseInt(kb.nextLine());
			
			DateUtil.displayDateTR(day, month, year);
		}
		
		System.out.println("Tekrar yap�yor musunuz?");	
	}
}
