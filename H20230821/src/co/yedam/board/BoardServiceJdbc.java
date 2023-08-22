package co.yedam.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardServiceJdbc implements BoardService{
	
	// Connection 객체 db연결하기위한 객체
	// PreparedStatement 객체
	// ResultSet 객체 결과를 잠시 담아두기 위한 객체
	// String 쿼리
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String query;

	@Override
	public boolean add(Board board) {
		return false;
	}

	@Override
	public List<Board> list(int page) {
		List<Board> list = new ArrayList<Board>();
		
		conn = Dao.conn();
		query = "select * from board";
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery();
			while(rs.next()) {
				// rs -> list
				System.out.println(rs.getInt("brd_no"));
				Board board = new Board();
				board.setBrdNo(rs.getInt("brd_no"));
				board.setBrdTitle(rs.getString("brd_title"));
				board.setBrdWriter(rs.getString("brd_writer"));
				
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getTotal() {
		return 0;
	}

	@Override
	public boolean modify(Board board) {
		return false;
	}

	@Override
	public boolean remove(int brdNo) {
		query = "delete from board where brd_no = " + brdNo;
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			int r = psmt.executeUpdate(); // executeUpdate : insert, update, delete할때 사용하는 메소드
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Board search(int brdNo) {
		query = "select * from board where brd_no = " + brdNo;
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery(); // executeQuery : select할때 사용하는 메소드
			if (rs.next()) {
				Board board = new Board();
				board.setBrdNo(rs.getInt("brd_no"));
				board.setBrdTitle(rs.getString("brd_title"));
				board.setBrdWriter(rs.getString("brd_writer"));
				board.setWriteDate(rs.getDate("write_date"));
				board.setUpdateDate(rs.getDate("update_date"));
				
				return board;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void save() {
		
	}

}
