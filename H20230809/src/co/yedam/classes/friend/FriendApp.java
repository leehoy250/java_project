package co.yedam.classes.friend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

// 접근지시자(access modifier)
public class FriendApp { // public: 다른 패키지에서도 접속할 수 있게 해주세요

	Friend[] friends = new Friend[10];
	Scanner scn = new Scanner(System.in);

	FriendApp() {

	}

	void addFriend() {
		System.out.println("이름 연락처 생년월일");
		String[] data = scn.nextLine().split(" ");
		// 19950304
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		Date birth = null; // String -> Data

		Friend friend = new Friend(data[0], data[1], data[2]);

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] == null) {
				friends[i] = friend;
				break;
			}
		}
	} // addFriend()의 끝부분

	void list() {
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null) {
				System.out.println(friends[i].toString());
			}
		}
	}

	void findFriend() {
		System.out.println("이름을 입력하세요>> ");
		String name = scn.nextLine();
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && friends[i].getName().equals(name)) {
				System.out.printf("이름: %s, 연락처: %s, 생년월일: %s\n", friends[i].getName(), friends[i].getPhone(), friends[i].getBirth());
			}
		}
	}
	
	static void start() {

		FriendApp app = new FriendApp();
		Scanner scn = app.scn;
		boolean run = true;

		while (run) {
			System.out.println("1.등록 2.목록 3.조회(이름) 4.수정 5.삭제 9.종료");
			System.out.print("선택>> "); // findFriend/ editFriend/ delFriend

			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case Menu.ADD:
				app.addFriend();
				break;
			case Menu.LIST:
				app.list();
				break;
			case Menu.SEARCH:
				app.findFriend();
				break;
			case Menu.EDIT:
				app.editFriend();
				break;
			case Menu.DEL:
				app.delFriend();
				break;
			case Menu.EXIT:
				System.out.println("종료합니다.");
				run = false;
			} // switch의 끝부분
		} // while의 끝부분
	} // start()의 끝부분 
} // class의 끝부분
