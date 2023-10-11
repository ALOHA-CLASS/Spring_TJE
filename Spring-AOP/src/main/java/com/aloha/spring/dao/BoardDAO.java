package com.aloha.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.aloha.spring.dto.Board;


@Repository
public class BoardDAO {

	public List<Board> list() {
		List<Board> boardList = new ArrayList<Board>();
		boardList.add(new Board("����1", "�ۼ���1", "����1"));
		boardList.add(new Board("����2", "�ۼ���2", "����2"));
		boardList.add(new Board("����3", "�ۼ���3", "����3"));
		return boardList;
	}
	
	public Board select(int boardNo) {
		Board board = new Board("����", "�ۼ���", "����");
		board.setBoardNo(boardNo);
		return board;
	}
	
	public int insert(Board board) {
		int result = 0;
		return result;
	}
	
	public int update(Board board) {
		int result = 0;
		return result;
	}
	
	public int delete(int boardNo) {
		int result = 0;
		return result;
	}
	
}







