package co.yedam.classes.student;

public class Student {
	// 필드
	private int stdNo; // int 초기값 0
	private String stdName; // String 초기값 null
	private int score; // int 초기값 0
	
	// 생성자: 필드의 값 초기화
	Student() {
		// 기본생성자. 기본 인스턴스 만들어 주는 역할
	}
	
	Student(int stdNo) {
		// 기본생성자. 기본 인스턴스 만들어 주는 역할
	}
	
	Student(int stdNo, String stdName, int score) { // 매개변수 int stdNO
		this.stdNo = stdNo; // this.stdNo = s1.stdNo(StudentExe class에 있음)
		this.stdName = stdName;
		this.score = score;
	}
	
	// 메소드
	void stdInfo() {
		System.out.println("학번: " + stdNo + //
				", 학생이름: " + stdName + //
				", 점수: " + score);
	}
	
	void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}
	
	void setStdName(String stdName) {
		this.stdName = stdName;
	}
	
	void setScore(int score) {
		if (score < 0) {
			this.score = 0;
		} else {
			this.score = score;
		}
	}

	// getter
	public int getStdNo() {
		return stdNo;
	}

	public String getStdName() {
		return stdName;
	}

	public int getScore() {
		return score;
	}
	
}
