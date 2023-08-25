package co.yedam.thread;

import java.awt.Toolkit;

public class BeepPrintExe {
	public static void main(String[] args) {
		
		// 스레드 생성 
		// 1. Runnable 인터페이스를 구현하는 객체를 Thread(생성자 매개값).
		// 2. Thread를 상속하는 클래스를 작성
		// 메인스레드(Toolkit toolkit = Toolkit.getDefaultToolkit();)와 작업 스레드(System.out.println("띵");)를 병렬로 처리
		Thread beep;
		beep = new Thread(new BeepTask());
		beep = new WorkThread();
		// 1-1. Runnable 앤터페이스를 구현하는 익명객체 생성
		//      Functional Interface.(구현할 메소드 한개만 존재)
		beep = new Thread(() -> {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			for (int i=0; i<5; i++) {
				toolkit.beep();
				try {
					Thread.sleep(500); // 중간중간 텀을 준다 괄호안의 시간만큼
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}	
		});
		beep.start();
		
		for (int i=0; i<5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500); // 중간중간 텀을 준다 괄호안의 시간만큼
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
