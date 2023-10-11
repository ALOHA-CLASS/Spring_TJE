package com.aloha.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.spring.dao.BoardDAO;
import com.aloha.spring.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<Board> list() throws Exception {
		List<Board> boardList = boardDAO.list();
		return boardList;
	}

	@Override
	public Board select(int boardNo) throws Exception {
		Board board= boardDAO.select(boardNo);
		return board;
	}

	@Override
	public int insert(Board board) throws Exception {
		int result = boardDAO.insert(board);
		return result;
	}

	@Override
	public int update(Board board) throws Exception {
		int result = boardDAO.update(board);
		return result;
	}

	@Override
	public int delete(int boardNo) throws Exception {
		int result = boardDAO.delete(boardNo);
		return result;
	}
	

}
