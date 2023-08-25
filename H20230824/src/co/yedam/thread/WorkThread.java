package co.yedam.thread;

import java.awt.Toolkit;

public class WorkThread extends Thread{

	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i=0; i<5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500); // 중간중간 텀을 준다 괄호안의 시간만큼
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
