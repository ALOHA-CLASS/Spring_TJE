package com.joeun.test.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joeun.test.HomeController;
import com.joeun.test.dto.Board;
import com.joeun.test.mapper.BoardMapper;

@Service			// 비즈니스 로직을 처리하는 서비스 클래스로 빈 등록
public class BoardServiceImpl implements BoardService {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<Board> list() throws Exception {
		List<Board> boardList = boardMapper.list();
		return boardList;
	}

	@Override
	public Board select(int boardNo) throws Exception  {
		Board board = boardMapper.select(boardNo);
		return board;
	}

	@Override
	public Integer insert(Board board) throws Exception {
		int result = boardMapper.insert(board);
		return result;
	}

	@Override
	public Integer update(Board board) throws Exception {
		int result = boardMapper.update(board);
		return result;
	}

	@Override
	public Integer delete(int boardNo) throws Exception {
		int result = boardMapper.delete(boardNo);
		return result;
	}

}