package co.yedam.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReplyServiceJdbc implements ReplyService{
	
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String query;

	void disconn() {
		try {
		if (rs != null) {
			rs.close();
		}
		if (psmt != null) {
			psmt.close();
		}
		if (conn != null) {
			conn.close();
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	@Override
	public boolean add(Reply reply) {
		query = "insert into reply (reply_no, reply_content, reply_writer) "//
				+ "values ((select nvl(max(reply_no), 0) + 1 from reply), ?, ?)";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, reply.getReplyContent()); // 두번째 물음표
			psmt.setString(2, reply.getReplyWriter());  // 세번째 물음표
			
			int r = psmt.executeUpdate();
			if(r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	@Override
	public List<Reply> list(int page) {
		List<Reply> list = new ArrayList<Reply>();
		
		conn = Dao.conn();
		query = "select * \r\n" //
				+ "from (select rownum rn, a.*\r\n" // \r\n: 줄바꿈
				+ "      from (select * from reply\r\n" //
				+ "            order by reply_no) a\r\n" //
				+ "      where rownum <= (? * 5)) b\r\n" //
				+ "where b.rn > (? - 1) * 5"; // sql
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, page);
			psmt.setInt(2, page);
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				// rs -> list
				System.out.println(rs.getInt("reply_no"));
				Reply reply = new Reply();
				reply.setReplyNo(rs.getInt("reply_no"));
				reply.setReplyContent(rs.getString("reply_content"));
				reply.setReplyWriter(rs.getString("reply_writer"));
				
				list.add(reply);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	@Override
	public boolean remove(int replyNo) {
		query = "delete from reply where reply_no = " + replyNo;
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			int r = psmt.executeUpdate(); // executeUpdate : insert, update, delete할때 사용하는 메소드
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	@Override
	public boolean listCheck(int brdNo) {
		query = "select brd_no from board where brd_no = ?";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, brdNo);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	@Override
	public int getTotal() {
		query = "select count(*) as cnt from reply";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return 0;
	}

	@Override
	public String getResponseUser(int brdNo) {
		query = "select reply_writer from reply where reply_no = ?";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, brdNo);
			rs = psmt.executeQuery(); // executeQuery : select할때 사용하는 메소드
			if (rs.next()) {
				return rs.getString("reply_writer");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return null;
	}

	@Override
	public void save() {
		
	}
}
