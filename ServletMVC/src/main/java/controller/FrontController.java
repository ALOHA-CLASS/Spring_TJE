package controller;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.controller.BoardController;

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
    // doGet() : GET 메소드 방식으로 요청이 왔을 때 실행되는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// jsp 응답하기
		String view = "index.jsp";
		boolean redirect = false;
		ModelView modelView = null;
		
		String requestURI = request.getRequestURI();
		String pathInfo = request.getPathInfo();
		StringBuffer requestURL = request.getRequestURL();
		System.out.println("요청 URL : " + requestURI);
		System.out.println("requestURL : " + requestURL.toString());
		System.out.println("pathInfo : " + pathInfo);
		
		if( requestURI.contains("/board") ) {
			BoardController boardController = new BoardController();
			try {
				// view = boardController.process(request);
				modelView = boardController.process(request);
				view = modelView.getView();
				redirect = modelView.isRedirect();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 모델 등록
		createModel(modelView, request);
		
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
			// response.sendRedirect(request.getContextPath() + "/" +  view);
			response.sendRedirect(request.getContextPath() + view);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// doPost() : POST 메소드 방식으로 요청이 왔을 때 실행되는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}
	
	/**
	 * 모델 등록 메소드
	 * @param modelView
	 * @param request
	 */
	public void createModel(ModelView modelView, HttpServletRequest request) {
		if( modelView == null ) return;
		Map<String, Object> model = modelView.getModel();
		
		if( model == null ) return;
		
		Set<String> keySet = model.keySet();
		for (String key : keySet) {
			Object value = model.get(key);
			request.setAttribute(key, value);		// request.setAttribute("boardList", boardList);
		}
		
	}

}












