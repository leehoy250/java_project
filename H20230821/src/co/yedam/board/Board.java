package co.yedam.board;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Board implements Serializable{
	private int brdNo; // brd_no 오라클식 두 단어 표현(카멜페이스)
	private String brdTitle;
	private String brdContent;
	private String brdWriter;
	private Date writeDate;
	private Date updateDate;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	// constructor.
	public Board() {
		
	}
	public Board(String brdTitle, String brdContent, String brdWriter) {
		super();
		this.brdTitle = brdTitle;
		this.brdContent = brdContent;
		this.brdWriter = brdWriter;
	}
	
	// get, set
	public int getBrdNo() {
		return brdNo;
	}
	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
	}
	public String getBrdTitle() {
		return brdTitle;
	}
	public void setBrdTitle(String brdTitle) {
		this.brdTitle = brdTitle;
	}
	public String getBrdContent() {
		return brdContent;
	}
	public void setBrdContent(String brdContent) {
		this.brdContent = brdContent;
	}
	public String getBrdWriter() {
		return brdWriter;
	}
	public void setBrdWriter(String brdWriter) {
		this.brdWriter = brdWriter;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	@Override
	public String toString() {
		return "Board [글번호=" + brdNo + ", 제목=" + brdTitle + ", 내용=" + brdContent + ", 작성자="
				+ brdWriter + ", 입력일=" + writeDate + ", 수정일=" + updateDate + "]";
	}
	
	public String listInfo() {
		return "글번호 = " + brdNo + ", 제목 = " + brdTitle + ", 작성자 = "
				+ brdWriter;
	}
	
	public String showInfo() {
		return "글번호 = " + brdNo + ", 제목 = " + brdTitle + ", 작성자 = "
+ brdWriter + ", 입력일 = " + sdf.format(writeDate) + ", 수정일 = " + sdf.format(updateDate);
	}
	
	
}
