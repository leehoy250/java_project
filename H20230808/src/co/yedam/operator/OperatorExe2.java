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
				} else if (balance + insert > 100000) {
					System.out.println("총 잔액이 10만원을 초과합니다");
					continue;
				} else if (insert < 0) {
					System.out.println("마이너스 금액은 불가합니다");
					continue;
				} else {
					balance += insert;
					System.out.printf("입금액은 %d원이고 잔액은 %d원입니다.\n", insert, balance);
					continue;
				}
				// 코드작성
			} else if (menu == 2) {
				System.out.print("출금액 입력>> ");
				int insert = Integer.parseInt(scn.nextLine());
				if (insert > balance) {
					System.out.printf("잔액 %d원을 초과할 수 없습니다\n", balance);
					continue;
				} else if (insert < 0) {
					System.out.println("마이너스 금액은 불가합니다");
				} else {
					balance -= insert;
					System.out.printf("%d원 출금했고 잔액은 %d원 남았습니다.\n", insert, balance);
				// 코드작성
				}
			} else if (menu == 3) {
				System.out.printf("잔액은 %d원 입니다.\n", balance);
				// 코드작성
			} else if (menu == 4) {
				System.out.println("작업을 종료하겠습니다.");
				break;
				// 코드작성
			}	
		}
		System.out.println("end of prog.");
	}
}

