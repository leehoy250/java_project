package co.yedam.files;

import java.io.File;
import java.io.IOException;


public class FileExe {
	public static void main(String[] args) {
		String msg = "파일에 관한 정보를 보여주는 클래스 file";
		timeMsg(msg);
		
		String[] names = {"홍길동", "최길동", "박길동", "김길동"};
		File path = new File("c:/temp");
		if (!path.exists()) {
			path.mkdir();
		}
		for(int i=0; i<names.length; i++) {
			if(path.exists()) {
				File folder = new File("c:/temp/" + names[i] + ".txt");
				try {
					folder.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

	private static void timeMsg(String msg) {
		for(int i=0; i<msg.length();i++) {
			System.out.print(msg.charAt(i));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

		
	
	

