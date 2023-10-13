package board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import board.dto.Board;
import board.service.BoardService;
import board.service.BoardServiceImpl;
import controller.ModelView;

// /board
public class BoardController {
	
	BoardService boardService = new BoardServiceImpl();
       
	public ModelView process(HttpServletRequest request) throws Exception {
		String view = "";
		String requestURI = request.getRequestURI();
		ModelView modelView = new ModelView();
		
		// 게시글 목록
		if( requestURI.contains("list.do") ) {
			// list(request);
			list(modelView);
			// view = "/board/list.jsp";
		}
		if( requestURI.contains("insert.do") ) {
			// insert(request);
			insert(modelView);
			// view = "/board/insert.jsp";
		}
		if( requestURI.contains("insertPro.do") ) {
			// insertPro(request);
			insertPro(modelView, request);
			// view = "/board/list.do";
		}
		if( requestURI.contains("update.do") ) {
			// update(request);
			update(modelView);
			// view = "/board/update.jsp";
		}
		if( requestURI.contains("updatePro.do") ) {
			// updatePro(request);
			updatePro(modelView, request);
			// view = "/board/list.do";
		}
		if( requestURI.contains("read.do") ) {
			// read(request);
			read(modelView);
			// view = "/board/read.jsp";
		}
		if( requestURI.contains("deletePro.do") ) {
			// deletePro(request);
			deletePro(modelView, request);
			// view = "/board/list.do";
		}
		return modelView;
	}
	
	// 게시글 목록
	// private void list(HttpServletRequest request) throws Exception {
	private void list(ModelView modelView) throws Exception {
		List<Board> boardList = boardService.list();
		// request.setAttribute("boardList", boardList);
		// ModelView modelView = new ModelView();
		
		// 모델
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("boardList", boardList);
		// 뷰
		String view = "/board/list.jsp";
		modelView.addModel(model);
		modelView.setView(view);
		
		// return modelView;
	}
	
	// 게시글 조회
//	private void read(HttpServletRequest request) {
	private void read(ModelView modelView) {
		Board board = boardService.select(10);
		// request.setAttribute("board", board);
		// 모델
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("board", board);
		// 뷰
		String view = "/board/read.jsp";
		modelView.addModel(model);
		modelView.setView(view);
	}
	
	// 게시글 등록
//	private void insert(HttpServletRequest request) {
	private void insert(ModelView modelView) {
		String view = "/board/insert.jsp";
		modelView.setView(view);
	}

	// 게시글 등록 처리
//	private void insertPro(HttpServletRequest request) throws Exception {
	private void insertPro(ModelView modelView, HttpServletRequest request) throws Exception {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		Board board = new Board(title, writer, content);
		int result = boardService.insert(board);
		
		// 모델
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("result", result);
		// 뷰
		String view = "/board/list.do";
		modelView.addModel(model);
		modelView.setView(view);
		// 리다이렉트
		modelView.setRedirect(true);
	}
	
	// 게시글 수정
//	private void update(HttpServletRequest request) {
	private void update(ModelView modelView) {
		Board board = boardService.select(10);
		// request.setAttribute("board", board);
		
		// 모델
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("board", board);
		// 뷰
		String view = "/board/update.jsp";
		modelView.addModel(model);
		modelView.setView(view);
	}
	
	// 게시글 수정 처리
//	private void updatePro(HttpServletRequest request) throws Exception {
	private void updatePro(ModelView modelView, HttpServletRequest request) throws Exception {
		String boardNo = request.getParameter("boardNo");
		int no = boardNo == null ? 0 : Integer.parseInt(boardNo);
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		Board board = new Board(title, writer, content);
		board.setBoardNo(no);
		
		int result = boardService.update(board);
		// request.setAttribute("result", result);
		
		// 모델
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("result", result);
		// 뷰
		String view = "/board/list.do";
		modelView.addModel(model);
		modelView.setView(view);
		// 리다이렉트
		modelView.setRedirect(true);
	}
	
	// 게시글 삭제 처리
//	private void deletePro(HttpServletRequest request) throws Exception {
	private void deletePro(ModelView modelView, HttpServletRequest request) throws Exception {
		String boardNo = request.getParameter("boardNo");
		int no = boardNo == null ? 0 : Integer.parseInt(boardNo);
		int result = boardService.delete(no);
		// request.setAttribute("result", result);
		
		// 모델
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("result", result);
		// 뷰
		String view = "/board/list.do";
		modelView.addModel(model);
		modelView.setView(view);
		// 리다이렉트
		modelView.setRedirect(true);
	}
	
	

}





