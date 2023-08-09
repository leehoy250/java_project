package co.yedam.array;

public class ArrayExe2 {
	public static void main(String[] args) {
		
		// 변수로 구하는 큰값을 구하는 법
		int num1, num2, num3;
		num1 = 56;
		num2 = 72;
		num3 = 67;
		
		// 큰값:
		int max = 0;
		if(num1 > num2) {
			if(num1 > num3) {
				max = num1;
			} else {
				max = num3;
			}
		} else {
			if (num2 > num3) {
				max = num2;
			} else {
				max = num3;
			}
		}
		System.out.println(max);
		
		max = 0;
		int[] intAry = {num1, num2, num3};
		for(int i = 0; i < intAry.length; i++) {
			if (max < intAry[i]) {
				max = intAry[i];
			}
		}
		System.out.println(max);
		
		
		
		// 정수를 5개 담을 수 있도록 
		int[] ary = new int[5];
		// 1 ~ 100 임의값
		// 5값의 합, 평균
		
		for(int i = 0; i < 5; i++) {
			int rd = (int) (Math.random()*100 +1);
			ary[i] = rd;
		}
		int sum = 0;
		for(int i = 0; i<5; i++) {
			sum += ary[i];
		}
		double avg = 0.0;
		avg = sum / ary.length;
		System.out.printf("배열의 합은 %d이고, 배열의 합의 평균은 %.2f이다.", sum, avg);
	}
}
