package co.yedam.variable;

import java.util.Scanner;

/*
 * Scanner 클래스 활용.
 */
public class VariableExe5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // 스캐너(키보드 입력)
		
		String numStr = "123";
		int num = Integer.parseInt(numStr); // "123" -> 123 변환
		System.err.println(num);
		
		int sum = 0;
		
		while (true) {
			System.out.println("정수값을 입력: 종료하려면 quit >>>");
			String result = scan.nextLine(); // 입력값을 문자열로 반환.
			System.out.printf("입력값은 %s입니다. \n", result);
			
			if(result.equals("quit")) { // 숫자 비교할때는 == , 문자 비교할때는 .equals("문자")
				break;
			}
			// 입력값이 100보다 크거나 0보다 작으면 합계 안하고 
			// 범위안의 값만 합하도록..
			int numParser = Integer.parseInt(result);
			if (numParser > 100 || numParser < 0) { // 조건을 만족못하면 다시 처리
				continue;
			} else {				
				sum = sum + Integer.parseInt(result);
			}
		}
		System.out.println("입력값의 합계는 " + sum);
		System.out.println("end of prog.");
	}
}
