package co.yedam.array;

import java.util.Scanner;
	
}
public class StudentApp {
	public static void main(String[] args) {
		Student[] students = new Student[10];
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int idx = 0;
		
		// 1. 등록 2.조회 3.목록
//		1. 등록 : 학생의 이름, 점수를 입력 
//		2. 조회 : 학생 이름을 넣으면 학생 정보가 나오게
//		3. 목록 : 전체 학생의 이름과 점수를 볼 수 있게
		
		while (run) {
			System.out.printf("1.등록 2.조회 3.목록 4.종료");
			System.out.print("선택>> ");
			
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1: System.out.println("이름을 입력하세요.");
			String name = Integer.toString(scn.nextLine());
			System.out.println("점수를 입력하세요");
			int score = 0;
				// 이름, 점수 : 입력 
			case 2: // 이름 입력 -> 점수 출력 
			case 3: // 이름, 점수 출력
			case 4: // 종료 run 값을 fault로
 			}
		}
		System.out.println("end");
	}
}

//Student s1 = new Student();
//s1.name = "홍길동";
//s1.score = 95;
//
//Student s2 = new Student();
//s2.name = "김길동";
//s2.score = 92;
//
//Student s3 = new Student();
//s3.name = "박길동";
//s3.score = 90;
//
//students[0] = s1;
//students[1] = s2;
//students[2] = s3;