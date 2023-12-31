package co.yedam.generic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExe {
	public static void main(String[] args) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(today.toString());
		System.out.println(sdf.format(today)); // Date -> String     Date를 문자열로 보여주는것
		
		String strTime = "2023-09-01";
		try {
			Date newdate = sdf.parse(strTime); // String -> Date
			System.out.println(newdate.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		} 
	}
}
