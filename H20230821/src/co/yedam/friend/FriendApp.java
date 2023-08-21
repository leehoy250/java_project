package co.yedam.friend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FriendApp {
	//  추가, 수정, 삭제, 목록:
	Map<String, String> userList = new HashMap<>();
	List<Friend> friends = new ArrayList<Friend>();
	Scanner scn = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
	String name = "";
	String phone = "";
	Date birth;
	
	// 생성자
	public FriendApp() {
		userList.put("user1", "1234");
		userList.put("user2", "5678");
		userList.put("user3", "9087");
	}
	
	private boolean userCheck() {
		
		System.out.println("id>> ");
		String id = scn.nextLine();
		System.out.println("pw>> ");
		String pw = scn.nextLine();

		if(userList.containsKey(id)) { // id 체크
			if(userList.get(id).equals(pw)) { // pw 체크
				return true;
			}
		}
		return false;
	}
	
	public void start() {
		boolean run = true;
		
		while(true) {
			if(userCheck()) {
				break;
			}
			System.out.println("로그인 실패...");
		}
		
		while(run) {
			System.out.println("1.추가 2.수정 3.삭제 4.목록 5.종료");
			System.out.println("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());
			if (menu == 1) {
				add();
			} else if(menu == 2) {
				edit();
			} else if(menu == 3) {
				del();
			} else if(menu == 4) {
				list();
			} else if(menu == 5) {
				System.out.println("종료합니다.");
				run = false;
			}
		} // while의 끝
			
	} // start의 끝
	private void add() {
		// 이름, 연락처, 생년월일. 입력
		// Friend 인스턴스를 생성
		// friends 컬랙션에 추가
		System.out.println("이름>> ");
		name = scn.nextLine();
		
		System.out.println("연락처>> ");
		phone = scn.nextLine();
		
		System.out.println("생년월일>> ");
		try {
			birth = sdf.parse(scn.nextLine());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		friends.add(new Friend(name, phone, birth));
	}
	private void edit() {
		System.out.println("이름>> ");
		name = scn.nextLine();
		for(int i=0; i<friends.size(); i++) {
			if(friends.get(i).getName().equals(name)) { // equals 문자를 비교할때 사용
				System.out.println("연락처>> ");
				phone = scn.nextLine();
				friends.get(i).setPhone(phone);
			}
		}
	}
	private void del() {
		System.out.println("이름>> ");
		name = scn.nextLine();
		for(int i=0; i<friends.size(); i++) {
			if(friends.get(i).getName().equals(name)) {
				friends.remove(i);
			}
		}
	}
	private void list() {
		for(int i=0; i<friends.size(); i++) {
			System.out.printf("이름은 %s이고, 연락처는 %s이고, 생년월일은 %s입니다.\n", friends.get(i).getName(), friends.get(i).getPhone(), 
					sdf.format(friends.get(i).getBirth()));
		}
	}
}
