package co.yedam.board;

public class Reply {
	private int replyNo;
	private int brdNo;
	private String replyContent;
	private String replyWriter;
	
	public Reply() {
		
	}
	public Reply(int brdNo, String replyContent, String replyWriter) {
		super();
		this.brdNo = brdNo;
		this.replyContent = replyContent;
		this.replyWriter = replyWriter;
	}


	public Reply(String content, String writer) {
	}
	public int getReplyNo() {
		return replyNo;
	}


	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}


	public int getBrdNo() {
		return brdNo;
	}


	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
	}


	public String getReplyContent() {
		return replyContent;
	}


	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}


	public String getReplyWriter() {
		return replyWriter;
	}


	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}
	
	public String listInfo() {
		return "댓글번호 = " + replyNo + ", 내용 = " + replyContent + ", 작성자 = "
				+ replyWriter;
	}
}
