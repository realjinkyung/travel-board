package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontController extends HttpServlet {
	private static final String REDIRECT_PREfIX = "redirect:";

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		System.out.println("sdsd");

		System.out.println(req.getParameter("id"));
		try {
			Command command = resolveCommand(req.getServletPath(), req.getMethod());
			String view = command.execute(req, resp);

			if (view.startsWith(REDIRECT_PREfIX)) { // redirect : 
				resp.sendRedirect(view.substring(REDIRECT_PREfIX.length())); // 사용자에게 이 페이지로 다시 연결하라고 돌려보낼건지
			} else {
				RequestDispatcher rd = req.getRequestDispatcher(view); // 요청보낸 사용자가 서버 내에서 연결해서 완성된 response를 돌려줌
				rd.include(req, resp);
			}
		} catch (Exception ex) {
			System.out.printf("", ex); // ""에 ex를 담아줌

			req.setAttribute("exception", ex);

			RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
			rd.forward(req, resp);
		}
	}

	private Command resolveCommand(String servletPath, String method) {
		Command command = null;
		
		// 파라미터로 받은 servletPath가 같고 파라미터로 받은 method가 같다면
		// 새로운(?) 컨트롤러를 객체를 만들어서 command에 담아준다.
		// BoardReadController()를 실행하겠다.
		if ("/boardList.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
			command = new BoardReadController();
//		} else if("/revise.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
//			command = new UserReviseController();
		} else if ("/join.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
			command = new JoinFormContoller(); // 객체 만들기 - 회원가입
		} else if ("/login.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
			command = new LoginController(); // 객체 만들기 - 로그인
		} else if ("/post.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) { //FIXME URL
			command = new PostReadController();
		} else if ("/newPost.do".equals(servletPath) && "GET".equalsIgnoreCase(method)){ //FIXME URL
			command = new ConnectNewPostController();
		} else if ("/makePost.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) { //FIXME URL
			command = new ProducePostController();
		} else if ("/edit.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) { //FIXME URL
			command = new ConnectNewPostController();
		}
		// 위의 모든 command를 반환해준다.
		return command;
	}


}
