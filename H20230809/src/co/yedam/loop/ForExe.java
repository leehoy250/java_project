package co.yedam.loop;

public class ForExe {
	public static void main(String[] args) {
		for(int i=1; i<=4; i++) { // 줄 개수 
			for(int j=1; j<=i; j++) { // 입력 개수
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("--------");
		for (int i=1; i<=4; i++) {
			for(int j=1; j<=4; j++) {
				if(i+j<5) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		System.out.println("end");
	}
}
//	int sum = 0;
//	
//	int i =1;
//	for (i=3; i<=100; i+=3) {
//		sum += i;
//	}
//	System.out.printf("3의 배수의 합은 %d입니다.", sum);
//}
//}

//int sum = 0;
//sum = sum + 1;
//sum = sum + 2;
//sum = sum + 3;
//sum = sum + 4;
//sum = sum + 5;
//
//sum = 0;
//for (int i=1; i<=5; i++) {
//	sum = sum + i;
//}
////System.out.println(sum);
////for(int i=1; i<=10; i++) {
////	System.out.println(i);
////}
