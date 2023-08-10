package co.yedam.array;

public class CalendarExe {
	public static void main(String[] args) {
		int month = 2;
		
		String[] days = {"Sun", "Mon", "Tue", "Wen", "Thu", "Fri", "Sat"};
		
		for (int i = 0; i < days.length; i++){
			System.out.printf("%4s", days[i]);
		}
		System.out.println();
		// 달력, 31까지
		int space = getFirstDay(month);
		for(int i = 0; i < space; i++) {
			System.out.printf("%4s", " ");
		}
		for(int i = 1; i <= getLastDate(month); i++) {
			System.out.printf("%4d", i);
			if ((i + space) % 7 == 0) {
				System.out.println();
			}
		}
	}
	
	public static int getFirstDay(int month) {
		int day = 0;
		int totalDays = 0;
		for (int i = 1; i <= month - 1; i++) {
			totalDays += getLastDate(i);
		}
		day = day + totalDays % 7;
		
//		switch (month) {
//		case 1:
//			day = 0;
//			break;
//			
//		case 7:
//			day = 6;
//			break;
//			
//		case 8:
//			day = 2;
//			break;
//		}
		return day;
	}
	
	public static int getLastDate(int month) {
		int lastDate = 31;
		
		switch (month) {
		case 4:
		case 6:
		case 9:
		case 11:
			lastDate = 30;
			break;
		case 2:
			lastDate = 28;
		}
		return lastDate;
	}
}

