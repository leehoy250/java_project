package co.yedam.array;

public class TodoApp {
	public static void main(String[] args) {
		// 등록/완료/조회(날짜)/미완료/
		// 등록: 2 할일 0812
		// 완료: 1 2 4 엔터치면 1 2 4의 상태를 바꿔주게
		// 조회(날짜): 0812 날짜를 넣어주면 날짜에 등록되어 있는 값을 나타내주기
		// 미완료: 목록 리스트로 다 보여주기 순번을 기준으로 보여주기 작은놈이 먼저 나오게
	}
	
	
	// 숫자 작은 거부터 큰 숫자로 정렬
	public static void sortSample() {
		int[] intAry = {45, 23, 90, 77, 12};
		int len = intAry.length -1;
		for(int j = 0; j < len; j++) {
			for(int i = 0; i < len; i++) {
				if (intAry[i] > intAry[i+1]) {
					int tmp = intAry[i];
					intAry[i] = intAry[i+1];
					intAry[i + 1] = tmp;
				}
			}		
		}
		
		for(int num : intAry)
			System.out.println(num);
	}
}
