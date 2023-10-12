package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import board.dto.Board;
import board.service.BoardService;
import board.service.BoardServiceImpl;

public class BoardController {
	
	BoardService boardService = new BoardServiceImpl();
       
	public String process(HttpServletRequest request) throws Exception {
		String view = "";
		String requestURI = request.getRequestURI();
		
		if( requestURI.contains("list.do") ) {
			list(request);
			view = "/board/list.jsp";
		}
		if( requestURI.contains("insert.do") ) {
			insert(request);
			view = "/board/insert.jsp";
		}
		if( requestURI.contains("insertPro.do") ) {
			insertPro(request);
			view = "/board/list.do";
		}
		if( requestURI.contains("update.do") ) {
			update(request);
			view = "/board/update.jsp";
		}
		if( requestURI.contains("updatePro.do") ) {
			updatePro(request);
			view = "/board/list.do";
		}
		if( requestURI.contains("read.do") ) {
			read(request);
			view = "/board/read.jsp";
		}
		if( requestURI.contains("deletePro.do") ) {
			deletePro(request);
			view = "/board/list.do";
		}
		return view;
	}
	
	
	// 게시글 삭제 처리
	private void deletePro(HttpServletRequest request) throws Exception {
		String boardNo = request.getParameter("boardNo");
		int no = boardNo == null ? 0 : Integer.parseInt(boardNo);
		int result = boardService.delete(no);
		request.setAttribute("result", result);
	}

	// 게시글 조회
	private void read(HttpServletRequest request) {
		Board board = boardService.select(10);
		request.setAttribute("board", board);
	}
	// 게시글 수정 처리
		
	private void updatePro(HttpServletRequest request) throws Exception {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		Board board = new Board(title, writer, content);
		
		int result = boardService.update(board);
		request.setAttribute("result", result);
	}
	
	// 게시글 수정
	private void update(HttpServletRequest request) {
		Board board = boardService.select(10);
		request.setAttribute("board", board);
	}

	// 게시글 등록 처리
	private void insertPro(HttpServletRequest request) throws Exception {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		Board board = new Board(title, writer, content);
		int result = boardService.insert(board);
	}

	// 게시글 등록
	private void insert(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}
	// 게시글 목록
	private void list(HttpServletRequest request) throws Exception {
		List<Board> boardList = boardService.list();
		request.setAttribute("boardList", boardList);
	}
	
	
	
	
	

}





