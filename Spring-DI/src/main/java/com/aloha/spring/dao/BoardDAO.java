package com.aloha.spring.dao;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Component;
import com.aloha.spring.dto.Board;

public class BoardDAO {
	
	public List<Board> list() {
		List<Board> boardList = new ArrayList<Board>();
		
		boardList.add(new Board("제목1", "작성자1", "내용1"));
		boardList.add(new Board("제목2", "작성자2", "내용2"));
		boardList.add(new Board("제목3", "작성자3", "내용3"));
		
		return boardList;
	}

}
