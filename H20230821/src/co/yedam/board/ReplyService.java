package co.yedam.board;

import java.util.List;

public interface ReplyService {
	
	public boolean add(Reply reply);
	
	public List<Reply> list(int page);
	public int getTotal();
	
	public boolean remove(int replyNo);
	
	public boolean listCheck(int brdNo);
	
	public String getResponseUser(int brdNo);
	
	public void save();

}
