package com.aloha.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.spring.dao.BoardDAO;
import com.aloha.spring.dto.Board;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	public List<Board> list() {

		return boardDAO.list();
	}

}






