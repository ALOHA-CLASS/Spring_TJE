package com.joeun.test.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.joeun.test.dto.Board;
import com.joeun.test.service.BoardService;

@Controller						// MVC 컨트롤러 빈으로 설정
@RequestMapping("/board")		// 클래스 레벨 요청 경로 매핑
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired					// 의존성 자동 주입
	private BoardService boardService;
	
	/**
	 * 게시글 목록
	 * value : /board/list
	 * value : /board
	 * @return
	 * @throws Exception 
	 */
	// @RequestMapping("/list")	// 메소드 레벨 요청 경로 매핑
	@RequestMapping("")			// 메소드 레벨 요청 경로 매핑
	public String list(Model model) throws Exception {		// Model : 데이터 전달 객체
		// 게시글 목록 요청
		List<Board> boardList = boardService.list();
		
		// 모델 등록
		model.addAttribute("boardList", boardList);			// 모델에 데이터 등록
		
		return "board/list";		// board/list.jsp 뷰로 선택
	}
	
	// Accept : application/json
	@RequestMapping(value = "/list", produces="application/json")
	public ResponseEntity<List<Board>> listJSON() throws Exception {
			List<Board> boardList = boardService.list();
	    return new ResponseEntity<List<Board>>(boardList, HttpStatus.OK);
	}
	
	// Accept : application/xml
	@RequestMapping(value = "/list", produces="application/xml")
	public ResponseEntity<List<Board>> listXML() throws Exception {
			List<Board> boardList = boardService.list();
	    return new ResponseEntity<List<Board>>(boardList, HttpStatus.OK);
	}
	
	/**
	 * 게시글 조회
	 * value : /board/read
	 * @return
	 */
	// @RequestParam("파라미터명")  : 요청 파라미터를 매핑하는 어노테이션 
	// @RequestMapping("/read")	// 메소드 레벨 요청 경로 매핑
	// 다중 경로 매핑 : {"경로1", "경로2"}
	@RequestMapping(value ={"/read", "/select"}, method = RequestMethod.GET, params = "boardNo")  // 요청파라미터 매핑
	public String read(@RequestParam("boardNo") int boardNo, Model model) {
		logger.info("boardNo : " + boardNo);
		// 게시글 데이터 요청
		Board board = boardService.select(boardNo);
		
		// 모델 등록
		model.addAttribute("board", board);		// JSP 에서 ${board} 로 접근
		
		return "board/read";		// board/read.jsp 뷰로 선택
	}
	
	
	
	/**
	 * 게시글 조회
	 * value : /board/{boardNo}
	 * @return
	 */
	@RequestMapping(value ="/{boardNo}", method = RequestMethod.GET)  // 경로 패턴 매핑
	// public String readPath(@PathVariable("boardNo") int boardNo, Model model) {
	// @PathVariable("요청파라미터명") 메소드매개변수명
	// * 요청파라미터명 = 메소드매개변수명 같으면, () 는 생략해도 된다.
	public String readPath(@PathVariable int boardNo, Model model) {
		logger.info("boardNo : " + boardNo);
		// 게시글 데이터 요청
		Board board = boardService.select(boardNo);
		
		// 모델 등록
		model.addAttribute("board", board);		// JSP 에서 ${board} 로 접근
		
		return "board/read";		// board/read.jsp 뷰로 선택
	}
	
	/**
	 * 게시글 등록
	 * value : /board/insert
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)	// 메소드 레벨 요청 경로 매핑
	public String insert() {
		
		return "board/insert";		// board/insert.jsp 뷰로 선택
	}
	
	/**
	 * 게시글 등록 처리
	 * value : /board/insert
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)	// 메소드 레벨 요청 경로 매핑
	public String insertPro() {
		
		return "redirect:/board/list";		// board/list.jsp 로 리다이렉트
	}
	
	
	/**
	 * 게시글 등록 처리
	 * value 		: /board/insert
	 * method 		: POST
	 * contentType 	: application/json 
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> insertProJSON() {
		
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);		// 200 OK. "SUCCESS" 응답 메시지
	}
	
	/**
	 * 게시글 수정
	 * value : /board/update
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)	// 메소드 레벨 요청 경로 매핑
	public String update(@RequestParam("boardNo") int boardNo, Model model) {
		logger.info("boardNo : " + boardNo);
		// 게시글 데이터 요청
		Board board = boardService.select(boardNo);
		
		// 모델 등록
		model.addAttribute("board", board);		// JSP 에서 ${board} 로 접근
		
		return "board/update";		// board/update.jsp 뷰로 선택
	}
	
	/**
	 * 게시글 수정 처리 
	 * value : /board/update
	 * method : POST
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)	// 메소드 레벨 요청 경로 매핑
	public String updatePro() {
		logger.info("method : POST");
		return "redirect:/board/list";		// board/list.jsp 로 리다이렉트
	}
	
	
	/**
	 * 게시글 수정 처리 
	 * value 	: /board/update
	 * method 	: POST
	 * headers 	: X-HTTP-Method-Override=PUT
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST, headers = "X-HTTP-Method-Override=PUT")	
	public String updateProHeader() {
		logger.info("method : POST");
		logger.info("headers = \"X-HTTP-Method-Override=PUT\" ");
		return "redirect:/board/list";		// board/list.jsp 로 리다이렉트
	}
	
	/**
	 * 게시글 수정 처리 
	 * value : /board/update
	 * method : PUT
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT)	// 메소드 레벨 요청 경로 매핑
	public String updateProPut() {
		logger.info("method : PUT");
		
		return "redirect:/board/list";		// board/list.jsp 로 리다이렉트
	}
	
	/**
	 * 게시글 삭제 처리
	 * value : /board/delete
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)	// 메소드 레벨 요청 경로 매핑
	public String delete() {
		
		return "redirect:/board/list";		// board/list.jsp 로 리다이렉트
	}

}







