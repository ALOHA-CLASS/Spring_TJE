package board.controller;

import javax.servlet.http.HttpServletRequest;

import board.dto.Board;
import board.service.BoardService;
import board.service.BoardServiceImpl;

public class BoardReadController {
	
	BoardService boardService = new BoardServiceImpl();

	public String process(HttpServletRequest request) {
		String view = "/board/read.jsp";
		Board board = boardService.select(10);
		request.setAttribute("board", board);
		return view;
	}
	

}
