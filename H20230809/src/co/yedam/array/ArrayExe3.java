package co.yedam.array;

class Student {
	String name;
	int score;
}
public class ArrayExe3 {
	public static void main(String[] args) {
		
		Student[] students = new Student[3];
		
		Student s1 = new Student();
		s1.name = "홍길동";
		s1.score = 95;
		
		Student s2 = new Student();
		s2.name = "김길동";
		s2.score = 92;
		
		Student s3 = new Student();
		s3.name = "박길동";
		s3.score = 90;
		
		students[0] = s1;
		students[1] = s2;
		students[2] = s3;

		int max = 0;
		int idx = 0;
		String name = "";
//		students[0].name + students[0].score;
		for(int i = 0; i < students.length; i++) {
			if(max < students[i].score) {
				max = students[i].score;
//				name = students[i].name;
				idx = i;	
			}
			
		}
		System.out.println(students[idx].name);
		
		
		
		
		String[] names = {"홍길동","김길동","박길동","최길동"};
		int[] scores = {85, 88, 92, 75};
		
		// String: name
		max = 0;
		idx = 0;
		for(int i = 0; i <= 3; i++) {
			if(max < scores[i]) {
				max = scores[i];
				idx = i;
			}
		}
		System.out.println(names[idx]);
	}
}
