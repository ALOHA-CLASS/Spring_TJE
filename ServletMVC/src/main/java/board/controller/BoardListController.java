package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import board.dto.Board;
import board.service.BoardService;
import board.service.BoardServiceImpl;

public class BoardListController {
	
	BoardService boardService = new BoardServiceImpl();
       
	public String process(HttpServletRequest request) throws Exception {
		List<Board> boardList = boardService.list();
		request.setAttribute("boardList", boardList);
		String view = "/board/list.jsp";
		return view;
	}

}





