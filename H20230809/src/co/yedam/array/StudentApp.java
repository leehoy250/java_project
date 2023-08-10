package co.yedam.array;

import java.util.Scanner;
	

public class StudentApp {
	public static void main(String[] args) {
		Student[] students = new Student[10];
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int idx = 0;
		
		// 초기값
		Student s1 = new Student();
		s1.name = "홍길동";
		s1.score = 95;
		s1.height = 178.9;
		s1.gender = Gender.WOMEN;


		Student s2 = new Student();
		s2.name = "김길동";
		s2.score = 92;
		s2.height = 169.9;
		s2.gender = Gender.MEN;

		Student s3 = new Student();
		s3.name = "박길동";
		s3.score = 90;
		s3.height = 188.9;
		s3.gender = Gender.MEN;

		students[0] = s1;
		students[1] = s2;
		students[2] = s3;
		
		// 1. 등록 2.조회 3.목록
		// 1. 등록 : 학생의 이름, 점수를 입력 
		// 2. 조회 : 학생 이름을 넣으면 학생 정보가 나오게
		// 3. 목록 : 전체 학생의 이름과 점수를 볼 수 있게
		
		while (run) {
			System.out.println("1.등록 2.조회 3.목록 4.키가 제일 큰 학생 5.종료");
			System.out.print("선택>> ");
			
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1: // 이름, 점수, 키 : 입력 
				Student s = new Student();
				System.out.println("이름을 입력하세요.");
				s1.name = scn.nextLine();
				System.out.println("점수를 입력하세요");
				s1.score = Integer.parseInt(scn.nextLine());
				System.out.println("키를 입력하세요");
				s1.height = Double.parseDouble(scn.nextLine());
				students[idx] = s;
				idx++;
				break;
				
			case 2: // 이름 입력 -> 점수 출력 
				boolean isExist = false;
				System.out.println("이름");
				String name = scn.nextLine();
				for(int i = 0; i < students.length; i++) {
					if (students[i] != null && students[i].name.equals(name)) {
						System.out.printf(" %s의 점수: %d\n",students[i].name, students[i].score);
						isExist = true;
					}
				}
				if (!isExist) {
					System.out.printf("%s라는 이름이 목록에 없습니다.\n", name);
				}
				break;
				
			case 3: // 이름, 점수 출력
				for(int i=0; i<students.length;i++) {
					if (students[i] != null && students[i].gender == Gender.MEN) {
					System.out.printf("이름: %s, 점수: %d\n", students[i].name, students[i].score);
					}
				}
				break;
				
			case 4: // 키가 제일 큰 학생을 찾아서 이름을 반환
				Student max = new Student();
				if (students[0] == null) {
					System.out.println("조회가능한 목록이 없습니다.");
					continue;
				}
					for (int i=0; i<students.length; i++) {
						if (students[i] != null) {
							if (max.height < students[i].height) {
								max = students[i];
							}
						}
					}
					System.out.printf("이름: %s, 키: %.1f\n", max.name, max.height);
				break;
				
			case 5: // 종료 run 값을 false로
				System.out.println("종료합니다");
				run = false;
 			}
		}
		System.out.println("end");
	}
}

