package com.joeun.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joeun.test.dao.BoardDAO;
import com.joeun.test.dto.Board;

@Service			// 비즈니스 로직 객체로 빈 등록
public class BoardServiceImpl implements BoardService {
	
	@Autowired			// 의존성 자동 주입
	private BoardDAO boardDAO;

	@Override
	public List<Board> list() throws Exception {
		System.out.println("게시글 목록을 조회합니다.");
		
		List<Board> boardList = boardDAO.list();
		// System.out.println("info");
		// logger.error("error");
		// logger.warn("warn");
		int count = boardList.size();
		System.out.println("boardList 요소 개수 : " + count);
		
		System.out.println("게시글 목록을 반환합니다.");
		return boardList;
	}

	@Override
	public Board select(int boardNo)  {
		Board board = boardDAO.select(boardNo);
//		String title = com.joeun.test.getTitle();
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
