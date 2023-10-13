package board.controller;

import javax.servlet.http.HttpServletRequest;

import board.dto.Board;
import board.service.BoardService;
import board.service.BoardServiceImpl;

public class BoardInsertProController {
	
	BoardService boardService = new BoardServiceImpl();

	public String process(HttpServletRequest request) throws Exception {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		Board board = new Board(title, writer, content);
		
		// String view = "redirect:/board/list.do";
		String view = "/board/list.do";
		int result = boardService.insert(board);
		request.setAttribute("result", result);
		return view;
	}
}
