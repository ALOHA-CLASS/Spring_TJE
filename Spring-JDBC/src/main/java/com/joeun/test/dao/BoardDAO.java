package com.joeun.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.joeun.test.dto.Board;

@Repository			// 데이터 액세스 객체로 빈 등록
public class BoardDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 게시글 목록 조회
	 * @return
	 */
	public List<Board> list() {
	
		String sql = " SELECT * FROM board ";
		List<Board> boardList = jdbcTemplate.query(sql, new RowMapper<Board>() {
			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Board board = new Board();
				board.setBoardNo( rs.getInt("board_no") );
				board.setTitle( rs.getString("title") );
				board.setWriter( rs.getString("writer") );
				board.setContent( rs.getString("content") );
				board.setRegDate( rs.getTimestamp("reg_date") );
				board.setUpdDate( rs.getTimestamp("upd_date") );
				board.setViews( rs.getInt("views") );
				return board;
			}
		});
		
		return boardList;
	}
	
	
	
	public Board select(int boardNo) {
		String sql = " SELECT * FROM board WHERE board_no = ? ";
		
//		List<Board> boardList = jdbcTemplate.query(sql, new RowMapper<Board>() {
//			@Override
//			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Board board = new Board();
//				board.setBoardNo( rs.getInt("board_no") );
//				board.setTitle( rs.getString("title") );
//				board.setWriter( rs.getString("writer") );
//				board.setContent( rs.getString("content") );
//				board.setRegDate( rs.getTimestamp("reg_date") );
//				board.setUpdDate( rs.getTimestamp("upd_date") );
//				board.setViews( rs.getInt("views") );
//				return board;
//			}
//		}, boardNo);
//		
//		Board board = null; 
//		if( boardList.isEmpty() ) 
//			board = null;
//		else 
//			board = boardList.get(0);
		
		// 2번째 방법
		Board board = jdbcTemplate.queryForObject(sql, new RowMapper<Board>() {
			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Board board = new Board();
				board.setBoardNo( rs.getInt("board_no") );
				board.setTitle( rs.getString("title") );
				board.setWriter( rs.getString("writer") );
				board.setContent( rs.getString("content") );
				board.setRegDate( rs.getTimestamp("reg_date") );
				board.setUpdDate( rs.getTimestamp("upd_date") );
				board.setViews( rs.getInt("views") );
				return board;
			}
		}, boardNo);
		
		// 3번째 방법
//		Object[] argList = new Object[]{boardNo};
//		Board board = jdbcTemplate.queryForObject(sql, argList, new RowMapper<Board>() {
//			@Override
//			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Board board = new Board();
//				board.setBoardNo( rs.getInt("board_no") );
//				board.setTitle( rs.getString("title") );
//				board.setWriter( rs.getString("writer") );
//				board.setContent( rs.getString("content") );
//				board.setRegDate( rs.getTimestamp("reg_date") );
//				board.setUpdDate( rs.getTimestamp("upd_date") );
//				board.setViews( rs.getInt("views") );
//				return board;
//			}
//		});
		
		return board;
	}
	
	public int insert(Board board) {
		String sql = " INSERT INTO board(title, writer, content) "
				   + " VALUES ( ?, ?, ? ) ";
		
		Object[] args = new Object[] {board.getTitle(), board.getWriter(), board.getContent()};
		
		int result = jdbcTemplate.update(sql, args);
		// int result = jdbcTemplate.update(sql, board.getTitle(), board.getWriter(), board.getContent());
		return result;
	}
	
	public int update(Board board) {
		String sql = " UPDATE board "
				   + "    SET title = ? "
				   + "       ,writer = ? "
				   + "       ,content = ? "
				   + "		 ,upd_date = now() "
				   + " WHERE board_no = ? ";
		
		Object[] args = new Object[] {board.getTitle(), board.getWriter(), board.getContent(), board.getBoardNo()};
		int result = jdbcTemplate.update(sql, args);
		return result;
	}
	
	public int delete(int boardNo) {
		String sql = " DELETE FROM board "
				   + " WHERE board_no = ? ";
		
		Object[] args = new Object[] {boardNo};
		int result = jdbcTemplate.update(sql, args);
		return result;
	}
	
	

}







