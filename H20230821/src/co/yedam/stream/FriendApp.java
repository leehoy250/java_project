package co.yedam.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import co.yedam.friend.Friend;

public class FriendApp {
	Scanner scn = new Scanner(System.in);
	List<Friend> friends = new ArrayList<>();
	
	public FriendApp() {
		loadFile();
	}
	
	public void start() {
		boolean run = true;
		
		while(run) {
			System.out.println("1.등록 2.목록 3.종료");
			System.out.println("선택>> ");
			int menu = scn.nextInt(); // 1 입력하고 엔터
			scn.nextLine();
			if(menu == 1) {
				add();
			} else if(menu == 2) {
				list();
			} else if(menu == 3) {
				System.out.println("종료합니다.");
				saveFile();
				run = false;
			}
		}
	} // end of start
	
	 SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
	private void add() {
		String name = printString("이름입력");
		String phone = printString("연락처입력");
		String birth = printString("생일입력(95-06-03)");
		try {
			Friend fnd = new Friend(name, phone, sdf.parse(birth));
			friends.add(fnd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	private void list() {
		for(Friend fnd: friends) {
			System.out.println(fnd);
		}
	}
	private void saveFile() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// friends 컬랙션에 값 -> 텍스트 저장.
		try {
			FileWriter fw = new FileWriter("C:/temp/friendList.txt");
			for(Friend fnd : friends) {
				String line = fnd.getName() + " " + fnd.getPhone() + " " + sdf.format(fnd.getBirth());
				fw.write(line + "\n");
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		private void loadFile() {
			File file = new File("C:/temp/friendList.txt");
			Scanner scn = null;
			try {
				scn = new Scanner(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			while(scn.hasNext()) {
//				String line = scn.next();
//				System.out.println(line);
//			}
			while(true) {
				String line = null;
				try {
					line = scn.nextLine(); // 한 라인씩 읽어들임
				} catch(NoSuchElementException e) {
					break;				
				}
				 // 홍길동 010-1111-1111 1995-05-05
//				System.out.println(line);
				String[] data = line.split(" ");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					friends.add(new Friend(data[0], data[1], sdf.parse(data[2])));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
	private String printString(String msg) {
		System.out.println(msg + ">> ");
		return scn.nextLine();
	}
}
