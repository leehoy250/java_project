package co.yedam.classes.student;

public class Calculator {
	double pi = 3.14; // 인스턴스 멤버
	
	// 인스턴스 멤버
	public double sum (double n1, double n2) {
		return n1 + n2;
	}
	
	public double minus(double n1, double n2) {
		return n1 - n2;
	}
	
	// static: 클래스에 사용이 될때 이미 사용될 준비가 되어있다는 의미
	public static double multi(double n1, double n2) {
		return n1 * n2;
	}
}
