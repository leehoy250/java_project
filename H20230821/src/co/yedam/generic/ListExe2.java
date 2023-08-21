package co.yedam.generic;

import java.util.ArrayList;
import java.util.List;

public class ListExe2 {
	public static void main(String[] args) {
		List<Member> list = new ArrayList<Member>();
		list.add(new Member(1001, "Hong")); // 리스트에 바로 선언
		Member member = new Member(1002, "Hwang"); // 따로 변수 선언해서
		list.add(member); // 리스트에 담아줌
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getMemberId() == 1001) {
//				list.get(i).setMemberName("홍");
				list.remove(i);
			}
		}
		
		for(Member mem : list) {
			System.out.printf("이름은 %s\n", mem.getMemberName());
		}
	}
}
