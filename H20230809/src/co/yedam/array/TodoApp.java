package co.yedam.array;

import java.util.Scanner;

public class TodoApp {
	public static void main(String[] args) {
		// 등록/완료/조회(날짜)/미완료/
		// 등록: 2 할일 0812
		// 완료: 1 2 4 엔터치면 1 2 4의 상태를 바꿔주게
		// 조회(날짜): 0812 날짜를 넣어주면 날짜에 등록되어 있는 값을 나타내주기
		// 미완료: 목록 리스트로 다 보여주기 순번을 기준으로 보여주기 작은놈이 먼저 나오게 1, 2, 4, 3, 6, 5
	boolean run = true; 
	Scanner scn = new Scanner(System.in);
	Todo[] todos = new Todo[10];
	
	
	while(run) {
		System.out.println("1.등록, 2.완료, 3.조회(날짜), 4.미완료");
		System.out.print("선택>> ");
		
		int menu = Integer.parseInt(scn.nextLine());
		
		switch (menu) {
		case 1:
			Todo t = new Todo();
			System.out.println("순서>> ");
			t.no = Integer.parseInt(scn.nextLine());
			
			System.out.println("할일>> ");
			t.todo = scn.nextLine();
			
			System.out.println("날짜>> ");
			t.dueDate = scn.nextLine();
		
		case 2: 
			
		case 3: // 날짜를 입력하면 날짜에 등록되어 있는 값 나타내기
			for(int i = 0; i < todos.length; i++) {
				if(todos[i] != null) {
					
				}
			}
		}
			
	
	
		
	
	
			
		
				
	
	
			
//			case 3:
//				for ()
//				for (int i = 0; i < todos.length - 1; i++) {
//					Todo tmp = new Todo();
//					if (todos[i].no < todos[i + 1]) {
//						tmp = todos[i];
//						todos[i] = todos[i];
//						todos[i + 1] = tmp;
//					}
//				}
	// 숫자 작은 거부터 큰 숫자로 정렬
//	public static void sortSample() {
//		int[] intAry = {45, 23, 90, 77, 12};
//		int len = intAry.length -1;
//		
//		for(int j = 0; j < len; j++) {
//			for(int i = 0; i < len; i++) {
//				if (intAry[i] > intAry[i+1]) {
//					int tmp = intAry[i];
//					intAry[i] = intAry[i+1];
//					intAry[i + 1] = tmp;
//				}
//			}		
//		}
//		
//		for(int num : intAry)
//			System.out.println(num);
//	}
}
}
