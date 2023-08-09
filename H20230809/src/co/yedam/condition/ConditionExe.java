package co.yedam.condition;

//public class ConditionExe {
//	public static void main(String[] args) {
//		// 임의의 수 1,2,3이 나오게해라 1이 나오면 가위, 2가 나오면 바위 3이 나오면 보
//		int value = 1;
//		value = (int) (Math.random() * 3) + 1;
//		String grade = "";
//		
//		if (value == 1) {
//			grade = "가위";
//		} else if (value == 2) {
//			grade = "바위";
//		} else {
//			grade = "보";
//		}
//		System.out.printf("%d는 %s입니다.", value, grade);
//	}
//}


public class ConditionExe {
	public static void main(String[] args) {
		int num = 97;
		byte b1 = 2;
		byte b2 = 2;
		int result = b1 + b2;
		char chr = (char) ((Math.random() * 4) + 65); // 65~68
		System.out.println(chr);
		
		// "abc".equals("asd")
		System.out.print(chr == 'A');
		
		System.out.println("어떤 혜택을 원하세요?");
		char grade = 'C';
		switch(grade) {
		case 'A' : System.out.println("VVIP 혜택을 받으실 수 있습니다.");
		case 'B' : System.out.println("VIP 혜택을 받으실 수 있습니다."); break;
		case 'C' : System.out.println("우수 회원 혜택을 받으실 수 있습니다.");
		case 'D' : System.out.println("일반 회원 혜택을 받으실 수 있습니다."); break;
		default : System.out.println("혜택이 없습니다.");
		}
		System.out.println("감사합니다.");
	}
}