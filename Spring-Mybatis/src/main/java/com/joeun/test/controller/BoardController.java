package com.joeun.test.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.joeun.test.dto.Board;
import com.joeun.test.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	// 게시글 목록
	// @RequestMapping(value = "/list", method = RequestMethod.GET)
	@GetMapping("/list")		// Spring 4.3 버전 부터 사용
	public String list(Model model) throws Exception {
		List<Board> boardList = boardService.list();
		model.addAttribute(boardList);
		return "board/list";
	}
	
	// 게시글 조회
	@GetMapping("/read")		
	public String read(Model model, int boardNo) throws Exception {
		Board board= boardService.select(boardNo);
		model.addAttribute(board);
		return "board/read";
	}
	
	// 게시글 등록
	@GetMapping("/insert")		
	public String insert() throws Exception {
		return "board/insert";
	}
	
	// 게시글 등록 처리
	@PostMapping("/insert")		
	public String insert(Board board) throws Exception {
		int result = boardService.insert(board);
		
		return "redirect:/board/list";
	}
	
	// 게시글 수정
	@GetMapping("/update")		
	public String update(Model model, int boardNo) throws Exception {
		Board board= boardService.select(boardNo);
		model.addAttribute(board);
		return "board/update";
	}
	
	// 게시글 수정 처리
	@PostMapping("/update")		
	public String update(Board board) throws Exception {
		int result = boardService.update(board);
		
		return "redirect:/board/list";
	}
	
	// 게시글 삭제 처리
	@PostMapping("/delete")		
	public String delete(int boardNo) throws Exception {
		int result = boardService.delete(boardNo);
		
		return "redirect:/board/list";
	}

}








