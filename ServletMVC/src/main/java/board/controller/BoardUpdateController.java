package board.controller;

import javax.servlet.http.HttpServletRequest;

import board.dto.Board;
import board.service.BoardService;
import board.service.BoardServiceImpl;

public class BoardUpdateController {
	
	BoardService boardService = new BoardServiceImpl();

	public String process(HttpServletRequest request) {
		// int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int boardNo = 0;
		String view = "/board/update.jsp";
		Board board = boardService.select(boardNo);
		request.setAttribute("board", board);
		return view;
	}
}
