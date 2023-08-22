package co.yedam.board;

import java.util.List;
import java.util.Scanner;

public class BoardApp {
	
	Scanner scn = new Scanner(System.in);
	BoardService service = new BoardServiceJdbc();
	UserService uservice = new UserServiceImpl();
	String logId;
	
	public void start() {
//		while(true) {
//			String id = printString("id");
//			String pw = printString("pw");
//			User user = new User(id, pw);
//			if(uservice.checkLogin(user)) {
//				System.out.println("로그인성공");
//				logId = id;
//				break;		
//			}
//			System.out.println("로그인실패");			
//		}

		// id / pw
		
		boolean run = true;
		
		while(run) {
			System.out.println("1.글등록 2.목록 3.수정 4.삭제 5.상세조회 9.종료");
			System.out.println("선택>> ");
			
			int menu = scn.nextInt(); scn.nextLine();
			
			switch(menu) {
			case 1: // 등록
				register();
				break;
				
			case 2: // 목록
				boardList();
				break;
				
			case 3: // 수정
				modify();
				break;
				
			case 4:
				remove();
				break;
				
			case 5:
				search();				
				break;
				
			case 9:
				System.out.println("종료합니다.");
				service.save();
				run = false;
			}
		}
		System.out.println("end of prog");
	}// end of start
	
	private String printString(String msg) {
		System.out.println(msg + ">> ");
		return scn.nextLine();
	}
	
	void register() {
		String title = printString("제목입력");
		String content = printString("내용입력");
		String writer = logId;//printString("작성자입력");
		Board board = new Board(title, content, writer);
		
		if (service.add(board)) {
			System.out.println("등록성공!!");
		}
	}
	void boardList() {
		//String pageNo = printString("페이지입력");
		int page = 1;
		
		while(true) {
			List<Board> list = service.list(page);
			System.out.println("글번호    제목    작성자");
			System.out.println("-------------------------");
			for (Board b : list) {
				System.out.println(b.listInfo());
			}
			// 4 > 1page, 9 > 2page, 19 > 4page
			int totalCnt = service.getTotal();
			int lastPage = (int) Math.ceil(totalCnt/5.0);
			for (int i=1; i<=lastPage; i++) {
				if (i == page) {
					System.out.printf("[%3d]", i);			
				} else {
					System.out.printf("%3d", i);
				}
			}
			System.out.println();
			System.out.println("조회페이지 입력(exit: 9)>> ");
			page = scn.nextInt();	
			if(page == 9) {
				break;
			}
		}
	}
	void modify() {
		String brdNo = printString("번호입력");
		String content = printString("내용입력");
		Board brd = new Board();
		brd.setBrdNo(Integer.parseInt(brdNo));
		brd.setBrdContent(content);
		if (service.modify(brd)) {
			System.out.println("수정성공!!");
		}
	}
	void remove() {
		String brdNo = printString("번호입력");
		if (service.remove(Integer.parseInt(brdNo))) {
			System.out.println("삭제성공!!");
		}
	}
	void search() {
		String brdNo = printString("번호입력");
		Board result = service.search(Integer.parseInt(brdNo));
		if (result == null) {
			System.out.println("해당글번호가 없습니다.");
		} else {
			System.out.println(result.showInfo());			
		}
	}

	
	
	
}
