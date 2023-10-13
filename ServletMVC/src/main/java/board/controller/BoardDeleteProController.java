package board.controller;

import javax.servlet.http.HttpServletRequest;

import board.dto.Board;
import board.service.BoardService;
import board.service.BoardServiceImpl;

public class BoardDeleteProController {
	
	BoardService boardService = new BoardServiceImpl();

	public String process(HttpServletRequest request) throws Exception {
		String boardNo = request.getParameter("boardNo");
		int no = boardNo == null ? 0 : Integer.parseInt(boardNo);
		
		// String view = "redirect:/board/list.do";
		String view = "/board/list.do";
		int result = boardService.delete(no);
		request.setAttribute("result", result);
		return view;
	}
}
