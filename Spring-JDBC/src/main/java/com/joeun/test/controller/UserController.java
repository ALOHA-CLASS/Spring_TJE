package com.joeun.test.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.joeun.test.dto.User;
import com.joeun.test.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	// 로그인 화면
	@GetMapping("/login")		
	public String login() throws Exception {
		return "user/login";
	}
	
	// 회원가입 화면
	@GetMapping("/join")		
	public String join() throws Exception {
		return "user/join";
	}
	
	
	// 로그인 처리
	@PostMapping("/login")		
	public String loginPro(User user, HttpSession session) throws Exception {
		User loginUser = userService.login(user);
		
		// 로그인 성공
		if( loginUser != null )
			session.setAttribute("userId", loginUser.getUserId());
		// 로그인 실패
		else 
			return "redirect:/user/login?error";
		
		return "redirect:/";
	}
	
	// 회원가입 처리
	@PostMapping("/join")		
	public String joinPro(User user, HttpSession session) throws Exception {
		int result = userService.insert(user);
		
		// 회원가입 성공
		if( result > 0 ) {
			// 로그인 처리 하고 메인으로 이동
//			session.setAttribute("userId", user.getUserId());
//			return "redirect:/";
			// 로그인 페이지로 이동
			return "redirect:/user/login";
		}
		// 회원가입 실패
		else
			return "redirect:/user/join";
			
		
	}
	

}








