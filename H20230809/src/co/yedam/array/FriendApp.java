package co.yedam.array;

import java.util.Scanner;

public class FriendApp {
	static Friend[] friends = new Friend[10];
	static Scanner scn = new Scanner(System.in);
	static String name;
	static String phone;
	static Gender gender;
	
	public static void add() {
		System.out.print("이름>> ");
		name = scn.nextLine();
		
		System.out.print("연락처>> ");
		phone = scn.nextLine();
		
		System.out.print("성별(1:남자,2:여자>> ");
		gender = null;
		
		int choice = Integer.parseInt(scn.nextLine());
		
		if (choice == 1) {
			gender = Gender.MEN;
		} else {
			gender = Gender.WOMEN;
		}
		Friend fnd = new Friend();
		fnd.name = name;
		fnd.phone = phone;
		fnd.gender = gender;
		
		boolean nullExist = false;
		for (int i=0; i < friends.length; i++) {
			if (friends[i] == null) {
				friends[i] = fnd;
				nullExist = true;
				break;
			}	
		}
		if (nullExist)
			System.out.println("저장성공");
		else
			System.out.println("저장실패");
	}
	
	public static void edit() {
		System.out.println("이름>> ");
		name = scn.nextLine();
		if (!checkFriend(name)) {
			System.out.println("찾는 이름이 없습니다.");
			return;
		}
		System.out.println("연락처>> ");
		phone = scn.nextLine();
		
		for (int i=0; i < friends.length;i++) {
			if(friends[i] != null) {
				if(friends[i].name.equals(name)) {
					friends[i].phone = phone;
					break; // for의 break
				}
			}
		}
	}
	
	public static void del() {
		System.out.println("이름>> ");
		name = scn.nextLine();
		if (!checkFriend(name)) {
			System.out.println("찾는 이름이 없습니다.");
			return;
		}
		for (int i=0; i<friends.length; i++) {
			if (friends[i] != null //
					&& friends[i].name.equals(name)) {
				friends[i] = null; // 삭제
				break;
			}
		}
	}
	
	public static void list() {
		System.out.println("이름>> ");
		name = scn.nextLine();
		if (!checkFriend(name)) {
			System.out.println("찾는 이름이 없습니다.");
			return;
		}
		for (int i=0; i<friends.length; i++) {
			if (friends[i] != null //
					&& friends[i].name.equals(name)) {
				friends[i].showInfo();
				break;
			}
		}
	}
	
	public static void search() {
		for (int i=0; i<friends.length; i++) {
			if (friends[i] != null) {
				friends[i].briefInfo(); 
			}
		}
	}
	// boolean checkFriend(String name) {}
	public static boolean checkFriend(String name) {
		for(int i=0; i<friends.length; i++) {
			if(friends[i] != null && friends[i].name.equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
	// 추가, 수정, 삭제, 조회, 목록
	
	boolean run = true;	
	Friend[] friends = new Friend[10];
	
	
	// 초기값
//	for (int i=0; i<friends.length; i++) {
//		Friend f = new Friend();
//		f.name = "test" + i;
//		f.phone = "010-3245-456" + i;
//		f.gender = i % 2 == 0 ? Gender.MEN : Gender.WOMEN;
//		
//		friends[i] = f;
//	}
	
	
	
	while (run) {
		System.out.println("1.추가 2.수정 3.삭제 4.조회 5.목록 6.종료");
		System.out.print("선택>> ");
		
		int menu = Integer.parseInt(scn.nextLine());
		
		switch (menu) {
		case 1:
			add(); break;
			
		case 2:
			edit(); break; // switch의 break
			
		case 3:
			del(); break;
			
		case 4: // 조회: 이름-연락처-성별
			list(); break;
			
		case 5: // 목록: 이름-연락처
			search(); break;
			
		case 6: // 종료
			System.out.println("종료합니다.");
			run = false;
			
		default:
			System.out.println("메뉴를 다시 선택하세요.");
		}
	}
}
}

//return; // 메소드의 실행을 중지하겠습니다
