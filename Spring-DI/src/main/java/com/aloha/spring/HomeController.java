package com.aloha.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aloha.spring.bean.Config;
import com.aloha.spring.dao.BoardDAO;
import com.aloha.spring.dto.Board;
import com.aloha.spring.service.BoardService;

/**
 * Handles requests for the application home page.
 * 애플리케이션 홈 페이지에 대한 요청을 처리합니다.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	@Qualifier("board")		// 빈의 이름을 지정하여 의존성 주입
	private Board board;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * 뷰의 이름을 반환하여 홈 뷰를 렌더링하도록 간단하게 선택합니다.
	 */
	// @RequestMapping : 요청 경로 매핑 어노테이션
	// value 	: URL 경로
	// method 	: 메소드 요청 방식 (GET, POST, PUT, DELETE)
	// / 경로로 [GET] 방식으로 요청이 왔을 때, home 메소드를 실행 하도록 요청 경로를 매핑
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);

		List<Board> boardList = boardService.list();
		model.addAttribute("boardList", boardList);
		
		model.addAttribute("board", board);
		
		model.addAttribute("serverTime", formattedDate );
		
		// Config.java 설정파일로 IoC 컨테이너 생성 
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		// @Bean(name="gallery") 로 등록된 빈 가져오기
		Board gallery = context.getBean("gallery", Board.class);
		Board gallery2 = (Board) context.getBean("gallery");
		
		if( gallery == gallery2 )  
			logger.info("gallery == gallery2 같은 인스턴스 : 빈");
		
		model.addAttribute("gallery", gallery);
		
		// ClassPathXmlApplicationContext --> classpath 경로는 src/main/resources
		ApplicationContext context2 = new ClassPathXmlApplicationContext("root-context.xml"); // XML 파일 경로 지정
		BoardDAO baordDAO = context2.getBean(BoardDAO.class);
		List<Board> boardList2 = baordDAO.list();
		for (Board board : boardList2) {
			logger.info(board.toString());
		}
		
		
		return "home";		// 뷰 이름만 반환 --> /WEB-INF/views/home.jsp
	}
	
}















