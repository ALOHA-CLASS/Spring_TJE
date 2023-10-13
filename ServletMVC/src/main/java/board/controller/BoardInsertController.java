package board.controller;

import javax.servlet.http.HttpServletRequest;

import board.dto.Board;
import board.service.BoardService;
import board.service.BoardServiceImpl;

public class BoardInsertController {
	
	public String process(HttpServletRequest request) {
		String view = "/board/insert.jsp";
		return view;
	}
}
