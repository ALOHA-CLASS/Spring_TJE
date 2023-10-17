package com.joeun.test.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.joeun.test.dto.Board;
import com.joeun.test.dto.User;
import com.joeun.test.service.BoardService;

@Controller
@RequestMapping("/request")
public class RequestController {
	
	private static final Logger logger = LoggerFactory.getLogger(RequestController.class);
	
	// 업로드 경로
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String request() {
		logger.info("[GET] - /request/board");
		
		return "request/board";
	}
	
	@ResponseBody
	@RequestMapping(value = "/board", method = RequestMethod.POST)
	// public String requestPost(@RequestParam("boardNo") int boardNo) {
	public String requestPost(int boardNo) {
		logger.info("[POST] - /request/board");
		logger.info("boardNo : " + boardNo);
		
		return "SUCCESS";
	}
	
	@ResponseBody
	@RequestMapping(value = "/board/{boardNo}", method = RequestMethod.GET)
	public String requestPath(@PathVariable("boardNo") int boardNo) {
		logger.info("[GET] - /request/board/{boardNo}");
		logger.info("boardNo : " + boardNo);
		
		return "SUCCESS";
	}
	
	@ResponseBody
	@RequestMapping(value = "/header", method = RequestMethod.GET)
	public String requestHeader(@RequestHeader("Accept") String accept
							   ,@RequestHeader("User-Agent") String userAgent
							   ,HttpServletRequest request) {
		// @RequestHeader : 헤더명을 지정하여 헤더 값을 가져오는 어노테이션
		// * @RequestHeader("헤더명") 타입 매개변수명
		logger.info("[GET] - /request/header");
		logger.info("@RequestHeader 를 통한 헤더 정보 가져오기");
		logger.info("Accept : " + accept);
		logger.info("User-Agent : " + userAgent);
		
		String requestAccept = request.getHeader("Accept");
		String requestUserAgent = request.getHeader("User-Agent");
		logger.info("HttpServletRequest 를 통한 헤더 정보 가져오기");
		logger.info("Accept : " + requestAccept);
		logger.info("User-Agent : " + requestUserAgent);
		
		return "SUCCESS";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/body", method = RequestMethod.POST)
	// public String requestBody(@RequestBody Board board) {
	public String requestBody(Board board) {
		// @RequestBody
		// : HTTP 요청 메시지 본문(body)의 내용을 객체로 변환하는 어노테이션
		//   클라이언트에서 contentType: JSON 형식에 데이터를 보내는 경우에 객체로 변환하기 위해 쓴다.
		// * 생략가능 (주로 생략하고 쓴다.)
		logger.info("[POST] - /request/body");
		logger.info(board.toString());
		
		
		return "SUCCESS";
	}
	
	// check
	@ResponseBody
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public String requestCheck(@RequestParam("hobby") String[] hobbies) {
		// 체크박스 다중 데이터는 배열로 전달받을 수 있다.
		logger.info("[POST] - /request/check");

		
		for (String hobby : hobbies) {
			logger.info("hobby : " + hobby);
		}
		
		return "SUCCESS";
	}
	
	
	// user
	/**
	 * 요청 경로 : /request/user
	 * 요청 파라미터 
	 * - id		: ?
	 * - name   : ?
	 * - hobby  : exercise
	 * - hobby  : movie
	 * - hobby  : coding
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	// public String requestCheck(String id, String name, String[] hobby) {
	// type="date" => 2023-10-16 형식으로 전달  
	// public String requestCheck(User user, @DateTimeFormat(pattern="yyyy-MM-dd") Date birth) {
	public String requestCheck(User user) {
		// 체크박스 다중 데이터는 배열로 전달받을 수 있다.
		logger.info("[POST] - /request/user");
		
		logger.info(user.toString());
		// logger.info(birth.toString());
		
		String[] hobbies = user.getHobby();
		for (String hobby : hobbies) {
			logger.info("hobby : " + hobby);
		}
		
		return "SUCCESS";
	}
	
	// Map 
	@ResponseBody
	@RequestMapping("/map")
	public String requestMap(@RequestParam Map<String, String> map) {
		String name = map.get("name");
		String age = map.get("age");
		
		logger.info("name : " + name);
		logger.info("age : " + age);
		return "SUCCESS";
	}
	
	
	
	
	// 파일 업로드
	@ResponseBody
	@RequestMapping("/file")
	public String fileUpload(MultipartFile file) throws IOException {
		logger.info("/request/file");
		logger.info("uploadPath : " + uploadPath);
		if( file == null ) return "FAIL";
		
		logger.info("originalFileName : " + file.getOriginalFilename());
		logger.info("size : " + file.getSize());
		logger.info("contentType : " + file.getContentType());
		
		byte[] fileData = file.getBytes();
		
		// 파일 업로드
		// String filePath = "E:\\TJE\\UPLOAD";
		String filePath = uploadPath;
		String fileName = file.getOriginalFilename();
		File uploadFile = new File(filePath, fileName);
		FileCopyUtils.copy(fileData, uploadFile);			// 파일 업로드	
		// FileCopyUtils.copy()
		// - 내부적으로 InputStream, OutputStream 을 이용하여 입력받은 파일을 출력할 수 있다.
		
		return "SUCCESS";
	}
	
	
	// 다중 파일 업로드
	@ResponseBody
	@RequestMapping("/file/multi")
	public String fileUpload(@RequestParam("file") MultipartFile[] fileList) throws IOException {
	// public String fileUpload(@RequestParam("file") List<MultipartFile> fileList) throws IOException {
		logger.info("/request/file/multi");
		logger.info("uploadPath : " + uploadPath);
		if( fileList == null ) return "FAIL";
		
		// if( !fileList.isEmpty() ) 
		if( fileList.length > 0 ) 
			for (MultipartFile file : fileList) {
				logger.info("originalFileName : " + file.getOriginalFilename());
				logger.info("size : " + file.getSize());
				logger.info("contentType : " + file.getContentType());
				
				byte[] fileData = file.getBytes();
				
				String filePath = uploadPath;
				String fileName = file.getOriginalFilename();
				File uploadFile = new File(filePath, fileName);
				FileCopyUtils.copy(fileData, uploadFile);			// 파일 업로드	
			}
		return "SUCCESS";
	}

	
	// 게시판 파일 업로드
	@ResponseBody
	@RequestMapping("/file/board")
	public String fileUploadBoard(Board board) throws IOException {
		logger.info("/request/file/board");
		logger.info("uploadPath : " + uploadPath);
		logger.info(board.toString());
		
		List<MultipartFile> fileList = board.getFile();
		
		if( fileList == null ) return "FAIL";
		
		if( !fileList.isEmpty() ) 
			for (MultipartFile file : fileList) {
				logger.info("originalFileName : " + file.getOriginalFilename());
				logger.info("size : " + file.getSize());
				logger.info("contentType : " + file.getContentType());
				
				byte[] fileData = file.getBytes();
				
				String filePath = uploadPath;
				String fileName = file.getOriginalFilename();
				File uploadFile = new File(filePath, fileName);
				FileCopyUtils.copy(fileData, uploadFile);			// 파일 업로드
			}
		return "SUCCESS";
	}
	
	
	
	// AJAX 파일 업로드
	@RequestMapping("/ajax")
	public String ajaxUpload() {
		
		
		return "request/ajax";			// view : request/ajax.jsp
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/ajax", method = RequestMethod.POST)
	public String ajaxUploadPost(Board board) throws IOException {
		logger.info("/request/ajax");
		logger.info("uploadPath : " + uploadPath);
		logger.info(board.toString());
		
		List<MultipartFile> fileList = board.getFile();
		
		if( fileList == null ) return "FAIL";
		
		if( !fileList.isEmpty() ) 
			for (MultipartFile file : fileList) {
				logger.info("originalFileName : " + file.getOriginalFilename());
				logger.info("size : " + file.getSize());
				logger.info("contentType : " + file.getContentType());
				
				byte[] fileData = file.getBytes();
				
				String filePath = uploadPath;
				String fileName = file.getOriginalFilename();
				File uploadFile = new File(filePath, fileName);
				FileCopyUtils.copy(fileData, uploadFile);			// 파일 업로드
			}
		return "SUCCESS";
	}
	
	
	

}


















