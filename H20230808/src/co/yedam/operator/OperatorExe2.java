package co.yedam.operator;

import java.util.Scanner;

/*
 * 은행 App.
 */
public class OperatorExe2 {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int balance = 0; // 10만원 이상 불가, 마이너스 금액 불가
		boolean run = true;
		
		while(run) {
			
			System.out.println("1.예금 2.출금 3.잔고 4.종료");
			System.out.print("선택>> ");
			
			int menu = Integer.parseInt(scn.nextLine());
			if (menu == 1) {
				System.out.print("입금액 입력>> ");
				int insert = Integer.parseInt(scn.nextLine());
				if (insert > 100000) {
					System.out.println("10만원 이상은 불가합니다");
					continue;
				} else if (insert < 0) {
					System.out.println("마이너스 금액은 불가합니다");
				// 코드작성
			} else if (menu == 2) {
				System.out.println("출금액 입력>> ");
				if (insert > 100000) {
					System.out.println("10만원 이상은 불가합니다");
					continue;
				} else if (insert < 0) {
					System.out.println("마이너스 금액은 불가합니다");
				// 코드작성
			} else if (menu == 3) {
				
				// 코드작성
			}
			} else if (menu == 4) {
					
				// 코드작성
			}	
		}
		System.out.println("end of prog.");
	}
}

