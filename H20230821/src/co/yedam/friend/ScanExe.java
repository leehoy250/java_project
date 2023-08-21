package co.yedam.friend;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScanExe {
	public static void main(String[] args) {
		File file = new File("src/co/yedam/friend/friends.txt");
		Scanner scn = null;
		try {
			scn = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		while(scn.hasNext()) {
//			String line = scn.next();
//			System.out.println(line);
//		}
		List<Friend> friends = new ArrayList<>();
		while(true) {
			String line = null;
			try {
				line = scn.nextLine();
			} catch(NoSuchElementException e) {
				break;				
			}
			 // 홍길동 010-1111-1111 1995-05-05
//			System.out.println(line);
			String[] data = line.split(" ");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				friends.add(new Friend(data[0], data[1], sdf.parse(data[2])));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(Friend fnd : friends) {
			System.out.println(fnd.toString());
		}
		System.out.println("end of line");
	}
}