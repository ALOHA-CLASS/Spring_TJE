package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.controller.BoardController;
import board.controller.BoardDeleteProController;
import board.controller.BoardInsertController;
import board.controller.BoardInsertProController;
import board.controller.BoardListController;
import board.controller.BoardReadController;
import board.controller.BoardUpdateController;
import board.controller.BoardUpdateProController;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// jsp 응답하기
		String view = "index.jsp";
		boolean redirect = false;
		
		String requestURI = request.getRequestURI();
		String pathInfo = request.getPathInfo();
		StringBuffer requestURL = request.getRequestURL();
		System.out.println("요청 URL : " + requestURI);
		System.out.println("requestURL : " + requestURL.toString());
		System.out.println("pathInfo : " + pathInfo);
		
		if( requestURI.contains("/board") ) {
			BoardController boardController = new BoardController();
			try {
				view = boardController.process(request);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
//		if( requestURI.contains("/board/list.do") ) {
//			// BoardController 생성 및 처리
//			BoardListController boardListController = new BoardListController();
//			try {
//				view = boardListController.process(request);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		if( requestURI.contains("/board/read.do") ) {
//			// BoardReadController 생성 및 처리
//			BoardReadController boardReadController = new BoardReadController();
//			try {
//				view = boardReadController.process(request);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} 
//		if( requestURI.contains("/board/update.do") ) {
//			// BoardUpdateController 생성 및 처리
//			BoardUpdateController boardUpdateController = new BoardUpdateController();
//			try {
//				view = boardUpdateController.process(request);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		if( requestURI.contains("/board/updatePro.do") ) {
//			// BoardUpdateController 생성 및 처리
//			BoardUpdateProController boardUpdateProController = new BoardUpdateProController();
//			try {
//				view = boardUpdateProController.process(request);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			redirect = true;
//		}
//		if( requestURI.contains("/board/insert.do") ) {
//			BoardInsertController boardInsertController = new BoardInsertController();
//			try {
//				view = boardInsertController.process(request);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		if( requestURI.contains("/board/insertPro.do") ) {
//			BoardInsertProController boardInsertProController = new BoardInsertProController();
//			try {
//				view = boardInsertProController.process(request);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			redirect = true;
//		}
//		if( requestURI.contains("/board/deletePro.do") ) {
//			BoardDeleteProController boarddeleteProController = new BoardDeleteProController();
//			try {
//				view = boarddeleteProController.process(request);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			redirect = true;
//		}
//		
		if( redirect ) {
			response.sendRedirect(request.getContextPath() + "/" +  view);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}



